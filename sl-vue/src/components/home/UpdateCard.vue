<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span style="font-weight: bold;font-size: 20px">技术采用</span>
      <!--<el-button style="float: right; padding: 3px 0" type="text">修改</el-button>-->
    </div>
    <div class="block">
      <el-timeline>
          <el-card>
            <h4>后端：Spring Boot + Apache Shiro + Spring Data JPA，服务器采用的是Tomcat，数据库用的Mysql</h4>
            <h4>前端：Vue + Element + axios</h4>
            <p>使用RESTful API进行前后端接口连接</p>
          </el-card>
      </el-timeline>
    </div>
  </el-card>
</template>

<script>
export default {
  name: 'UpdateCard'
}
</script>

<style scoped>
  .box-card {
    margin-top: 5px;
    width: 988px;
    height: 225px;
    text-align: left;
  }
</style>
