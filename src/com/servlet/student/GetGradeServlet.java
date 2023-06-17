package com.servlet.student;

import com.db.DataBase;
import com.model.CourseScheduleBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetGradeServlet", value = "/GetGradeServlet")
public class GetGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        String xh = (String) session.getAttribute("xh");
        String xq = (String) session.getAttribute("xq");

        try{
            DataBase database = new DataBase();
            ArrayList<CourseScheduleBean> arrayList = database.getGrade(xh, xq);
            session.setAttribute("gradelist", arrayList);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./pages/error.jsp");
            return;
        }
        response.sendRedirect("./pages/student/grade.jsp");
    }
}
