<template>
	<div>
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
		 <!-- <el-form-item label="截图格式" prop="type">
		    <el-checkbox-group v-model="ruleForm.type">
		      <el-checkbox label="png" name="type"></el-checkbox>
		      <el-checkbox label="jpeg" name="type"></el-checkbox>
		    </el-checkbox-group> -->
		  </el-form-item>
		  <el-form-item label="注意事项" prop="precautions">
		    <el-input type="textarea" v-model="ruleForm.precautions"></el-input>
		  </el-form-item>
		  <el-form-item>
		    <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
		    <el-button ><router-link to="/history">历史记录</router-link></el-button>
		  </el-form-item>
		</el-form>
	</div>
</template>

<script>
export default {
  data() {
        return {
          ruleForm: {
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
        };
      },
      methods: {
        submitForm(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
				let term = this.ruleForm.date2
				let time = this.ruleForm.deadline
				time.setHours(term.getHours())
				time.setMinutes(term.getMinutes())
				time.setSeconds(term.getSeconds())
				time.setMilliseconds(term.getMilliseconds())
				
				this.ruleForm.deadline = time.valueOf()
				// console.log(this.ruleForm)
				this.creatTask()
				
            } else {
              // console.log('error submit!!');
              return false;
            }
          });
        },
		async creatTask(){
			let {data:res} = await this.$http.post('/task/create',this.ruleForm)
			
			if(res.code === 0)
			  this.$message.success(res.msg)
			else
			  this.$message.error(res.msg)
		}
      }
    }
</script>

<style>
</style>
