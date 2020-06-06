<template>
    <el-menu
      default-active="1"
      style="width: 170px">
      <a href="#header-div">
        <el-menu-item index="1">
          <i class="el-icon-menu"></i>
          <span slot="title">欢迎使用</span>
        </el-menu-item>
      </a>
      <a href="#update-card">
        <el-menu-item index="2">
          <i class="el-icon-menu"></i>
          <span slot="title">技术采用</span>
        </el-menu-item>
      </a>
      <a href="#slogan">
        <el-menu-item index="3">
          <i class="el-icon-document"></i>
          <span slot="title">关于我们</span>
        </el-menu-item>
      </a>
    </el-menu>
</template>

<script>
export default {

}
</script>

<style>
  a {
    text-decoration: none;
    color: inherit;
  }
</style>
