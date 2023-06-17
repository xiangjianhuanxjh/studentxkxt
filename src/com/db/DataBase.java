package com.db;

import com.model.CourseScheduleBean;
import com.model.GradeScheduleBean;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/school?" +
            "user=root&password=1472580369&useUnicode=true&characterEncoding=UTF8&useSSL=true";

    public DataBase() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url);
    }

    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public String studentverify(String xh, String password) throws Exception {
        boolean verified = false;
        String xm = null;
        String sql = "select * from s where xh=? and password=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, xh);
        stmt.setString(2, password);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            verified = true;
            xh = resultSet.getString("xh");
            xm = resultSet.getString("xm");
        }
        stmt.close();
        resultSet.close();
        if (verified) {
            return xm;
        } else {
            return null;
        }
    }

    public String teacherverify(String gh, String password) throws Exception {
        boolean verified = false;
        String xm = null;
        String sql = "select * from t where gh=? and password=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, gh);
        stmt.setString(2, password);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            verified = true;
            gh = resultSet.getString("gh");
            xm = resultSet.getString("xm");
        }
        stmt.close();
        resultSet.close();
        if (verified) {
            return xm;
        } else {
            return null;
        }
    }

    public String managerverify(String username, String password) throws Exception {
        boolean verified = false;
        String uid = null;
        String sql = "select * from manager where username=? and password=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            verified = true;
            uid = resultSet.getString("id");
        }
        stmt.close();
        resultSet.close();
        if (verified) {
            return uid;
        } else {
            return null;
        }
    }

    public ArrayList getCourseSchedule(String xq) throws Exception {
        ResultSet resultSet = null;
        String sql = "select o.kh,km,xf,o.gh,xm,sksj from o,c,t  where o.kh=c.kh and o.gh=t.gh and o.xq=? ORDER BY o.kh;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, xq);
        resultSet = stmt.executeQuery();
        ArrayList<CourseScheduleBean> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            String kh = resultSet.getString("kh");
            String km = resultSet.getString("km");
            String xf = resultSet.getString("xf");
            String gh = resultSet.getString("gh");
            String xm = resultSet.getString("xm");
            String sksj = resultSet.getString("sksj");
            arrayList.add(new CourseScheduleBean(kh, km, xf, gh, xm, sksj));
        }
        stmt.close();
        resultSet.close();
        return arrayList;
    }

    public ArrayList getStudentCourseSchedule(String xh, String xq) throws Exception {
        ResultSet resultSet = null;
        String sql = "select e.kh,km,xf,e.gh,xm,sksj from e inner join c on e.kh=c.kh\n" +
                "                                    inner join t on e.gh=t.gh\n" +
                "                                    inner join o on e.xq=o.xq and e.kh=o.kh and e.gh=o.gh\n" +
                "                               where e.xh=? and e.xq=? order by e.kh;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, xh);
        stmt.setString(2, xq);
        resultSet = stmt.executeQuery();
        ArrayList<CourseScheduleBean> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            String kh = resultSet.getString("kh");
            String km = resultSet.getString("km");
            String xf = resultSet.getString("xf");
            String gh = resultSet.getString("gh");
            String xm = resultSet.getString("xm");
            String sksj = resultSet.getString("sksj");
            arrayList.add(new CourseScheduleBean(kh, km, xf, gh, xm, sksj));
        }
        stmt.close();
        resultSet.close();
        return arrayList;
    }

    public boolean addCourse(String xh, String xq, String kh, String gh) throws Exception {
        boolean success = false;
        String sql = "insert into e(xh, xq, kh,gh) values(?, ?, ? , ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, xh);
        stmt.setString(2, xq);
        stmt.setString(3, kh);
        stmt.setString(4, gh);
        success = stmt.executeUpdate() != 0;
        stmt.close();
        return success;
    }

    public boolean delCourse(String xh, String xq, String kh, String gh) throws Exception {
        boolean success = false;
        String sql = "delete from e where xh=? and xq=? and kh=? and gh=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, xh);
        stmt.setString(2, xq);
        stmt.setString(3, kh);
        stmt.setString(4, gh);
        success = stmt.executeUpdate() != 0;
        stmt.close();
        return success;
    }

    public ArrayList getGradeSchedule(String gh, String xq) throws Exception {
        ResultSet resultSet = null;
        String sql = "select e.kh,km,xm,pscj,kscj,zpcj from e,s,c where e.kh=c.kh and e.xh=s.xh and gh=? and xq=? ORDER BY e.kh;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, gh);
        stmt.setString(2, xq);
        resultSet = stmt.executeQuery();
        ArrayList<GradeScheduleBean> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            String kh = resultSet.getString("kh");
            String km = resultSet.getString("km");
            String xm = resultSet.getString("xm");
            String pscj = resultSet.getString("pscj");
            String kscj = resultSet.getString("kscj");
            String zpcj = resultSet.getString("zpcj");
            arrayList.add(new GradeScheduleBean(kh, km, xm, pscj, kscj, zpcj));
        }
        stmt.close();
        resultSet.close();
        return arrayList;
    }

    public boolean ChangeGrade(String pscj, String kscj, String kh, String xq, String gh, String xm) throws Exception {
        boolean success = false;
        String sql =
                "update e set pscj=?,kscj=?,zpcj=? where kh=? and xq=? and gh=? and xh=(select xh from s where s.xm=?);\n";
        CallableStatement cs = connection.prepareCall("{call getzpcj(?,?,?)}");
        PreparedStatement stmt = connection.prepareStatement(sql);

        cs.setString(1,pscj);
        cs.setString(2,kscj);
        cs.registerOutParameter(3, Types.VARCHAR);
        cs.execute();
        String zpcj = cs.getString(3);

        stmt.setString(1, pscj);
        stmt.setString(2, kscj);
        stmt.setString(3, zpcj);
        stmt.setString(4, kh);
        stmt.setString(5, xq);
        stmt.setString(6, gh);
        stmt.setString(7, xm);
        success = stmt.executeUpdate() != 0;
        stmt.close();
        return success;
    }

    public ArrayList getTeacherCourseSchedule(String gh,String xq) throws Exception {
        ResultSet resultSet = null;
        String sql = "select o.kh,km,xf,sksj from o,c where o.kh=c.kh and gh=? and xq=? ORDER BY kh;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, gh);
        stmt.setString(2, xq);
        resultSet = stmt.executeQuery();
        ArrayList<CourseScheduleBean> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            String kh = resultSet.getString("kh");
            String km = resultSet.getString("km");
            String xf = resultSet.getString("xf");
            String sksj = resultSet.getString("sksj");
            arrayList.add(new CourseScheduleBean(kh, km, xf, sksj));
        }
        stmt.close();
        resultSet.close();
        return arrayList;
    }

    public String getXQ() throws Exception {
        ResultSet resultSet = null;
        String sql = "select xq from manager group by xq;";
        Statement stmt =connection.createStatement();
        resultSet = stmt.executeQuery(sql);
        resultSet.next();
        String xq = resultSet.getString("xq");
        stmt.close();
        resultSet.close();
        return xq;
    }
    public boolean changeXQ(String xq) throws Exception{
        boolean success = false;
        String sql = "update manager set xq=? where id>0;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, xq);
        success = stmt.executeUpdate() != 0;
        stmt.close();
        return success;
    }

    public boolean managerOpenCourse(String xq, String kh, String gh, String sksj) throws Exception {
        boolean success = false;
        String sql = "insert into o(xq, kh, gh,sksj) values(?, ?, ? , ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, xq);
        stmt.setString(2, kh);
        stmt.setString(3, gh);
        stmt.setString(4, sksj);
        success = stmt.executeUpdate() != 0;
        stmt.close();
        return success;
    }

    public ArrayList getGrade(String xh,String xq) throws Exception {
        ResultSet resultSet = null;
        String sql = "select e.kh,km,xf,xm,zpcj from e,c,t  where e.kh=c.kh and e.gh=t.gh and xh=? and xq=? ORDER BY e.kh;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, xh);
        stmt.setString(2, xq);
        resultSet = stmt.executeQuery();
        ArrayList<CourseScheduleBean> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            String kh = resultSet.getString("kh");
            String km = resultSet.getString("km");
            String xf = resultSet.getString("xf");
            String xm = resultSet.getString("xm");
            String jidian = resultSet.getString("zpcj");
            arrayList.add(new CourseScheduleBean(kh, km, xf, xm, jidian));
        }
        stmt.close();
        resultSet.close();
        return arrayList;
    }

}
