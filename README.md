# 项目简介：
1.本项目为SpringCloud Gateway的微服务框架，整合了SpringSecurity，微服务间使用Redis来获取登陆的用户信息。
2.由于Gateway采用的是纯Webflux方式，所以原有的Spring基于传统拦截器、过滤器的方式无法正常使用SpringSecurity。
3.因此，本项目根据WebFlux的方式，进行了整合，实现了登录和权限验证。
4.本项目采用前后端分离的方式，后端已经采用了跨域的设置。前端需在HBuilderX之类的容器中运行。
5.项目请用IDEA2018及以上的版本导入。

# 1.运行环境
1.请安装mysql8，字符集设置为utf8mb4。
2.请安装redis并运行。

# 2.项目配置
1.请在项目中全局搜索“修改此处”字样，找到需要修改的配置（配置数据库和redis）。
2.在拷贝出来的前端页面“login.html”中，搜索“修改此处”字样，修改所有请求的ip地址。

# 3.资源文件
1.数据库sql文件在gateway模块的src/main/resources/db_files/spring_gateway_security.sql，请放入mysql8中，字符集utf8mb4。
2.前端页面在src/main/resources/pages中，请将所有文件请拷贝到HBuilderX之类的前端服务运行！

# 4.运行说明 
1.启动eureka服务-开启服务注册中心
2.启动gateway服务网关（登录、权限验证和所有请求的统一入口）
3.启动base-core业务服务（内部有具体的业务方法）
4.在谷歌浏览器中打开页面login.html，登录后点击不同超链接，来观测不同角色的不同反应。登录账号、密码在数据库中查看。

# 5.关键代码位置
1.gateway：src/main/java/com/daybreak/xian/gateway/config_security_webflux/：
此包中的类为SpringBoot、SpringSecurity的配置，SpringSecurity的核心入口配置类为此包中的“SecurityWebFluxConfig”。
2.gateway：src/main/java/com/daybreak/xian/gateway/component_security_webflux/：
此包中的类为SpringSecurity的WebFlux形式配置时所需注入的各个具体处理类，比如登录验证、权限验证、登陆成功、权限验证失败等处理类。
3.gateway：src/main/java/com/daybreak/xian/gateway/controller/：
此包中的类“BusinessController”为业务接口，里面放置了一些测试业务响应的接口，请自行从页面调用。
4.base-core：src/main/java/com/daybreak/xian/basecore/controler/：
此包中的类“BusinessController”也是业务接口，里面放置了一些跟角色有关的，测试业务响应的接口，请自行从页面调用。
