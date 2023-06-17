<%@ page import="com.model.CourseScheduleBean" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 19033
  Date: 2023/5/10
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩</title>
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
               style="color:Red;">[返回]</a>
        </div>
    </div>

    <div id="main">
        <table>
            <caption style="font-weight: bold;">成绩表</caption>
            <tr>
                <td>课程号</td>
                <td>课程名称</td>
                <td>学分</td>
                <td>授课教师</td>
                <td>绩点</td>
            </tr>
            <%
                ArrayList<CourseScheduleBean> arrayList = (ArrayList<CourseScheduleBean>) session.getAttribute("gradelist");
                for(CourseScheduleBean courseScheduleBean:arrayList){
            %>
            <tr>
                <td><%=courseScheduleBean.getKh()%></td>
                <td><%=courseScheduleBean.getKm()%></td>
                <td><%=courseScheduleBean.getXf()%></td>
                <td><%=courseScheduleBean.getXm()%></td>
                <td><%=courseScheduleBean.getJidian()==null?"" : courseScheduleBean.getJidian()%></td>
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
