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
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
    <span class="layui-breadcrumb">
        <a>首页</a>
        <a>平台管理</a>
        <a><cite>角色管理</cite></a>
    </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5" id="form_data">
                    <#if Session["sys:role:add"]?exists>
                        <a onclick="xadmin.open('${Session["sys:role:add_name"]}','${path}${Session["sys:role:add"]}',600,400)">
                            <i class="iconfont">&#xe6b9;</i>${Session["sys:merchant:add_name"]}
                        </a>
                    </#if>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="name" placeholder="角色名称" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <select name="state">
                                <option value="">全部</option>
                                <option value="1">启用</option>
                                <option value="0">停用</option>
                            </select>
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i>
                            </button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-body ">
                    <table id="role" class="layui-hide" lay-filter="test"></table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="barBtn">
    {{# if(d.state == '1'){ }}
    <#if Session["sys:role:disable"]?exists>
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="disable">停用</a>
    </#if>
    {{# } }}
    {{# if(d.state == '0'){ }}
    <#if Session["sys:role:enable"]?exists>
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="enable">启用</a>
    </#if>
    {{# } }}
    {{# if(d.state == '1'){ }}
    <#if Session["sys:role:modify"]?exists>
        <a class="layui-btn layui-btn-xs" lay-event="modify">修改</a>
    </#if>
    {{# } }}
    <#if Session["sys:role:delete"]?exists>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
    </#if>
</script>
<script type="text/html" id="toolbar">
</script>
<script type="text/javascript">
    layui.use(['table','form'],function () {
        var form = layui.form;
        var table = layui.table;
        // var form = layui.form;
        table.render({
            elem: '#role'
            ,url:'${path}${Session["sys:role"]}'
            ,id : 'roleId'
            ,method:'post'
            ,where:{}
            ,page : true
            ,toolbar : '#toolbar'
            ,cols: [[
                {field:'left', title: '操作',width:250,toolbar:'#barBtn'}
                ,{field:'id', title: 'ID', sort: true}
                ,{field:'name', title: '角色名称'}
                ,{field:'desc', title: '描述'}
                ,{field:'state', templet:function (d) {
                        if (d.state == '1'){
                            return "启用";
                        }else if(d.state == '0'){
                            return "停用";
                        }else {
                            return "状态错误";
                        }
                    } , title: '状态'}
                ,{field:'lastModOperName', title: '最后修改操作员'}
                ,{field:'lastModOperDate', title: '最后修改操作员时间'}
                ,{field:'creOperName', title: '创建人员'}
                ,{field:'creDate', title: '添加日期'}
            ]]
        });
        form.on('submit(sreach)',function (data) {
            table.reload('roleId',{
                    where:data.field
                }
            );
            return false;
        });
        table.on('tool(test)', function(obj) {
            var data = obj.data;
            console.log("tab 监听");
            switch (obj.event) {
                case 'disable':
                    //停用
                    // layer.alert(JSON.stringify(data));
                    $.ajax({
                        url : '${path}${Session["sys:role:disable"]}',
                        type : 'POST',
                        dataType : 'json',
                        data : data,
                        async : false,
                        success : function (data) {
                            if (data.state){
                                table.reload('roleId',{});
                            }else {
                                layer.alert(data.message);
                            }
                        },error : function (e) {
                            layer.alert(JSON.stringify(e));
                        }
                    });
                    break;
                case 'enable':
                    //启用
                    $.ajax({
                        url : '${path}${Session["sys:role:enable"]}',
                        type : 'POST',
                        dataType : 'json',
                        data : data,
                        async : false,
                        success : function (data) {
                            if (data.state){
                                table.reload('roleId',{});
                            }else {
                                layer.alert(data.message);
                            }
                        },error : function (e) {
                            layer.alert(JSON.stringify(e));
                        }
                    });
                    break;
                case 'modify':
                    //修改
                    // layer.msg(JSON.stringify(data));
                    xadmin.open('${Session["sys:role:modify_name"]}','${path}${Session["sys:role:modify"]}?id='+data.id,600,400);
                    break;
                case 'delete':
                    //删除
                    $.ajax({
                        url : '${path}${Session["sys:role:delete"]}',
                        type : 'POST',
                        dataType : 'json',
                        data : data,
                        async : false,
                        success : function (data) {
                            if (data.state){
                                table.reload('roleId',{});
                            }else {
                                layer.alert(data.message);
                            }
                        },error : function (e) {
                            layer.alert(JSON.stringify(e));
                        }
                    });
                    break;
            }
        });
    });
</script>
</html>