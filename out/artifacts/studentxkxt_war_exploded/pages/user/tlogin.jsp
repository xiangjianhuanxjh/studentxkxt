<%--
  Created by IntelliJ IDEA.
  User: 19033
  Date: 2023/4/18
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>教师选课系统登录页面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" >
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-1.7.2.js"></script>
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
                    <h1>教师选课系统</h1>
                    <a href="${pageContext.request.contextPath}/pages/user/slogin.jsp">学生入口</a>
                    <a href="${pageContext.request.contextPath}/pages/user/mlogin.jsp">后台管理</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        <!-- 提示信息-->
                        ${requestScope.msg==null?"请输入教师工号和密码！":requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="${pageContext.request.contextPath}/TeacherLoginServlet" method="post">
                        <!-- 优化处理 隐藏-->
                        <input type="hidden" name="action" value="login">
                        <label>工号：</label>
                        <input class="itxt" type="text" placeholder="请输入工号" autocomplete="off" tabindex="1" name="gh"
                               value="${requestScope.gh}"/>
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
