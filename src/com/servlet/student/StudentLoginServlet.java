package com.servlet.student;

import com.db.DataBase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentLoginServlet", value = "/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        String xm = null;
        String xh = request.getParameter("xh");
        String password = request.getParameter("password");
        DataBase database = null;

        try{
            database = new DataBase();
            xm = database.studentverify(xh, password);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./pages/error.jsp");
            return;
        }
        if(xm != null ){
            session.setAttribute("xh", xh);
            session.setAttribute("xm", xm);
            response.sendRedirect("./pages/student/choosexueqi.jsp");
        } else {
            //回传信息
            request.setAttribute("msg","用户名或者密码错误！");
            request.setAttribute("xh",xh);

            //跳转到登录页面
            request.getRequestDispatcher("./pages/user/slogin.jsp").forward(request,response);
        }
    }
}
