package com.servlet.teacher;

import com.db.DataBase;
import com.model.CourseScheduleBean;
import com.model.GradeScheduleBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EnterGradeServlet", value = "/EnterGradeServlet")
public class EnterGradeServlet extends HttpServlet {
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
            ArrayList<GradeScheduleBean> arrayList = database.getGradeSchedule(gh, xq);

            session.setAttribute("gradeschedulelist", arrayList);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./pages/error.jsp");
            return;
        }
        response.sendRedirect("./pages/teacher/entergrade.jsp");
    }
}
