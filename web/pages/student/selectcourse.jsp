<%@ page import="com.model.CourseScheduleBean" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: 19033
  Date: 2023/4/19
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生选课界面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" >
</head>
<body>
    <div id="divstuinfo"  style="padding: 1px 0px 0px 2px; text-align: center;">
        <span style="font-weight: bold;">   学生信息</span>
        <div style="line-height: 23px;">
            学号：<%=session.getAttribute("xh")%>
        </div>
        <div style="line-height: 23px;">
            姓名：<%=session.getAttribute("xm")%>
        </div>
        <div style="color:Red; font-weight:bold; line-height:23px;">
            <a href="${pageContext.request.contextPath}/GetStudentCourseScheduleServlet"
               style="color:Red;">[查看课表]</a>&nbsp;||&nbsp;

            <a href="${pageContext.request.contextPath}/GetGradeServlet" style="color:Red;">[查询成绩]</a>&nbsp;||&nbsp;
            <a href="${pageContext.request.contextPath}/StudentLogoutServlet" style="color:Red;">[安全退出]</a>
        </div>
    </div>

    <div id="main">
        <table>
            <caption style="font-weight: bold;">课程列表</caption>
            <tr>
                <td>课程号</td>
                <td>课程名称</td>
                <td>学分</td>
                <td>教师工号</td>
                <td>教师姓名</td>
                <td>上课时间</td>
            </tr>
            <%
                ArrayList<CourseScheduleBean> arrayList = (ArrayList<CourseScheduleBean>) session.getAttribute("courselist");
                for(CourseScheduleBean courseScheduleBean:arrayList){
            %>
            <tr>
                <td><%=courseScheduleBean.getKh()%></td>
                <td><%=courseScheduleBean.getKm()%></td>
                <td><%=courseScheduleBean.getXf()%></td>
                <td><%=courseScheduleBean.getGh()%></td>
                <td><%=courseScheduleBean.getXm()%></td>
                <td><%=courseScheduleBean.getSksj()%></td>
                <td><a href="${pageContext.request.contextPath}/AddCourseServlet?Kh=<%=courseScheduleBean.getKh()%>&Gh=<%=courseScheduleBean.getGh()%>">添加课程</a></td>
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
