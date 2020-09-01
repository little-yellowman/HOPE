<template>
<div>
    <el-upload
            class="upload-demo login-box"
            drag
            action="http://127.0.0.1:8081/ssss/screenshot/upload"
            multiple :on-success="success" :on-error="error" :before-upload="isUploaded" 
			:data="screenshot"
			:headers="token">
			<div class="el-upload__tip" slot="tip">
				<el-select v-model="screenshot.taskidScrnsht" placeholder="请选择要提交的标题" size="mini" class="selectTask">
				    <el-option
				      v-for="item in taskList"
				      :key="item.sstId"
				      :label="item.info"
				      :value="item.sstId"
				      :disabled="item.disabled">
				    </el-option>
				  </el-select>
				  <div class="el-upload__tip admin" slot="tip" @click="pushUrl()">
					  <el-button type="infor" size="mini" class="monitor">
						  班长？点击这里
					  </el-button>
				  </div>
			</div>
        <i class="el-icon-upload" :hidden="hidden"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <!-- <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div> -->
		
		
    </el-upload>
</div>
</template>

<script>
    export default {
        name: "screenshots",
		data(){
			return{
				token:{token:window.sessionStorage.getItem("token")},
				hidden:false,
				taskList:[
					
				],
				screenshot:{
					path:'',
					submitted: true,
					taskidScrnsht:'',
					studentidScrnsht:''
				}
			}
		},
		methods:{
			success(response, file, fileList){
				// console.log(response)
				this.hidden = true
				this.$message.success(response.msg)
			},
			error(err, file, fileList){
				this.$message.error(err.msg)
			},
			async isUploaded(file){
				let {data:res} = await this.$http.get('/screenshot/isuploaded',{
					params:{taskId:this.screenshot.taskidScrnsht}
				})
				// console.log(res)
				// if(res===false){
				// 	this.$message.warning("你已经提交过了，不用重复提交")
				// 	return false
				// }else{ 
				// 	return false
				// }
			},
			// 如果返回结果为true是班长，就跳转
			async pushUrl(){
				let {data:res} =await this.$http.get('/student/ismonitor')
				if(res===true){
					this.$router.push('/admin')
				}else{
					this.$message.warning("没有访问权限")
				}
				
			},
			// 根据班长id获取所有截图任务，让同学选择
			async getTasks(){
				let token =  {'mntName':window.sessionStorage.getItem('token')}
				let {data: res} = await this.$http.post('/task/tasks',token)
				this.taskList = res
			}
		},
		created() {
			
			this.getTasks();
		}
	}
</script>

<style scoped>
    .login-box {
        border: 1px solid #DCDFE6;
        width: 350px;
        margin: 180px auto;
        padding: 35px 35px 15px 35px;
        border-radius: 5px;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        box-shadow: 0 0 25px #909399;
    }
	.admin{
		float: right;
		font-size: 12px;
	}
	.selectTask{
		width: 70%;
	}
	.monitor{
		margin: 0 0;
		padding: 0 0;
	}
	
</style>