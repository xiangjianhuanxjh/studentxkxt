package com.servlet.student;

import com.db.DataBase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelCourseServlet", value = "/DelCourseServlet")
public class DelCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        String xq = (String) session.getAttribute("xq");
        String xh = (String) session.getAttribute("xh");
        String kh = request.getParameter("Kh");
        String gh = request.getParameter("Gh");
        try{
            DataBase database = new DataBase();
            database.delCourse(xh,xq,kh,gh);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./pages/error.jsp");
            return;
        }
        response.sendRedirect("GetStudentCourseScheduleServlet?");

    }
}
