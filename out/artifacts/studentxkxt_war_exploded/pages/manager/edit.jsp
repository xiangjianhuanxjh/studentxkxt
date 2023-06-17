<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: 19033
  Date: 2023/5/8
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" >
</head>
<body>
    <div id="header">
        <span class="wel_word">后台管理系统</span>
        <div>
            <span>当前用户：<span class="um_span">${sessionScope.username}</span></span>
            <a href="#">查看各单位信息</a>
            <a href="${pageContext.request.contextPath}/ManagerLogoutServlet">退出</a>
        </div>

    </div>

    <div id="main">
        <div>
            <form action="${pageContext.request.contextPath}/OpenCourseServlet">
                <table>
                    <caption style="font-weight: bold; text-align: center;">系统设置</caption>
                    <tr>
                        <td>课号</td>
                        <td>教师号</td>
                        <td>上课时间</td>
                        <td>操作</td>
                    </tr>
                    <tr>
                        <td><input name="kh" type="text" class="form-control" placeholder="08305001"/></td>
                        <td><input name="gh" type="text" class="form-control" placeholder="0103"/></td>
                        <td><input name="sksj" type="text" class="form-control" placeholder="星期一 1-2"/></td>
                        <td><input class="btn btn-info btn-sm active btn-block" type="submit" value="开设课程"/></td>
                    </tr>
                </table>
            </form>

            <div style="text-align: center;">
                <form class="form-inline" action="${pageContext.request.contextPath}/ChangeXQServlet">
                    <div class="form-group">
                        <label for="xq" class=" control-label">请设置当前学期：</label>
                        <input name="xq" type="text" class="form-control" id="xq" placeholder="${sessionScope.xq}">
                        <button type="submit" class="btn btn-default">确认</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div id="bottom">
            <span>
                选课.Copyright &copy;2023
            </span>
    </div>

    <%
        if(Objects.equals(request.getParameter("msg"), "1")){
    %>
    <script type="text/javascript">
        alert("设置学期成功！");
    </script>
    <%
    } else if (Objects.equals(request.getParameter("msg"), "0")) {
    %>
    <script type="text/javascript">
        alert("输入为空！！！");
    </script>
    <%
        }
    %>

    <%
        if(Objects.equals(request.getParameter("message"), "0")){
    %>
    <script type="text/javascript">
        alert("开设课程失败！该课程与已有课程冲突");
    </script>
    <%
        } else if (Objects.equals(request.getParameter("message"), "1")) {
    %>
    <script type="text/javascript">
        alert("开设课程成功！");
    </script>
    <%
        }
    %>
</body>
</html>