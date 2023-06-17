<%@ page import="com.model.GradeScheduleBean" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 19033
  Date: 2023/5/6
  Time: 19:12
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
            <a href="${pageContext.request.contextPath}/GetTeacherCourseServlet" style="color:Red;">[查看课程]</a>&nbsp;||&nbsp;
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
                    <td>学生姓名</td>
                    <td>平时成绩</td>
                    <td>考试成绩</td>
                    <td>总评成绩</td>
                    <td>操作</td>
                </tr>
                <%
                    ArrayList<GradeScheduleBean> arrayList = (ArrayList<GradeScheduleBean>) session.getAttribute("gradeschedulelist");
                    for(GradeScheduleBean gradeScheduleBean:arrayList){
                %>
                <tr>
                    <form action="${pageContext.request.contextPath}/ChangeGradeServlet">
                        <td>
                            <%=gradeScheduleBean.getKh()%>
                            <input type="hidden" name="Kh" value=<%=gradeScheduleBean.getKh()%>>
                        </td>
                        <td>
                            <%=gradeScheduleBean.getKm()%>
                            <input type="hidden" name="Km" value=<%=gradeScheduleBean.getKm()%>>
                        </td>
                        <td>
                            <%=gradeScheduleBean.getXm()%>
                            <input type="hidden" name="Xm" value=<%=gradeScheduleBean.getXm()%>>
                        </td>
                        <td class="col-xs-2">
                            <label>
                                <input name="pscj" type="text" class="form-control"
                                       value=<%=
                                      gradeScheduleBean.getPscj()==null?"" : gradeScheduleBean.getPscj()
                                       %>>
                            </label>
                        </td>
                        <td class="col-xs-2">
                            <label>
                                <input name="kscj" type="text" class="form-control"
                                       value=<%=
                                      gradeScheduleBean.getKscj()==null?"" : gradeScheduleBean.getKscj()
                                       %>>
                            </label>
                        </td>
                        <td>
                            <%=gradeScheduleBean.getZpcj()==null?"" : gradeScheduleBean.getZpcj()%>
                        </td>
                        <td>
                            <input class="btn btn-info btn-xs active btn-block" type="submit" value="录入成绩">
                        </td>
                    </form>
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
