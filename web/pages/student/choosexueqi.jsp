<%--
  Created by IntelliJ IDEA.
  User: 19033
  Date: 2023/4/19
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>
        学期选择
    </title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" >
</head>
<body>

    <div style="width: 100%; font-size: 2em; font-weight:bold; color: darkblue; text-align: center; margin-top: 50px; margin-bottom: 50px;" >
        本硕博一体化选课系统
    </div>

        <div style="width: 100%; font-size: 1.5em; text-align: center;">
            <div style="width: 100%; text-align: center; margin-top: 20px; margin-bottom: 20px;">
                点击选择选课学期
            </div>
            <table style="width:100%;">
                <tr style="cursor: pointer; padding: 50px; margin: 50px; height: 2em;" value="21003">
                    <td style="text-align:center; vertical-align: middle;">
                        <a href="${pageContext.request.contextPath}/ChoosexueqiServlet?xq=2012-2013 秋季"
                           class="btn btn-info btn-lg active btn-block" role="button">
                            2012-2013 秋季

                        </a>
                    </td>
                </tr>
                <tr style="cursor: pointer; padding: 50px; margin: 50px; height: 2em;" value="21003">
                    <td style="text-align:center; vertical-align: middle;">
                        <a href="${pageContext.request.contextPath}/ChoosexueqiServlet?xq=2012-2013 冬季"
                           class="btn btn-info btn-lg active btn-block" role="button">
                            2012-2013 冬季
                        </a>
                    </td>
                </tr>
            </table>
        </div>
</body>
</html>
