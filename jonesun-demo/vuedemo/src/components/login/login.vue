<style lang="less">
  @import './login.less';
</style>

<template>
  <div class="login">
    <div class="login-con">
      <Card icon="log-in" title="欢迎登录" :bordered="false">
        <div class="form-con">
          <login-form @on-success-valid="handleSubmit"></login-form>
          <p class="login-tip">输入任意用户名和密码即可</p>
        </div>
      </Card>
    </div>
  </div>
</template>

<script>
	import LoginForm from '@/components/login-form' // 驼峰命名法
	export default {
	    data(){
	      return{

	      }
	    },
		components: {
			LoginForm
	    },
		methods:{
            handleSubmit({username, password}){
                this.$api.api_all.post_user_login_api(
                    username,password
                ).then((response)=>{
                  console.log(response);
                    this.$Message.success(response.data.message);
                    localStorage.setItem('TOKEN', JSON.stringify(response.data.data.token)); // 设置TOKEN
                    this.$router.push("/") // 跳转到首页
                }).catch((error)=>{
                    console.log(error);
                    this.$Message.error("发生异常");
                })
            }
		}
	}
</script>

