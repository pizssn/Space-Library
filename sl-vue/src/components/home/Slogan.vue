<template>
  <div>
    <el-card class="box-card">
      <div style="font-size: 30px;color: azure;white-space: nowrap">我的联系方式</div>
      <a href="https://github.com/pizssn" target="_blank">
        <img src="../../assets/img/icon/icon6.png" alt="" class="git-link">
      </a>
      <a href="https://blog.csdn.net/pizssn" target="_blank">
        <img src="../../assets/img/icon/csdn.png" alt="" class="csdn-link">
      </a>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'Slogan'
}
</script>

<style scoped>
  .box-card {
    width: 100%;
    height: 120px;
    background-color: #222;
    text-align: center;
    margin-top: 5px;
  }

  .slogan {
    width: 100%;
  }

  .git-link {
    width: 40px;
    /*position: absolute;*/
  }

  .csdn-link {
    width: 34px;
    /*position: absolute;*/

    margin-left: 10px;
  }
</style>
