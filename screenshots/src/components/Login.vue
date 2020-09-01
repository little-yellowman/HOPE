<template>
    <div>
        <el-form ref="loginForm" :model="form" :rules="rules" label-width="80px" class="login-box">
            <h3 class="login-title">欢迎登录</h3>
            <el-form-item label="学号" prop="stuId">
                <el-input type="text" placeholder="请输入学号" v-model="form.stuId"/>
            </el-form-item>
            <el-form-item label="密码" prop="stuPassword">
                <el-input type="password" placeholder="请输入密码" v-model="form.stuPassword"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" v-on:click="onSubmit('loginForm')">登录</el-button>
                <el-button type="primary" plain v-on:click="onRegister()">注册</el-button>
            </el-form-item>
        </el-form>

        <el-dialog
                title="温馨提示"
                :visible.sync="dialogVisible"
                width="30%"
                :before-close="handleClose">
            <span>{{msg}}</span>
            <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                form: {
                    stuId: '',
                    stuPassword: ''
                },
				msg:'请输入学号和密码',

                // 表单验证，需要在 el-form-item 元素中增加 prop 属性
                rules: {
                    stuId: [
                        {required: true, message: '学号不可为空', trigger: 'blur'}
                    ],
                    stuPassword: [
                        {required: true, message: '密码不可为空', trigger: 'blur'}
                    ]
                },

                // 对话框显示和隐藏
                dialogVisible: false
            }
        },
        methods: {
            onSubmit(formName) {
                // 为表单绑定验证功能
				// console.log(this)//把this对象打印出来了解更多信息
                this.$refs[formName].validate(async(valid) => {
                    if (valid) {
                        // 使用 vue-router 路由到指定页面，该方式称之为编程式导航
						const result = await this.$http.post("student/login",this.form)
						// const {data:res} = await this.$http.post("student/login",this.form)
						// console.log(result)
						if(result.data.result.code === 0) {
							if(window.sessionStorage.getItem('token')){
								window.sessionStorage.removeItem('token')
							}
							
							window.sessionStorage.setItem('token',result.data.token)
							this.$router.push("/upload");
						}
                        else {
							this.msg = result.data.result.msg;
							this.dialogVisible = true;
							return false;
						}
                    } else {
                        this.dialogVisible = true;
                        return false;
                    }
                });
            },
            onRegister:function () {
                this.$router.replace('/register')
            },
			handleClose(done) {
				this.$confirm('确认关闭？')
				  .then(_ => {
					done();
				  })
				  .catch(_ => {});
			  }
				
        }
    }
</script>

<style  scoped>
    .login-box {
        border: 1px solid #DCDFE6;
        width: 350px;
        margin: 12% auto;
        padding: 35px 35px 15px 35px;
        border-radius: 5px;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        box-shadow: 0 0 25px #909399;
    }

    .login-title {
        text-align: center;
        margin: 0 auto 40px auto;
        color: #303133;
    }
</style>