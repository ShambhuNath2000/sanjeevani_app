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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sanjeevaniapp.dbutil.DBconnection;
import sanjeevaniapp.pojo.PatientPojo;

/**
 *
 * @author sumon
 */
public class PatientDao {
   public static String getNewPatientId()throws SQLException
   {
        Connection conn=DBconnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max( PATIENT_ID) from patients");
        rs.next();
        int patId=101;
        String id=rs.getString(1);
        if(id!=null)
        {
            String num=id.substring(3);
            patId=Integer.parseInt(num)+1;
        }
        return "PAT"+patId;
   }
   public static boolean addPatient(PatientPojo pat)throws SQLException{
     Connection conn=DBconnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Insert into patients values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
     ps.setString(1,pat.getPatient_id());
     ps.setString(2, pat.getF_Name());
     ps.setString(3,pat.getL_Name());
     ps.setInt(4, pat.getAge());
     ps.setString(5, pat.getGender());
     ps.setString(6, pat.getM_status());
     ps.setString(7, pat.getAddress());
     ps.setString(8,pat.getCity());
     ps.setString(9, pat.getMobile_no());
     ps.setDate(10, pat.getDate());
     ps.setInt(11, pat.getOTP());
     ps.setString(12,pat.getOPD());
     ps.setString(13, pat.getDoctor_id());
     ps.setString(14, pat.getStatus());
     return ps.executeUpdate()==1;
}
   public static List<PatientPojo> getAllPatientdetails()throws SQLException
   {
       Connection conn=DBconnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from patients order by patient_id");
        List<PatientPojo>patlist=new ArrayList<>();
        while(rs.next())
        {
            PatientPojo pat=new PatientPojo();
            pat.setPatient_id(rs.getString("patient_id"));
            pat.setF_Name(rs.getString("first_name"));
            pat.setL_Name(rs.getString("last_name"));
            pat.setAge(rs.getInt("age"));
            pat.setGender(rs.getString("gender"));
            pat.setM_status(rs.getString("m_status"));
            pat.setAddress(rs.getString("address"));
            pat.setCity(rs.getString("city"));
             pat.setMobile_no(rs.getString("mobile_no"));
            pat.setDate(rs.getDate("p_date"));
          pat.setOPD(rs.getString("opd"));
           pat.setStatus(rs.getString("status"));
          pat.setDoctor_id(rs.getString("doctor_id"));
          patlist.add(pat);   
        }
        return patlist;
   }
   public static List<PatientPojo>getAllPatientsByDoctorId(String doctorId)throws SQLException
   {
       Connection conn=DBconnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select * from patients where doctor_id=? and status='REQUEST' order by patient_id");
    ps.setString(1,doctorId);
    ResultSet rs=ps.executeQuery();
    List<PatientPojo>patList=new ArrayList<>();
    while(rs.next())
    {
       PatientPojo pat=new PatientPojo();
    pat.setPatient_id(rs.getString("patient_id"));
    pat.setF_Name(rs.getString("first_name")+" "+rs.getString("last_name"));
    pat.setDate(rs.getDate("p_date"));
    pat.setOPD(rs.getString("opd"));
    patList.add(pat);    
    }
    return patList;
   }
   public static boolean updateStatus(String patientId)throws SQLException{
     Connection conn=DBconnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update patients set status='CONFORM' where patient_id=?" );
     ps.setString(1, patientId);
     return ps.executeUpdate()==1;
     
     
 }
   public static List<String> getAllPatientsId()throws SQLException
   {
       Connection conn=DBconnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery("select patient_id from patients");
       List<String> patientIdList=new ArrayList<>();
       while(rs.next())
       {
          patientIdList.add(rs.getString(1));
       }
       return patientIdList;
   }
   public static boolean RemovePatient(String PatientId)throws SQLException
   {
       AppointmentDao.RemovePatient(PatientId);
       Connection conn=DBconnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("delete from patients where patient_id=?");
        ps.setString(1,PatientId);
        int ans=ps.executeUpdate();
        return ans==1;
   }
   public static PatientPojo getAllPatientDetailsById(String id)throws SQLException
   {
       Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from Patients where Patient_id=?");
        ps.setString(1, id);
        ResultSet rs=ps.executeQuery();
        rs.next();
       PatientPojo pat=new PatientPojo();
           
            pat.setPatient_id(rs.getString("patient_id"));
            pat.setF_Name(rs.getString("first_name"));
            pat.setL_Name(rs.getString("last_name"));
            pat.setAge(rs.getInt("age"));
            pat.setGender(rs.getString("gender"));
            pat.setM_status(rs.getString("m_status"));
            pat.setAddress(rs.getString("address"));
            pat.setCity(rs.getString("city"));
            pat.setMobile_no(rs.getString("mobile_no"));
            pat.setDate(rs.getDate("p_date"));
            pat.setOPD(rs.getString("opd"));
            pat.setStatus(rs.getString("status"));
            pat.setDoctor_id(rs.getString("doctor_id"));
          
            return pat;        
   }
   public static boolean UpdatePatient(PatientPojo pat)throws SQLException
   {
        Connection conn=DBconnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("update patients set first_name=?,last_name=?,age=?,address=?,city=?,mobile_no=?,opd=?,doctor_id=? where patient_id=?");
       ps.setString(1, pat.getF_Name());
       ps.setString(2, pat.getL_Name());
       ps.setInt(3, pat.getAge());
       ps.setString(4, pat.getAddress());
       ps.setString(5, pat.getCity());
       ps.setString(6, pat.getMobile_no());
      // ps.setDate(7, pat.getDate());
       ps.setString(7, pat.getOPD());
       ps.setString(8, pat.getDoctor_id());
       ps.setString(9,pat.getPatient_id() );
       
       return ps.executeUpdate()==1;
   }
   
}
