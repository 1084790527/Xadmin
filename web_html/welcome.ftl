<#assign path = request.contextPath/>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>商户管理平台</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${path}/assets/css/font.css">
        <link rel="stylesheet" href="${path}/assets/css/xadmin.css">
        <script src="${path}/assets/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${path}/assets/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <blockquote class="layui-elem-quote">欢迎管理员：
                                <span class="x-red">${Session['LOGIN_INFO'].nickname}</span>！当前时间:${(currentTime)!''}
                            </blockquote>
                        </div>
                    </div>
                </div>
                <#--<div class="layui-col-md12">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">数据统计</div>-->
                        <#--<div class="layui-card-body ">-->
                            <#--<ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">-->
                                <#--<li class="layui-col-md2 layui-col-xs6">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>文章数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>66</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                                <#--<li class="layui-col-md2 layui-col-xs6">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>会员数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>12</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                                <#--<li class="layui-col-md2 layui-col-xs6">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>回复数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>99</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                                <#--<li class="layui-col-md2 layui-col-xs6">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>商品数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>67</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                                <#--<li class="layui-col-md2 layui-col-xs6">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>文章数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>67</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                                <#--<li class="layui-col-md2 layui-col-xs6 ">-->
                                    <#--<a href="javascript:;" class="x-admin-backlog-body">-->
                                        <#--<h3>文章数</h3>-->
                                        <#--<p>-->
                                            <#--<cite>6766</cite></p>-->
                                    <#--</a>-->
                                <#--</li>-->
                            <#--</ul>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="layui-col-sm6 layui-col-md3">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">下载-->
                            <#--<span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>-->
                        <#--<div class="layui-card-body  ">-->
                            <#--<p class="layuiadmin-big-font">33,555</p>-->
                            <#--<p>新下载-->
                                <#--<span class="layuiadmin-span-color">10%-->
                                    <#--<i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>-->
                            <#--</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="layui-col-sm6 layui-col-md3">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">下载-->
                            <#--<span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>-->
                        <#--<div class="layui-card-body ">-->
                            <#--<p class="layuiadmin-big-font">33,555</p>-->
                            <#--<p>新下载-->
                                <#--<span class="layuiadmin-span-color">10%-->
                                    <#--<i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>-->
                            <#--</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="layui-col-sm6 layui-col-md3">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">下载-->
                            <#--<span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>-->
                        <#--<div class="layui-card-body ">-->
                            <#--<p class="layuiadmin-big-font">33,555</p>-->
                            <#--<p>新下载-->
                                <#--<span class="layuiadmin-span-color">10%-->
                                    <#--<i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>-->
                            <#--</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="layui-col-sm6 layui-col-md3">-->
                    <#--<div class="layui-card">-->
                        <#--<div class="layui-card-header">下载-->
                            <#--<span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>-->
                        <#--<div class="layui-card-body ">-->
                            <#--<p class="layuiadmin-big-font">33,555</p>-->
                            <#--<p>新下载-->
                                <#--<span class="layuiadmin-span-color">10%-->
                                    <#--<i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>-->
                            <#--</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">系统信息</div>
                        <div class="layui-card-body ">
                            <table class="layui-table">
                                <tbody>
                                    <tr>
                                        <th>平台版本</th>
                                        <td>${system.version}</td>
                                    </tr>
                                    <tr>
                                        <th>服务器地址</th>
                                        <td>${system.serverAddress}</td>
                                    </tr>
                                    <tr>
                                        <th>操作系统</th>
                                        <td>${system.operatingSystem}</td>
                                    </tr>
                                    <tr>
                                        <th>运行环境</th>
                                        <td>${system.environment}</td>
                                    </tr>
                                    <tr>
                                        <th>JAVA版本</th>
                                        <td>${system.javaVersion}</td>
                                    </tr>
                                    <tr>
                                        <th>TOMCAT版本</th>
                                        <td>${system.tomcatVersion}</td>
                                    </tr>
                                    <tr>
                                        <th>MYSQL版本</th>
                                        <td>${system.mysqlVersion}</td>
                                    </tr>
                                    <tr>
                                        <th>剩余空间</th>
                                        <td>${system.hardDisk}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">开发团队</div>
                        <div class="layui-card-body ">
                            <table class="layui-table">
                                <tbody>
                                    <tr>
                                        <th>版权所有</th>
                                        <td>*************
                                            <a target="_blank">访问官网</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>开发者</th>
                                        <td>***************</td></tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <style id="welcome_style"></style>
                <div class="layui-col-md12">
                    <blockquote class="layui-elem-quote layui-quote-nm">感谢layui,百度Echarts,jquery,本系统由x-admin提供技术支持。</blockquote></div>
            </div>
        </div>
        </div>
    </body>
</html>