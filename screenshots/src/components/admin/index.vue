<template>
<div>
	<el-container style="height: 520px; border: 1px solid #eee; width: 70%;" class="con">
	  <el-aside width="25%" style="background-color: rgb(238, 241, 246)">
	    <el-menu :default-openeds="['1']" router default-active="stuinfo">
	      <el-submenu index="1">
	        <template slot="title"><i class="el-icon-caret-bottom"></i>主页</template>
	        <el-menu-item-group>
	          <!-- <template slot="title">分组一</template> -->
	          <el-menu-item index="stuinfo" ><i class="el-icon-guide"></i>我的班级</el-menu-item>
	          <el-menu-item index="task" ><i class="el-icon-s-order"></i>发布任务</el-menu-item>
	          <el-menu-item index="detail" ><i class="el-icon-picture-outline"></i>查看详情</el-menu-item>
			  </el-menu-item-group>
	      </el-submenu>  
	    </el-menu>
	  </el-aside>
	  
	  <el-container>
	    <el-header style="text-align: right; font-size: 12px;">
			<span class="text">{{myClass.className}}</span>
	      <el-dropdown style="margin-right: 1%;" size="small">
	        <i class="el-icon-more"></i>
	        <el-dropdown-menu slot="dropdown">
	          <el-dropdown-item>管理班级</el-dropdown-item>
	         <!-- <el-dropdown-item>新增</el-dropdown-item>
	          <el-dropdown-item>删除</el-dropdown-item> -->
	        </el-dropdown-menu>
	      </el-dropdown>
	      <span >{{myClass.monitor.mntName}}</span>
	    </el-header>
	    
	    <el-main style="position: relative;">
	      <router-view></router-view>
	    </el-main>
	  </el-container>
	</el-container>
</div>	
</template>

<script>
  export default {
    data() {
            return {
                tableData: [
					
    			],
				myClass:{},
            }
        },
        methods: {
			async findMyClass(){
				let {data:res} = await this.$http.get('/banji/findMyClass')
				// console.log(res)
				if(res.code === 0){
					this.myClass = res.data
				}else{
					this.$message.error(res.msg)
				}
			}
        },
        mounted() {
            this.findMyClass()
        }
    }
</script>

<style scoped="scoped">
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
	position: relative;
  }
  
  .el-aside {
    color: #333;
  }
  .con {
      border: 1px solid #DCDFE6;
      /* width: 350px; */
      margin: 50px auto;
	  margin-bottom: 0;
      padding: 35px 35px 15px 35px;
      border-radius: 5px;
      -webkit-border-radius: 5px;
      -moz-border-radius: 5px;
      box-shadow: 0 0 25px #909399;
  }
  .text{
	  font-size: 14px; 
	  text-align: center; 
	  position: absolute;
	  display: block;
	  text-align: center;
	  line-height: 40px;
	  width: 50%;
	  height: 40px;
	  margin: 10px 20%;
	  /* background-color: red; */
  }

</style>
