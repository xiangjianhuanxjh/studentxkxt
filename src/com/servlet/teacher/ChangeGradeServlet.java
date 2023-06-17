package com.servlet.teacher;

import com.db.DataBase;
import com.model.GradeScheduleBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ChangeGradeServlet", value = "/ChangeGradeServlet")
public class ChangeGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        String gh = (String) session.getAttribute("gh");

        String pscj = request.getParameter("pscj");
        String kscj = request.getParameter("kscj");
        String kh = request.getParameter("Kh");
        String xm = request.getParameter("Xm");

        try{
            DataBase database = new DataBase();
            String xq = database.getXQ();
            database.ChangeGrade(pscj,kscj,kh,xq,gh,xm);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./pages/error.jsp");
            return;
        }
        response.sendRedirect("EnterGradeServlet");


    }
}
