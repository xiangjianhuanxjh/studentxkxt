<%--
  Created by IntelliJ IDEA.
  User: 19033
  Date: 2023/4/18
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生选课系统登录页面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" >

</head>

<body>
<div id="login_header">

</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>学生选课系统</h1>
                    <a href="${pageContext.request.contextPath}/pages/user/tlogin.jsp">教师入口</a>
                    <a href="${pageContext.request.contextPath}/pages/user/mlogin.jsp">后台管理</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        <!-- 提示信息-->
                        ${requestScope.msg==null?"请输入学号和密码！":requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="${pageContext.request.contextPath}/StudentLoginServlet" method="post">
                        <!-- 优化处理 隐藏-->
                        <input type="hidden" name="action" value="login">
                        <label>学号：</label>
                        <input class="itxt" type="text" placeholder="请输入学号" autocomplete="off" tabindex="1" name="xh"
                               value="${requestScope.xh}"/>
                        <br />
                        <br />
                        <label>密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
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

