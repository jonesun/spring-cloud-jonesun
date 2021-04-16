import axios from '@/utils/axios'

const api_all = {
  // 获取所有博文列表
  post_user_login_api(username, password) {
    return axios({
      url: '/oauth/token',
      method: 'POST',
      data: {
        grant_type: 'password',
        client_id: 'client-app',
        client_secret: '123456',
        username: username,
        password: password,
      }
    })
  },
  get_current_user_api() {
    return axios({
      url: '/jonesun-user-api/api/currentUser',
      method: 'GET'
    })
  },
  get_users_api() {
    return axios({
      url: '/jonesun-user-api/api/users',
      method: 'GET'
    })
  },
};
export default api_all
