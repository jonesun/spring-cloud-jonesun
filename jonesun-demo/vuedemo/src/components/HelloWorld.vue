<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Essential Links 123</h2>
    <button v-on:click="testHttp">testHttp</button>
    <ul>
      <li>
        <a
          href="https://vuejs.org"
          target="_blank"
        >
          Core Docs
        </a>
      </li>
      <li>
        <a
          href="https://forum.vuejs.org"
          target="_blank"
        >
          Forum
        </a>
      </li>
      <li>
        <a
          href="https://chat.vuejs.org"
          target="_blank"
        >
          Community Chat
        </a>
      </li>
      <li>
        <a
          href="https://twitter.com/vuejs"
          target="_blank"
        >
          Twitter
        </a>
      </li>
      <br>
      <li>
        <a
          href="http://vuejs-templates.github.io/webpack/"
          target="_blank"
        >
          Docs for This Template
        </a>
      </li>
    </ul>
    <h2>Ecosystem</h2>
    <ul>
      <li>
        <a
          href="http://router.vuejs.org/"
          target="_blank"
        >
          vue-router
        </a>
      </li>
      <li>
        <a
          href="http://vuex.vuejs.org/"
          target="_blank"
        >
          vuex
        </a>
      </li>
      <li>
        <a
          href="http://vue-loader.vuejs.org/"
          target="_blank"
        >
          vue-loader
        </a>
      </li>
      <li>
        <a
          href="https://github.com/vuejs/awesome-vue"
          target="_blank"
        >
          awesome-vue
        </a>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  created() {
    console.log('created Event  --> Goto init()')
    this.init()
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    init: function () {
      this.$api.api_all.get_current_user_api()
        .then((response)=>{
          console.log(response);
          var username = response.data.username;
          if(username == null) {
            this.$router.push("/login") // 跳转到首页
          } else {
            this.msg = username;
          }
        }).catch((error)=>{
          console.log(error);
          this.$Message.error("发生异常");
          this.$router.push("/login") // 跳转到首页
      })

    },
    testHttp: function (event) {
      this.$api.api_all.get_users_api()
        .then((response)=>{
          console.log(response);
        }).catch((error)=>{
          console.log(error);
          this.$Message.error(error);
          this.$router.push("/login") // 跳转到首页
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
