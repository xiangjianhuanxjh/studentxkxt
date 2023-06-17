<%--
  Created by IntelliJ IDEA.
  User: 19033
  Date: 2023/5/8
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理页面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" >
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-1.7.2.js"></script>
    <style>
        label{
            display: inline-block;
            text-align: left;
            width: 70px;
        }
    </style>
</head>
<body>
<div id="login_header">

</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">管理员登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>管理员系统</h1>
                    <a href="${pageContext.request.contextPath}/pages/user/tlogin.jsp">教师入口</a>
                    <a href="${pageContext.request.contextPath}/pages/user/slogin.jsp">学生入口</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        <!-- 提示信息-->
                        ${requestScope.msg==null?"请输入用户名和密码！":requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="${pageContext.request.contextPath}/ManagerLoginServlet" method="post">
                        <!-- 优化处理 隐藏-->
                        <input type="hidden" name="action" value="login">

                            <label >用户名：</label>
                            <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
                                   value="${requestScope.username}">
                        <br />
                        <br />
                            <label>密码：</label>
                            <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password">
                        <br />
                        <br />
                        <input type="submit" value="登录" id="sub_btn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="bottom">
		<span>
			选课.Copyright &copy;2023
		</span>
</div>
</body>
</html>
