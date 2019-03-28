# 分享一个入门级微服务项目：online-shop
SpringBoot框架使用了默认大于配置的理念，集成了快速开发的Spring多个插件，同时自动过滤掉了不需要配置的多余的插件。简化了项目的开发配置流程，一定程度上取消了xml配置，是一套快速配置开发的脚手架。还有SpringBoot的另外一个特点是其更专注于开发微服务后台接口，虽然前端视图也能开发，但那个有点不符合SpringBoot的初衷了，因此SpringBoot更适合于开发可以独立运行的单体微服务后台接口。
而这也是笔者为什么做这个项目的初衷之一。

**如果各位猿友觉得还不错的话，就点击一下右上角的star鼓励一下呗(#^.^#)**

**技术栈**

* 后端： SpringBoot2.x + Mybatis
* 前端： thymeleaf html/(Vue.JS2.x + ElementUI)
* 备注： 前端暂时不提供访问页面，后续会补

**测试环境**

* IDEA + SpringBoot + mysql + jdk8 + maven + Swagger2

**启动说明**

* 启动前，请配置好 [application.yml](https://github.com/uboy25/online-shop/blob/master/src/main/resources/application.yml) 中连接数据库的用户名和密码。

* 启动前，请创建数据库`eshop`，建表SQL语句放在：[/db/](https://github.com/uboy25/online-shop/tree/master/db)。具体的建表和建库语句请仔细看SQL文件。

* 配置完成后，运行位于 `src/main/java/com/qakmak/eshop/`下的AppRun.java中的main方法，访问 `http://localhost:8080/swagger-ui.html#/` 进行API测试。

**项目结构**
```
.
|—— s
|—— ss
```
