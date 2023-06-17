package com.servlet.student;

import com.db.DataBase;
import com.model.CourseScheduleBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "SelectCourseServlet", value = "/SelectCourseServlet")
public class SelectCourseServlet extends HttpServlet {
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

        try{
            DataBase database = new DataBase();
            ArrayList<CourseScheduleBean> arrayList1 = database.getCourseSchedule(xq);
            ArrayList<CourseScheduleBean> arrayList2 = database.getStudentCourseSchedule(xh, xq);

            for (int i=0;i<arrayList1.size();i++) {
                for(CourseScheduleBean j : arrayList2){
                    if(arrayList1.get(i).getKh().equals(j.getKh()) || arrayList1.get(i).getSksj().equals(j.getSksj())){
                        arrayList1.remove(arrayList1.get(i));
                        i--;
                        break;
                    }
                }
            }
            session.setAttribute("courselist", arrayList1);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./pages/error.jsp");
            return;
        }
        response.sendRedirect("./pages/student/selectcourse.jsp");
    }
}
