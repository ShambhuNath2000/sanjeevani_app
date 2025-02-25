/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevaniapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sanjeevaniapp.dbutil.DBconnection;
import sanjeevaniapp.pojo.AppointmentPojo;

/**
 *
 * @author sumon
 */
public class AppointmentDao {
    public static boolean addAppointment(AppointmentPojo apt)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into appointments values(?,?,?,?,?,?,?)");
        ps.setString(1, apt.getPatient_id());
        ps.setString(2,apt.getPatient_name());
        ps.setString(3, apt.getStatus());
        ps.setString(4,apt.getOPD() );
        ps.setString(5,apt.getDate_Time());
        ps.setString(6,apt.getDoctor_Name());
        ps.setString(7,apt.getMobile_no());
        return ps.executeUpdate()==1;
    }
    public static List<AppointmentPojo> getAllAppointmentsByDoctorName(String doctorName)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from appointments where doctor_name=? and status='REQUEST' order by patient_id");
        ps.setString(1, doctorName);
        ResultSet rs=ps.executeQuery();
        List<AppointmentPojo> applist=new ArrayList<>();
        while(rs.next())
        {
            AppointmentPojo app=new AppointmentPojo();
            app.setPatient_id(rs.getString("patient_id"));
            app.setPatient_name(rs.getString("patient_name"));
            app.setOPD(rs.getString("opd"));
            app.setDate_Time(rs.getString("date_time"));
            app.setMobile_no(rs.getString("mobile_no"));
            app.setStatus(rs.getString("status"));
            applist.add(app);
        }
        return applist;
    }
    public static boolean updateStatus(AppointmentPojo app)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update appointments set status=?,date_time=? where patient_id=?");
        ps.setString(1, app.getStatus());
        ps.setString(2,app.getDate_Time());
        ps.setString(3,app.getPatient_id());
        return ps.executeUpdate()==1;
    }
    public static void RemovePatient(String Id)throws SQLException
    {
         Connection conn=DBconnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("delete from appointments where Patient_id=?");
         ps.setString(1, Id);
         ps.executeUpdate();
    }
    public static boolean Updateappoitnment(AppointmentPojo App)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update Appointments set patient_name=?,opd=?,doctor_name=?,mobile_no=? where patient_id=?");
         
         ps.setString(1, App.getPatient_name());
         ps.setString(2, App.getOPD());
       //  ps.setString(3, App.getDate_Time());
         ps.setString(3, App.getDoctor_Name());
         ps.setString(4,App.getMobile_no());
         ps.setString(5, App.getPatient_id());
         
         return ps.executeUpdate()==1;
    }
    public static List<AppointmentPojo> getAllAppoinmentByName(String doctorName)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from appointments where doctor_name=? and status='CONFIRM' order by patient_id");
        ps.setString(1, doctorName);
        ResultSet rs=ps.executeQuery();
        List<AppointmentPojo> applist=new ArrayList<>();
        while(rs.next())
        {
            AppointmentPojo app=new AppointmentPojo();
            app.setPatient_id(rs.getString("patient_id"));
            app.setPatient_name(rs.getString("patient_name"));
            app.setOPD(rs.getString("opd"));
            app.setDate_Time(rs.getString("date_time"));
            app.setMobile_no(rs.getString("mobile_no"));
            app.setStatus(rs.getString("status"));
            applist.add(app);
        }
        return applist;
    }
}
