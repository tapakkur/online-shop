# 分享一个入门级微服务项目：online-shop
SpringBoot框架使用了默认大于配置的理念，集成了快速开发的Spring多个插件，同时自动过滤掉了不需要配置的多余的插件。简化了项目的开发配置流程，一定程度上取消了xml配置，是一套快速配置开发的脚手架。还有SpringBoot的另外一个特点是其更专注于开发微服务后台接口，虽然前端视图也能开发，但那个有点不符合SpringBoot的初衷了，因此SpringBoot更适合于开发可以独立运行的单体微服务后台接口。
而这也是笔者为什么做这个项目的初衷之一。

**如果各位猿友觉得还不错的话，就点击一下右上角的star鼓励一下呗(#^.^#)**

**技术栈**

* 后端： SpringBoot2.x + Mybatis + Swagger2
* 前端： thymeleaf html/(Vue.JS2.x + ElementUI)
* 备注： 前端暂时不提供访问页面，后续会补

**测试环境**

* IDEA + SpringBoot + mysql + jdk8 + maven

## 1.relations:
  the project contains three objects: user ,order and product which have the relationships following here between eachother:
  user&orders:
    one-to-many
  order&product:
    many-to-many
  
2.apis:
  PLease look forward to updating...

3.front-end apis link:
  the front-end web page will be coming as soon as posible...
  
4.more
  PLease look forward to updating...
