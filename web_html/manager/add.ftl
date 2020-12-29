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
    <script type="text/javascript" src="${path}/assets/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path}/assets/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form" method="post" id="form_data">
            <div class="layui-form-item">
                <label for="L_nickname" class="layui-form-label">
                    <span class="x-red">*</span>昵称
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="L_nickname" name="nickname" required="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_mobileNo" class="layui-form-label">
                    <span class="x-red">*</span>手机号/登入账号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="L_mobileNo" name="mobileNo" required="" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>将会成为您唯一的登入账号
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_realName" class="layui-form-label">
                    <span class="x-red">*</span>真实姓名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="L_realName" name="realName" required="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_birthday" class="layui-form-label">
                    <span class="x-red">*</span>出生日期
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="L_birthday" name="birthday" required="" autocomplete="off" placeholder="yyyy-MM-dd" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>性别
                </label>
                <div class="layui-input-inline">
                    <input type="radio" name="sex" value="0" title="未知" checked="">
                    <input type="radio" name="sex" value="1" title="男">
                    <input type="radio" name="sex" value="2" title="女">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_password" class="layui-form-label">
                    <span class="x-red">*</span>密码
                </label>
                <div class="layui-input-inline">
                    <input type="password" id="L_password" name="password" required="" lay-verify="password" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                    <span class="x-red">*</span>确认密码
                </label>
                <div class="layui-input-inline">
                    <input type="password" id="L_repass" name="repass" required="" lay-verify="repass" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>角色
                </label>
                <div class="layui-input-block">
                    <#list roles as role>
                        <input type="checkbox" name="priIds" value="${role.id}" title="${role.name}">
                    </#list>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label"></label>
                <button class="layui-btn" lay-filter="add" lay-submit="">新增</button>
            </div>
        </form>
    </div>
</div>
<script>
    layui.use(['form', 'layer','jquery','laydate'],
            function() {
                var laydate = layui.laydate;
                laydate.render({
                    elem: '#L_birthday'
                });
                $ = layui.jquery;
                var form = layui.form,
                        layer = layui.layer;
                //自定义验证规则
                form.verify({
                    password: [/(.+){6,12}$/, '密码必须6到12位'],
                    repass: function(value) {
                        if ($('#L_password').val() != $('#L_repass').val()) {
                            return '两次密码不一致';
                        }
                    }
                });
                //监听提交
                form.on('submit(add)',
                        function(data) {
                            console.log(data);
                            //发异步，把数据提交给后台
                            $.ajax({
                                url : '${path}${Session["sys:manager:add"]}',
                                type : 'POST',
                                dataType : 'json',
                                data : $('#form_data').serialize(),
                                async : false,
                                success : function (data) {
                                    if (data.state){
                                        layer.alert("增加成功", {
                                                    icon: 6
                                                },
                                                function() {
                                                    //关闭当前frame
                                                    xadmin.close();
                                                    // 可以对父窗口进行刷新
                                                    xadmin.father_reload();
                                                });
                                    }else {
                                        layer.alert(data.msg);
                                    }
                                },error : function (e) {
                                    layer.alert(JSON.stringify(e));
                                }
                            });

                            return false;
                        });
            });
</script>
</body>

</html>