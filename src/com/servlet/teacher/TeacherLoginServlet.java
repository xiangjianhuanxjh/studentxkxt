package com.servlet.teacher;

import com.db.DataBase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TeacherLoginServlet", value = "/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        String xm = null;
        String gh = request.getParameter("gh");
        String password = request.getParameter("password");
        DataBase database = null;

        try{
            database = new DataBase();
            xm = database.teacherverify(gh, password);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./pages/error.jsp");
            return;
        }
        if(xm != null ){
            session.setAttribute("gh", gh);
            session.setAttribute("xm", xm);
            response.sendRedirect("EnterGradeServlet");
        } else {
            //回传信息
            request.setAttribute("msg","用户名或者密码错误！");
            request.setAttribute("gh",gh);
            //跳转到登录页面
            request.getRequestDispatcher("./pages/user/tlogin.jsp").forward(request,response);
        }
    }
}
