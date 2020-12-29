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
        <a href="">首页</a>
        <a href="">平台管理</a>
        <a>
            <cite>商户管理</cite>
        </a>
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
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <#if Session["sys:merchant:add"]?exists>
                                <a onclick="xadmin.open('${Session["sys:manager:add_name"]}','${path}${Session["sys:manager:add"]}',800,600)">
                                    <i class="iconfont">&#xe6b9;</i>${Session["sys:manager:add_name"]}
                                </a>
                            </#if>
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" class="layui-input" name="regDate" autocomplete="off" id="regDate" placeholder="注册时间">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="nickname" placeholder="昵称" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="mobileNo" placeholder="手机号" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="realName" placeholder="真实姓名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <select name="sex">
                                <option value="">全部</option>
                                <option value="1">男</option>
                                <option value="2">女</option>
                                <option value="0">未知</option>
                            </select>
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <select name="state">
                                <option value="">全部</option>
                                <option value="1">启用</option>
                                <option value="0">停用</option>
                            </select>
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-body ">
                    <table id="merchant" class="layui-hide" lay-filter="test"></table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="barBtn">
    {{# if(d.state == '1'){ }}
    <#if Session["sys:manager:disable"]?exists>
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="disable">停用</a>
    </#if>
    {{# } }}
    {{# if(d.state == '0'){ }}
    <#if Session["sys:manager:enable"]?exists>
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="enable">启用</a>
    </#if>
    {{# } }}
    {{# if(d.state == '1'){ }}
    <#if Session["sys:manager:modify"]?exists>
        <a class="layui-btn layui-btn-xs" lay-event="modify">修改</a>
    </#if>
    {{# } }}
    <#if Session["sys:manager:delete"]?exists>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
    </#if>
    <#if Session["sys:manager:password"]?exists>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="password">修改密码</a>
    </#if>
</script>
<script type="text/javascript">
    layui.use(['table','form','laydate'],function () {
        var laydate = layui.laydate;
        var form = layui.form;
        var table = layui.table;
        laydate.render({
            elem: '#regDate'
            ,range: true
        });
        table.render({
            elem: '#merchant'
            ,url:'${path}${Session["sys:manager"]}'
            ,method:'post'
            ,where:{}
            ,page : true
            ,toolbar : '#toolbar'
            ,cols: [[
                {field:'left', title: '操作',toolbar:"#barBtn",width:300}
                ,{field:'id', title: 'id', sort: true}
                ,{field:'nickname', title: '昵称'}
                ,{field:'mobileNo', title: '手机号'}
                ,{field:'realName', title: '真实姓名'}
                ,{field:'sex',templet:function (d) {
                        if (d.sex == '1'){
                            return "男";
                        }else if(d.sex == '2'){
                            return "女";
                        }else {
                            return "未知";
                        }
                    }, title: '性别'}
                ,{field:'state',templet:function (d) {
                        if (d.state == '1'){
                            return "启用";
                        }else if(d.state == '0'){
                            return "停用";
                        }else {
                            return "状态错误";
                        }
                    }, title: '状态'}
                ,{field:'birthday', title: '出生日期'}
                ,{field:'regDate', title: '注册日期'}
                ,{field:'updateDate', title: '用户修改时间'}
                ,{field:'lastDate', title: '最后登入时间'}
                ,{field:'lastModOperName', title: '最后修改操作员'}
                ,{field:'lastModOperDate', title: '最后修改操作员时间'}
                ,{field:'lastLoginIp', title: '最后登入ip'}
            ]]
        });
        table.on('toolbar()', function (obj) {
            var config = obj.config;
            var btnElem = $(this);
            var tableId = config.id;
            var tableView = config.elem.next();
            switch (obj.event) {
                case 'LAYTABLE_COLS':
                    // 给筛选列添加全选还有反选的功能
                    var panelElem = btnElem.find('.layui-table-tool-panel');
                    var checkboxElem = panelElem.find('[lay-filter="LAY_TABLE_TOOL_COLS"]');
                    var checkboxCheckedElem = panelElem.find('[lay-filter="LAY_TABLE_TOOL_COLS"]:checked');
                    $('<li class="layui-form" lay-filter="LAY_TABLE_TOOL_COLS_FORM">' +
                            '<input type="checkbox" lay-skin="primary" lay-filter="LAY_TABLE_TOOL_COLS_ALL" '
                            + ((checkboxElem.length === checkboxCheckedElem.length) ? 'checked' : '') + ' title="全选">' +
                            '<span class="LAY_TABLE_TOOL_COLS_Invert_Selection">反选</span></li>')
                            .insertBefore(panelElem.find('li').first())
                            .on('click', '.LAY_TABLE_TOOL_COLS_Invert_Selection', function (event) {
                                layui.stope(event);
                                // 反选逻辑
                                panelElem.find('[lay-filter="LAY_TABLE_TOOL_COLS"]+').click();
                            });
                    form.render('checkbox', 'LAY_TABLE_TOOL_COLS_FORM');
                    break;
            }
        });

        // 监听筛选列panel中的全选
        form.on('checkbox(LAY_TABLE_TOOL_COLS_ALL)', function (obj) {
            $(obj.elem).closest('ul')
                    .find('[lay-filter="LAY_TABLE_TOOL_COLS"]' + (obj.elem.checked ? ':not(:checked)' : ':checked') + '+').click();
        });

        // 监听筛选列panel中的单个记录的change
        $(document).on('change', 'input[lay-filter="LAY_TABLE_TOOL_COLS"]', function (event) {
            var elemCurr = $(this);
            // 筛选列单个点击的时候同步全选的状态
            $('input[lay-filter="LAY_TABLE_TOOL_COLS_ALL"]')
                    .prop('checked',
                            elemCurr.prop('checked') ? (!$('input[lay-filter="LAY_TABLE_TOOL_COLS"]').not(':checked').length) : false);
            form.render('checkbox', 'LAY_TABLE_TOOL_COLS_FORM');
        });
        form.on('submit(sreach)',function (data) {
            table.reload('table',{
                        where:data.field
                    }
            );
            return false;
        });
        form.on('submit(sreach)',function (data) {
            table.reload('merchant',{
                        where:data.field
                    }
            );
            return false;
        });
        table.on('tool(test)', function(obj) {
            var data = obj.data;
            // console.log("tab 监听");
            switch (obj.event) {
                case 'disable':
                    //停用
                    // layer.alert(JSON.stringify(data));
                    <#if Session["sys:manager:disable"]?exists>
                    $.ajax({
                        url : '${path}${Session["sys:manager:disable"]}',
                        type : 'POST',
                        dataType : 'json',
                        data : data,
                        async : false,
                        success : function (data) {
                            if (data.state){
                                table.reload('merchant',{});
                            }else {
                                layer.alert(data.msg);
                            }
                        },error : function (e) {
                            layer.alert(JSON.stringify(e));
                        }
                    });
                    </#if>
                    break;
                case 'enable':
                    //启用
                    // layer.alert(JSON.stringify(data));
                    <#if Session["sys:manager:enable"]?exists>
                    $.ajax({
                        url : '${path}${Session["sys:manager:enable"]}',
                        type : 'POST',
                        dataType : 'json',
                        data : data,
                        async : false,
                        success : function (data) {
                            if (data.state){
                                table.reload('merchant',{});
                            }else {
                                layer.alert(data.msg);
                            }
                        },error : function (e) {
                            layer.alert(JSON.stringify(e));
                        }
                    });
                    </#if>
                    break;
                case 'modify':
                    //修改
                    // layer.msg(JSON.stringify(data));
                    <#if Session["sys:manager:modify"]?exists>
                    xadmin.open('${Session["sys:manager:modify_name"]}','${path}${Session["sys:manager:modify"]}?id='+data.id,800,600);
                    </#if>
                    break;
                case 'delete':
                    //删除
                    // layer.msg(JSON.stringify(data));
                    <#if Session["sys:manager:delete"]?exists>
                    $.ajax({
                        url : '${path}${Session["sys:manager:delete"]}',
                        type : 'POST',
                        dataType : 'json',
                        data : data,
                        async : false,
                        success : function (data) {
                            if (data.state){
                                table.reload('merchant',{});
                            }else {
                                layer.alert(data.msg);
                            }
                        },error : function (e) {
                            layer.alert(JSON.stringify(e));
                        }
                    });
                    </#if>
                    break;
                case 'password':
                    // layer.msg(JSON.stringify(data));
                    <#if Session["sys:manager:password"]?exists>
                    $.ajax({
                        url : '${path}${Session["sys:manager:password"]}',
                        type : 'POST',
                        dataType : 'json',
                        data : data,
                        async : false,
                        success : function (data) {
                            layer.alert(data.msg);
                        },error : function (e) {
                            layer.alert(JSON.stringify(e));
                        }
                    });
                    </#if>
                    break;
            }
        });
    });
</script>
</html>