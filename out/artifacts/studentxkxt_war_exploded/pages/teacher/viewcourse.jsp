<%@ page import="com.model.CourseScheduleBean" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 19033
  Date: 2023/5/8
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师界面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" >
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" >
</head>
<body>
<div id="divstuinfo"  style="padding: 1px 0px 0px 2px; text-align: center;">
    <span style="font-weight: bold;">   当前用户：教师</span>
    <div style="line-height: 23px;">
        教师工号：<%=session.getAttribute("gh")%>
    </div>
    <div style="line-height: 23px;">
        姓名：<%=session.getAttribute("xm")%>
    </div>
    <div style="color:Red; font-weight:bold; line-height:23px;">
        <a href="${pageContext.request.contextPath}/EnterGradeServlet" style="color:Red;">[成绩录入]</a>&nbsp;||&nbsp;
        <a href="#" style="color:Red;">[设置作业]</a>&nbsp;||&nbsp;
        <a href="${pageContext.request.contextPath}/TeacherLogoutServlet" style="color:Red;">[安全退出]</a>
    </div>
</div>

<div id="main">
    <table>
        <caption style="font-weight: bold; text-align: center;">成绩录入</caption>
        <tr>
            <td>课程号</td>
            <td>课程名称</td>
            <td>学分</td>
            <td>上课时间</td>
        </tr>
        <%
            ArrayList<CourseScheduleBean> arrayList = (ArrayList<CourseScheduleBean>) session.getAttribute("teachercourselist");
            for(CourseScheduleBean courseScheduleBean:arrayList){
        %>
        <tr>
            <td><%=courseScheduleBean.getKh()%></td>
            <td><%=courseScheduleBean.getKm()%></td>
            <td><%=courseScheduleBean.getXf()%></td>
            <td><%=courseScheduleBean.getSksj()%></td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<div id="bottom">
		<span>
			选课.Copyright &copy;2023
		</span>
</div>

</body>
</html>
