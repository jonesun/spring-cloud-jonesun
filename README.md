![](https://img.shields.io/badge/spring--cloud--jonesun-v1.0.0-blue)
[![](https://img.shields.io/github/stars/hxrui/spring-cloud-jonesun.svg?style=social&label=Stars)](https://github.com/jonesun/spring-cloud-jonesun/stargazers)
![](https://img.shields.io/badge/SpringBoot-2.4.4-brightgreen.svg)
![](https://img.shields.io/badge/SpringCloud-2020-green.svg)
![](https://img.shields.io/badge/SpringCloudAlibaba-2020-green.svg)


需先启动Nacos

```shell
startup.cmd -m standalone
```

http://127.0.0.1:8848/nacos/

启动sentinel

```shell
java -Dserver.port=8105 -Dcsp.sentinel.dashboard.server=localhost:8105 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.1.jar

```

启动redis

# jonesun-admin 监控

端口：8101

# jonesun-gateway 网关

端口：8102

# jonesun-user-server 实际服务提供者

端口：8103

# jonesun-user-api 对外服务

端口：8104

# jonesun-demo 测试样例

```shell
npm i -g cnpm --registry=https://registry.npm.taobao.org

npm i -g vue-cli

vue -V

vue init webpack vuedemo

npm run dev

npm install axios -S

npm install --save iview
```

# jonesun-oauth2-auth 认证服务

端口 8106

使用keytool生成RSA证书jwt.jks，复制到resource目录下，使用如下命令即可

```shell
keytool -genkey -alias jwt -keyalg RSA -keystore jwt.jks
```
密码 123456

[参考自spring-cloud-gateway-oauth2](https://github.com/it-wwh/spring-cloud-gateway-oauth2.git)

## 方式一：用户名密码登录获取token

```shell
POST http://localhost:8102/oauth/token
Content-Type: application/x-www-form-urlencoded

grant_type=password&client_id=client-app&client_secret=123456&username=admin&password=123456
```


## 方式二: 使用授码模式登录时，先访问地址获取授权码

浏览器打开: http://localhost:8102/oauth/authorize?response_type=code&client_id=client-app-2&redirect_uri=https://jonesun.github.io

输入用户名密码(admin 123456)得到授权码code

发送请求
```shell
POST http://localhost:8102/oauth/token
Content-Type: application/x-www-form-urlencoded

grant_type=authorization_code&client_id=client-app-2&client_secret=123456&code={code}&redirect_uri=https://jonesun.github.io
```

## 拿到token后请求api

```shell
GET http://localhost:8102/jonesun-user-api/api/currentUser
Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIiwiam9uZXN1bi11c2VyLWFwaSJdLCJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJpZCI6MSwiZXhwIjoxNjE4MjA5OTE2LCJhdXRob3JpdGllcyI6WyJBRE1JTiJdLCJqdGkiOiJkMTg0NTFiNS0yOTNkLTRlNDQtOTU3Ni0wMzc4NWZkZmUxMjMiLCJjbGllbnRfaWQiOiJjbGllbnQtYXBwIn0.LJRgcbRxEVJAGXdWX33kBIvptOZ0GqZoUwOTbB9XoeHBL5c2fzaFuhaH-0HLoQ9tfzGumLOlpigD1DhiQEy0MPQbULG14IdN5m8YyyxsZcNxaNFoX-L-j4NIcuq1kskwrfUNhHLJSbsoJPfFL9LaROmjd-8Qa2Z87tCc3J7stwg642lSVqOj1yvUBMkx_sXAX-0uExWhlZf7Kjd1zFj3dp9cVAg2gpXAWTDGgrzxmZ_WJc_qXtKRqHnlvu_jZDn1CJvGBiFfs6mH7jeCxRjq5JocjMBKcH7zLrxbprNNE7E8eurRVHXAyoAdFu1brnkIjPGTHc7G9wMweAvbf8KndQ
```

## token 过期后刷新

```shell
POST http://localhost:8102/oauth/token
Content-Type: application/x-www-form-urlencoded

grant_type=refresh_token&client_id=client-app&client_secret=123456&refresh_token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjU1ZDIxMTU0LWJjNjMtNDgyYy1iOTY1LTZhNzA1MjU4NDQxZCIsImlkIjoxLCJleHAiOjE2MTgzMDMxNTIsImF1dGhvcml0aWVzIjpbIkFETUlOIl0sImp0aSI6IjAyNGI5N2Y4LTMwNzYtNDFkMy1iN2UyLTM1YTI1NWRkZGMxMCIsImNsaWVudF9pZCI6ImNsaWVudC1hcHAifQ.GUa--pBNN3JREEWzT4Qfq6HihKNU-rpJ_mZcejEIBqOmAvdW18sWwL5SubqlnF7-glDqq_FS1en7qFYIQ1knD17xHc9xVLzMqivODDxC35DPpHiBd8slt2kHGUfpRB7ITb3YGBomrpmRGvbm0hTYWg39EbPX9aWAM_xqOfjGxSydRBoZyztVESe7CkME-HiE2H0k-cUN7VbDhDzbn2sLxLnj8lYorsBILtEs8_oeTsThydeT4UYWI0zSafP82mFGmRDZqF7Qa5zDXWucvJDfqZEMN_P_EJjMkzl6D3i0bTqjcQy3QRe2GtDaG43bHOLrwIa1qgvSH-Sed6A-QEQm9g
```

# jonesun-demo

## fore-demo 

纯js版web登录demo

## java-app

java版登录demo

## vuedemo

简单vue登录demo