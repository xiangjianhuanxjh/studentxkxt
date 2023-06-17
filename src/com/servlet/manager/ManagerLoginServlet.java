package com.servlet.manager;

import com.db.DataBase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ManagerLoginServlet", value = "/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String uid = null;
        String xq = null;
        DataBase database = null;

        try{
            database = new DataBase();
            xq = database.getXQ();
            uid = database.managerverify(username, password);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./pages/error.jsp");
            return;
        }

        if(uid != null && Integer.parseInt(uid) > 0){
            session.setAttribute("username", username);
            session.setAttribute("userid", uid);
            session.setAttribute("xq", xq);
            response.sendRedirect("./pages/manager/edit.jsp");
        } else {
            //回传信息
            request.setAttribute("msg","用户名或者密码错误！");
            request.setAttribute("username",username);

            //跳转到登录页面
            request.getRequestDispatcher("./pages/user/mlogin.jsp").forward(request,response);
        }
    }

}
