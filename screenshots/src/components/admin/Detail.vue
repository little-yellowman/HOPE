<template>
<div>
<el-form  label-width="60px" class="demo-ruleForm">
	<el-form-item label="标题" >
	    <el-select v-model="taskId" placeholder="选择要查看的标题">
	      <el-option
	              v-for="item in taskList"
	              :key="item.sstId"
	              :label="item.info"
	              :value="item.sstId">
	      </el-option>
	    </el-select>
	 </el-form-item>
</el-form>
<el-button class="dowload" type="success" v-on:click="download()" :disabled="disabled">Download All</el-button>
	<div class="imgCon" v-for="(item, index) in imgUrl.slice((currentPage-1) * pageSize,currentPage * pageSize)" :key="item.scrnshtId">
		<div class="demo-image__preview">
		<el-image 
			style="width: 90px; height: 190px"
			:src="item.path" 
			:preview-src-list="item.srcList">
		</el-image>
		</div>
		<div class="imgName">{{item.studentidScrnsht+'-'+item.student.stuName}}</div>
	</div>
	<div style="width: 100%;">
	<el-pagination class="pagination"
		background
		layout="prev, pager, next"
		:current-page="currentPage"
		@current-change="currentChangeHandle"
		:total="total" :page-size="pageSize">
	</el-pagination>
	</div>
</div>
</template>

<script>
export default {
	data() {
	  return {
		  imgUrl:[
			 //  {url: 'http://localhost:8081/ssss/img/数学与计算机科学学院/计算机科学与技术-2017计算机科学与技术/201713453131袁宇林.png',
			 //  srcList: [
			 //    'http://localhost:8081/ssss/img/1597909069174/201713453131袁宇林.png'
				// ],
				// id:1
			 //  },
			
		  ],
		disabled:true,
		taskId:'',
		taskList:[
			
		],
		total:100,
		pageSize:5,
		currentPage:1
	  }
	},
	methods:{
		async getTasks(){
			let token =  {'mntName':window.sessionStorage.getItem('token')}
			let {data: res} = await this.$http.post('/task/tasks',token)
			this.taskList = res
			// console.log(res)
		},
		currentChangeHandle(currentPage){
			this.currentPage = currentPage
		},
		async findAll(){
			let {data:res} = await this.$http.get('/screenshot/findAll',{
				params:{taskId:this.taskId}
			})
			this.imgUrl = res
		},
		async download(){
			let {data:res} = await this.$http.get('/monitor/download',{
				params:{taskId:this.taskId}
			})
			if(res.code === 0){
				window.open(res.data)
			}else{
				this.$message.error("下载失败~")
			}
			
		}
	},
	created(){
		
		this.getTasks()
	},
	watch:{
		taskId: async function(){
			this.disabled = false
			let {data:res} = await this.$http.get('/screenshot/findAll',{
				params:{taskId:this.taskId}
			})
			this.imgUrl = res
			this.total = res.length
			// console.log(res)
		}
	}
  }
</script>

<style scoped="scoped">
	.imgCon{
		width: 90px;
		height: 175px;
		/* background-color: red; */
		/* margin-right: 11px;
		margin-bottom: 32px; */
		margin: 20px 10px;
		float: left;
		box-shadow: 0 0 10px #909399;
	}
	.imgName{
		width: 100px;
		font-size: 12px;
		/* background-color: green; */
		color: #303133;
		white-space: normal;
		text-overflow: ellipsis;
		overflow: hidden;
		line-height: 12px;
		height: 24px;
		
		margin-top: 5px;
	}
	.pagination{
		position: absolute;
		bottom: 5px;
		width: 80%;
		margin-left: 10%;
	}
	.dowload{
		position: absolute;
		top: 18px;
		right: 5px;
		float: right;
	}
</style>
