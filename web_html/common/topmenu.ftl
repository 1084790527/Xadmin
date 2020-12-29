<div class="container">
    <div class="logo">
        <a href="${path}/index">商户管理平台</a>
    </div>
    <div class="left_open">
        <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
    </div>
    <#--<ul class="layui-nav left fast-add" lay-filter="">-->
        <#--<li class="layui-nav-item">-->
            <#--<a href="javascript:;">+新增</a>-->
            <#--<dl class="layui-nav-child">-->
                <#--<!-- 二级菜单 &ndash;&gt;-->
                <#--<dd>-->
                    <#--<a onclick="xadmin.open('最大化','http://www.baidu.com','','',true)">-->
                        <#--<i class="iconfont">&#xe6a2;</i>弹出最大化-->
                    <#--</a>-->
                <#--</dd>-->
                <#--<dd>-->
                    <#--<a onclick="xadmin.open('弹出自动宽高','http://www.baidu.com')">-->
                        <#--<i class="iconfont">&#xe6a8;</i>弹出自动宽高-->
                    <#--</a>-->
                <#--</dd>-->
                <#--<dd>-->
                    <#--<a onclick="xadmin.open('弹出指定宽高','http://www.baidu.com',500,300)">-->
                        <#--<i class="iconfont">&#xe6a8;</i>弹出指定宽高-->
                    <#--</a>-->
                <#--</dd>-->
                <#--<dd>-->
                    <#--<a onclick="xadmin.add_tab('在tab打开','${path}/demo/member-list')">-->
                        <#--<i class="iconfont">&#xe6b8;</i>在tab打开-->
                    <#--</a>-->
                <#--</dd>-->
                <#--<dd>-->
                    <#--<a onclick="xadmin.add_tab('在tab打开刷新','${path}/demo/member-del',true)">-->
                        <#--<i class="iconfont">&#xe6b8;</i>在tab打开刷新-->
                    <#--</a>-->
                <#--</dd>-->
            <#--</dl>-->
        <#--</li>-->
    <#--</ul>-->
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">${(LOGIN_INFO.nickname)!''}</a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <dd><a onclick="xadmin.open('个人信息','${path}/info/index',500,800)">个人信息</a></dd>
                <dd><a onclick="xadmin.open('修改密码','${path}/info/resetpwd',500,300)">修改密码</a></dd>
                <dd><a href="${path}/loginOut">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index">
            <a href="${path}">前台首页</a>
        </li>
    </ul>
</div>

