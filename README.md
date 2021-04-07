需先启动Nacos

```shell
startup.cmd -m standalone
```

http://127.0.0.1:8848/nacos/

启动sentinel

```shell
java -Dserver.port=8105 -Dcsp.sentinel.dashboard.server=localhost:8105 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.1.jar

```

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