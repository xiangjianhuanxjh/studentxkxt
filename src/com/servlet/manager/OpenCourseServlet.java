package com.servlet.manager;

import com.db.DataBase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OpenCourseServlet", value = "/OpenCourseServlet")
public class OpenCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        String kh = request.getParameter("kh");
        String gh = request.getParameter("gh");
        String sksj = request.getParameter("sksj");
        if(kh!=""&&gh!=""&&sksj!=""){
            try{
                DataBase database = new DataBase();
                String xq = database.getXQ();
                database.managerOpenCourse(xq,kh,gh,sksj);
                database.close();
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("./pages/manager/edit.jsp?message=0");
                return;
            }
            response.sendRedirect("./pages/manager/edit.jsp?message=1");
        }
        else response.sendRedirect("./pages/manager/edit.jsp?msg=0");

    }
}
