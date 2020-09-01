<template>
	<div>
		<el-page-header @back="goBack">
		</el-page-header><br />
		<el-table
			size="small"
		    :data="tableData"
		    border
		    style="width: 100%">
		   
		    <el-table-column
			  fixed
		      prop="info"
		      label="标题"
		      width="150">
		    </el-table-column>
			<el-table-column
			  
			  prop="deadline"
			  label="截止日期"
			  width="150">
			</el-table-column>
		    <el-table-column
		      prop="precautions"
		      label="注意事项"
		      width="300">
		    </el-table-column>
		    <el-table-column
			  prop="sstId"
		      fixed="right"
		      label="操作"
		      width="90">
		      <template slot-scope="scope">
				<i>
					<!-- <template>
					<el-popconfirm
					  title="这是一段内容确定删除吗？"> -->
					  <el-button v-on:click="edit(scope.row.sstId)" slot="reference" type="text" size="small">编辑</el-button>
					<!-- </el-popconfirm>
					</template> -->
				</i>
				<i style="float: right;">
					<template>
					<el-popconfirm
					  @onConfirm="deleteHandle(scope.row.sstId)"
					  title="这将导致本期已提交的同学的截图全部删除,确定删除吗？">
					  <el-button slot="reference" type="text" size="small" style="color: #FF0000;">删除</el-button>
					</el-popconfirm>
					</template>
				</i>
				
		      </template>
		    </el-table-column>
		  </el-table>
		  
		  <!-- 修改的dialog -->
		  <el-dialog title="修改任务" :visible.sync="dialogFormVisible">
		    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
		      <el-form-item label="标题" prop="info">
		        <el-input v-model="ruleForm.info"></el-input>
		      </el-form-item>
		      <el-form-item label="截止时间" required>
		        <el-col :span="11">
		          <el-form-item prop="deadline">
		            <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.deadline" style="width: 100%;"></el-date-picker>
		          </el-form-item>
		        </el-col>
		        <el-col class="line" :span="2">-</el-col>
		        <el-col :span="11">
		          <el-form-item prop="date2">
		            <el-time-picker placeholder="选择时间" v-model="ruleForm.date2" style="width: 100%;"></el-time-picker>
		          </el-form-item>
		        </el-col>
		      </el-form-item>
		      </el-form-item>
		      <el-form-item label="注意事项" prop="precautions">
		        <el-input type="textarea" v-model="ruleForm.precautions"></el-input>
		      </el-form-item>
		    </el-form>
		    <div slot="footer" class="dialog-footer">
		      <el-button @click="dialogFormVisible = false">取 消</el-button>
		      <el-button type="primary" v-on:click="update('ruleForm')">确 定</el-button>
		    </div>
		  </el-dialog>
	</div>
</template>

<script>
  export default {
    data() {
            return {
                tableData: [
					
    			],
				dialogFormVisible:false,
				ruleForm: {
				  sstId:'',
				  info: '',
				  deadline: '',
				  date2: '',
				  
				  type: '',
				  precautions: ''
				},
				
				rules: {
				  info: [
				    { required: true, message: '请输入活动名称', trigger: 'blur' },
				    { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
				  ],
				  deadline: [
				    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
				  ],
				  date2: [
				    { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
				  ],
				  type: [
				    { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
				  ],
				  precautions: [
				    { required: true, message: '请填写活动形式', trigger: 'blur' }
				  ]
				}
            }
        },
        methods: {
			formatter(row, column) {
			    return row.name;
			},
			filterTag(value, row) {
			    return row.tag === value;
			},
			goBack() {
				console.log('go back');
		    },
            findAll: async function () {
                let {data:res} = await this.$http.get('/task/history')
			    this.tableData = res
				// console.log(res)
            },
			async deleteHandle(sstId){
				let {data:res} = await this.$http.get('/task/delOne',{
					params:{sstId:sstId}
				})
				// console.log(res)
				if(res.code === 0) {
					this.$message.success("删除成功")
					this.findAll()
				}
				else this.$message.error("删除失败")	
			},
			async edit(sstId){
				this.dialogFormVisible = true
				let {data:res} = await this.$http.get('/task/findOne',{
					params:{sstId:sstId}
				})
				// console.log(res)
				this.ruleForm = res
				
				let date = new Date(res.deadline)
				this.ruleForm.deadline = date
				this.ruleForm.date2 = date	
			},
			update(ruleForm){
				this.dialogFormVisible = false
				
				this.$refs[ruleForm].validate((valid) => {
				  if (valid) {
					let term = this.ruleForm.date2
					let time = this.ruleForm.deadline
					time.setHours(term.getHours())
					time.setMinutes(term.getMinutes())
					time.setSeconds(term.getSeconds())
					time.setMilliseconds(term.getMilliseconds())
					
					this.ruleForm.deadline = time.valueOf()
					// console.log(this.ruleForm)
					this.updateTask()
								
				  } else {
				    // console.log('error submit!!');
				    return false;
				  }
				});
			},
			async updateTask(){
				let {data:res} = await this.$http.post('/task/update',this.ruleForm)
				
				if(res.code === 0){
					this.findAll()
					this.$message.success(res.msg)
				} else
					this.$message.error(res.msg)
			}
        },
        created() {
            this.findAll();
        }
    }
</script>

<style scoped="scoped">
  
</style>

