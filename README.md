# Xadmin

该项目基于springboot + mybatis + freemarker 快速开发脚手架，包含商户管理，操作员管理角色权限管理

已亿业联盟后台管理为标准实现的开发脚手架

系统基于Spring Boot 2.3 技术 前端使用xadmin开源模板layui，数据库使用mysql

### 1 使用说明
1.1 安装说明
1.1.1 导入areadme/x_admin.sql

1.1.2 配置application-*.yml 数据库连接配置

spring.datasource.driver-class-name
spring.datasource.url
spring.datasource.username
spring.datasource.password

1.1.3 配置application-*.yml 页面分离路径

spring.freemarker.templateLoaderPath=运行环境下的静态页面路径

1.1.3 配置application-*.yml 静态文件路径

spring.resources.static-locations=运行环境下的静态文件路径

1.1.4 运行

server.servlet.port 改成80 或者配置nginx

SysApplication,main 运行项目 浏览器访问 http://localhost/sys/

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/raw/master/areadme/login.png "屏幕截图.png")

1.1.5 登录系统，用户名/密码（1111/123456）

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/raw/master/areadme/index.png "屏幕截图.png")

1.2 功能说明

1.2.1 角色管理 新增角色(权限精确到每个按钮)

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/blob/master/areadme/role.png "屏幕截图.png")

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/raw/master/areadme/addrole.png "屏幕截图.png")

1.2.2 管理员管理

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/blob/master/areadme/man.png "屏幕截图.png")

1.2.3 商户管理

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/blob/master/areadme/mer.png "屏幕截图.png")

