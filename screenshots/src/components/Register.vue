<template>
    <div>
        <el-form ref="ruleForm" :model="ruleForm" size="small" :rules="rules" label-width="80px" class="login-box">
            <h3 class="login-title">注册</h3>
            <el-form-item label="学号" prop="stuId">
                <el-input type="text" placeholder="请输入学号" v-model="ruleForm.stuId"/>
            </el-form-item>
            <el-form-item label="姓名" prop="stuName">
                <el-input type="text" placeholder="请输入姓名" v-model="ruleForm.stuName"/>
            </el-form-item>
            <el-form-item label="学院">
                <el-select  v-model="college" filterable placeholder="请选择">
                    <el-option
                            v-for="item in collegeList"
                            :key="item.collegeId"
                            :label="item.collegeId"
                            :value="item.collegeId">
                    </el-option>
                </el-select>
            </el-form-item>
			<el-form-item label="年级">
			    <el-select v-model="ruleForm.grade" filterable placeholder="请选择">
			        <el-option
			                v-for="item in options"
			                :key="item.value"
			                :label="item.label"
			                :value="item.value">
			        </el-option>
			    </el-select>
			</el-form-item>
            <el-form-item label="专业" :hidden="hiddenMajor">
                <el-select v-model="majorCode" filterable placeholder="请选择">
                    <el-option
                            v-for="item in majorList"
                            :key="item.majorcode"
                            :label="item.mjrName"
                            :value="item.majorcode">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="班级" :hidden="hiddenClass">
                <el-select v-model="ruleForm.monitoridStu" filterable placeholder="请选择">
                    <el-option
                            v-for="item in classList"
                            :key="item.monitoridClass"
                            :label="item.className"
                            :value="item.monitoridClass">
                    </el-option>
                </el-select>
            </el-form-item>
			
		  <el-form-item label="密码" prop="pass">
			<el-input type="password" v-model="ruleForm.stuPassword" autocomplete="off"></el-input>
		  </el-form-item>
		  <el-form-item label="确认密码" prop="checkPass">
			<el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
		  </el-form-item>
            <el-form-item>
                 <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Register",
        data() {
			var validatePass = (rule, value, callback) => {
			        if (value === '') {
			          callback(new Error('请输入密码'));
			        } else {
			          if (this.ruleForm.checkPass !== '') {
			            this.$refs.ruleForm.validateField('checkPass');
			          }
			          callback();
			        }
			      };
			      var validatePass2 = (rule, value, callback) => {
			        if (value === '') {
			          callback(new Error('请再次输入密码'));
			        } else if (value !== this.ruleForm.stuPassword) {
			          callback(new Error('两次输入密码不一致!'));
			        } else {
			          callback();
			        }
			      };
				  
            return {
                ruleForm: {
					stuId:'',
                    stuName: '',
					stuPassword:'',
					grade:'',
					monitoridStu:'',
					collegenameStu:'',
					majornameStu:'',
                    checkPass: '',
                },

                // 表单验证，需要在 el-form-item 元素中增加 prop 属性
                rules: {
                    stuId: [
                        {required: true, message: '学号不可为空', trigger: 'blur'}
                    ],
					stuName: [
					    {required: true, message: '姓名不可为空', trigger: 'blur'}
					],
                    pass: [
						{ validator: validatePass, trigger: 'blur' }
					 ],
					checkPass: [
						{ validator: validatePass2, trigger: 'blur' }
					],

                },
                // 对话框显示和隐藏
                // dialogVisible: false,
                options: [{
                    value: '2017',
                    label: '2017'
                }, {
                    value: '2018',
                    label: '2018'
                }, {
                    value: '2019',
                    label: '2019'
                }, {
                    value: '2020',
                    label: '2020'
                }],
                // value8: '选项1',
				collegeList:[],
				majorList:[],
				college:'',
				hiddenMajor:true,
				majorCode:'',
				classList:[],
				hiddenClass:true
            }
        },
        methods: {
            submitForm(formName) {
			   this.$refs[formName].validate((valid) => {
				 if (valid) {
					this.onRegister()
				   // alert('submit!');
				 } else {
				   // console.log('error submit!!');
				   return false;
				 }
			   });
			 },
            onRegister:async function () {
				let {data: res} = await this.$http.post('/student/register',this.ruleForm)
				if(res.code === 0){
					this.$message.success("注册成功！")
					this.$router.push('/login')
				}else{
					this.$message.error(res.msg)
				}
                
            },
			async findAllCollege(){
				const {data : res} = await this.$http.get('/college/findAll')
				this.collegeList = res
				// console.log(res)
			}
		
        },
		created() {
			this.findAllCollege()
		},
		watch:{
			college:async function(){
				this.hiddenMajor = false
				this.ruleForm.collegenameStu = this.college
				let {data : r} = await this.$http.get('/major/findMajors/',{
					params:{collegenameStu:this.college}
				})
				this.majorList = r
				
				// console.log(r)
			},
			majorCode:async function(){
				this.hiddenClass = false
				for(let index in this.majorList){
					if(this.majorList[index].majorcode == this.majorCode){
						this.ruleForm.majornameStu = this.majorList[index].mjrName
					}
				}
				let {data: res} = await this.$http.get('/banji/findClass',{
					params:{
						grade:this.ruleForm.grade,
						majorId:this.majorCode
					}
				})
				this.classList = res
				// console.log(res)
			}
		}
    }
</script>

<style scoped>
    .login-box {
        border: 1px solid #DCDFE6;
        width: 350px;
        margin: 50px auto;
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