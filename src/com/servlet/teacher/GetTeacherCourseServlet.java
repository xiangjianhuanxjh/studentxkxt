package com.servlet.teacher;

import com.db.DataBase;
import com.model.CourseScheduleBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetTeacherCourseServlet", value = "/GetTeacherCourseServlet")
public class GetTeacherCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        String gh = (String) session.getAttribute("gh");

        try{
            DataBase database = new DataBase();
            String xq = database.getXQ();
            ArrayList<CourseScheduleBean> arrayList = database.getTeacherCourseSchedule(gh, xq);
            session.setAttribute("teachercourselist", arrayList);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./pages/error.jsp");
            return;
        }
        response.sendRedirect("./pages/teacher/viewcourse.jsp");
    }
}
