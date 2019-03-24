<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath %>">
    <meta charset="UTF-8">
    <link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //每次页面加载完成，判断login.jsp是不是顶层窗口
            if (window.top != window) {
                window.top.location = window.location;
            }

            //当页面加载完成之后，使用户名输入框获取焦点
            $("#loginAct").focus();

            //当页面加载完成之后，给整个页面添加键盘按下事件
            $(window).keydown(function (e) {
                if (e.keyCode == 13) {
                    $("#loginBtn").click();
                }
            });

            //给"登录"按钮添加单击事件
            $("#loginBtn").click(function () {
                //收集参数
                var loginAct = $.trim($("#loginAct").val());
                var loginPwd = $.trim($("#loginPwd").val());
                var isRemPwd = $("#isRemPwd").prop("checked");
                //表单验证
                if (loginAct == null || loginAct.length == 0) {
                    alert("账号不能为空！");
                    return;
                }
                if (loginPwd == null || loginPwd.length == 0) {
                    alert("密码不能为空！");
                    return;
                }
                //发送请求
                $.ajax({
                    url: 'login.do',
                    data: {
                        'loginAct': loginAct,
                        'loginPwd': loginPwd,
                        'isRemPwd': isRemPwd
                    },
                    type: 'post',
                    dataType: 'json',
                    beforeSend: function () {//当ajax发送请求之前，执行本函数.如果本函数返回true,则ajax继续发送请求；如果本函数返回false，则ajax停止发送请求。
                        $("#msgTip").html("正在验证请求稍后...");
                        return true;
                    },
                    success: function (data) {
                        if ("SUCCESS" == data.ret) {
                            //跳转到业务主页面
                            window.location.href = "workbench/index.jsp";
                        } else {
                            //显示提示信息
                            $("#msgTip").html(data.msg);
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<div style="position: absolute; top: 0px; left: 0px; widows: 100%; height: 100%; width: 100%">
    <img src="image/IMG_7114.JPG" style="width: 100%; height: 90%; position: relative; top: 50px;">
</div>
<div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
    <div style="position: absolute; top: 5px; left: 0px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">
        CRM &nbsp;<span style="font-size: 12px;">&copy;2017&nbsp;动力节点</span></div>
</div>

<div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
    <div style="position: absolute; top: 0px; right: 60px;">
        <div class="page-header">
            <h1>登录</h1>
        </div>
        <div class="form-group form-group-lg">
            <div style="width: 350px;">
                <input id="loginAct" value="${cookie.loginAct.value }" class="form-control" type="text"
                       placeholder="用户名">
            </div>
            <div style="width: 350px; position: relative;top: 20px;">
                <input id="loginPwd" value="${cookie.loginPwd.value }" class="form-control" type="password"
                       placeholder="密码">
            </div>
            <div class="checkbox" style="position: relative;top: 30px; left: 10px;">
                <label>
                    <c:if test="${not empty cookie.loginAct and not empty cookie.loginPwd }">
                        <input id="isRemPwd" type="checkbox" value="1" checked="checked">
                    </c:if>
                    <c:if test="${empty cookie.loginAct or empty cookie.loginPwd }">
                        <input id="isRemPwd" type="checkbox" value="1">
                    </c:if>
                    十天内免登录<font color="red"><span id="msgTip"></span></font>
                </label>
            </div>
            <button id="loginBtn" type="button" class="btn btn-primary btn-lg btn-block"
                    style="width: 350px; position: relative;top: 45px;">登录
            </button>
        </div>
    </div>
</div>
</body>
</html>