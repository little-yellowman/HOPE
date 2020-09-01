<template>
	<div>
		<el-table
		        :data="tableData"
						  size="mini"
		        >
		    <el-table-column
		            type="index"
		            width="50">
		    </el-table-column>
		   <!-- <el-table-column
		            prop="date"
		            label="日期"
		            sortable
		            width="150">
		    </el-table-column> -->
		    <el-table-column
		            prop="stuName"
		            label="姓名"
		            width="120">
		    </el-table-column>
		    <el-table-column
							  sortable
		            prop="stuId"
		            label="学号"
		            width="150">
		    </el-table-column>
		    <el-table-column
		            prop="screenshot.submitted"
		            label="状态"
		            width="80"
		            :filters="[{ text: '已上传', value: true }, 
										 { text: '未上传', value: false }]"
		            :filter-method="filterTag"
		            filter-placement="bottom-end">
		        <template slot-scope="scope">
		            <el-tag
		                    :type="scope.row.screenshot.submitted !== null ? 'success' : 'warning'"
		                    close-transition>{{scope.row.screenshot.submitted ? '已上传' : '未上传'}}</el-tag>
		        </template>
		    </el-table-column>
			<el-table-column
				  align="right">
				  <template slot="header" slot-scope="scope">
					<el-select v-model="taskId" placeholder="选择要查看的标题" size="mini">
					    <el-option
					      v-for="item in taskList"
					      :key="item.sstId"
					      :label="item.info"
					      :value="item.sstId"
					      :disabled="item.disabled">
					    </el-option>
					  </el-select>
				  </template>
			</el-table-column>
		</el-table>
	</div>
</template>

<script>
  export default {
    data() {
            return {
                tableData: [
					
    			],
				taskId:'',
				taskList:[
					
				],
            }
        },
        methods: {
			formatter(row, column) {
			    return row.name;
			},
			filterTag(value, row) {
			    return row.screenshot.submitted === value;
			},
			// 根据班长id获取所有截图任务，进行选择查看
			async getTasks(){
				let token =  {mntName:window.sessionStorage.getItem('token')}
				let {data: res} = await this.$http.post('/task/tasks',token)
				this.taskList = res
			},
			
            // findAll: function () {
            //     this.$http.get('http://localhost:8080/#/index').then(res=>{
            //         this.tableData = res.data;
            //     })
            // }
        },
        created() {
            this.getTasks()
        },
		watch:{
			//查找班上学生们提交的截图，taskId遍历，意味着要重新查找
			taskId: async function(){
				let {data:res} = await this.$http.get('/student/findAll',{
					params:{taskId:this.taskId}
				})
				this.tableData = res
				// console.log(this.tableData)
			}
		}
    }
</script>

<style scoped="scoped">
  
</style>
