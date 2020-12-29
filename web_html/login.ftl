<#assign path = request.contextPath/>
<!doctype html>
<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>商户管理平台</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="${path}/assets/css/font.css">
    <link rel="stylesheet" href="${path}/assets/css/login.css">
	  <link rel="stylesheet" href="${path}/assets/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${path}/assets/lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="${path}/assets/js/msg.js"></script>
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">商户管理平台</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form">
            <input name="mobileNo" id="mobileNo" placeholder="手机号" value="" type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" id="password" lay-verify="required" placeholder="密码" value=""  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-filter="login" lay-submit="" style="width:100%;" type="button">
            <hr class="hr20" >
        </form>
    </div>

    <script type="text/javascript">
        // console.log(document.getElementById('input_profile_user_password').value());
        $(function () {
            layui.use(['form'],function () {
                var form = layui.form;
                form.on('submit(login)',
                    function(data) {
                        layer.load(2);
                        // console.log(data.field);
                        $.ajax({
                            url : '${path}/login',
                            type : 'POST',
                            dataType : 'json',
                            data : data.field,
                            async : false,
                            success : function (data) {
                                // msg(JSON.stringify(data))
                                if (data.state){
                                    location.href='${path}/index'
                                }else {
                                    layer.alert(data.msg);
                                }
                            },
                            error : function (e) {
                                layer.closeAll('loading');
                                layer.alert(JSON.stringify(e));
                            }
                        });
                    });
            });
        });
    </script>
    <!-- 底部结束 -->
</body>
</html>