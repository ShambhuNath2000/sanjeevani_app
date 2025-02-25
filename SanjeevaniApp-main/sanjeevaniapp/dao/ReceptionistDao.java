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
import sanjeevaniapp.pojo.ReceptionistPojo;

/**
 *
 * @author sumon
 */
public class ReceptionistDao {
    public static void updateName(String currName,String newName)throws SQLException{
     Connection conn=DBconnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update receptionists set receptionist_name=? where receptionist_name=?");
     ps.setString(1, newName);
     ps.setString(2, currName);
     ps.executeUpdate();
}
    public static void RemoveEmp(String Removename)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("delete from receptionists where receptionist_name=?");
         ps.setString(1, Removename);
         ps.executeUpdate();
    }
    public static String getNewRecId()throws  SQLException{
   Connection conn=DBconnection.getConnection();
   Statement st=conn.createStatement();
   ResultSet rs=st.executeQuery("Select max(receptionist_id) from receptionists");
   rs.next();
   int recId=101;
   String id=rs.getString(1);
   if(id!=null){
       String num=id.substring(3);
       recId=Integer.parseInt(num)+1;
    }
   return "REC"+recId;
    }
    public static boolean addReceptionist(ReceptionistPojo rec)throws SQLException{
     Connection conn=DBconnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Insert into receptionists values(?,?,?)");
     ps.setString(1,rec.getReceptionistId());
     ps.setString(2,rec.getReceptionistName());
     ps.setString(3,rec.getGender());
     
     return ps.executeUpdate()==1;
    }
     public static List<ReceptionistPojo> getAllReceptionistDetails()throws SQLException{
    Connection conn=DBconnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select * from receptionists order by receptionist_id");
    List<ReceptionistPojo>recList=new ArrayList<>();
    while(rs.next()){
    ReceptionistPojo recep=new ReceptionistPojo();
    recep.setReceptionistId(rs.getString(1));
    recep.setReceptionistName(rs.getString(2));
    recep.setGender(rs.getString(3));
    recList.add(recep);
    
    }
    return recList;
    } 
     public static List<String> getAllReceptionistId()throws SQLException
    {
        Connection conn=DBconnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select receptionist_id from receptionists");
        List<String> recepList=new ArrayList<>();
        while(rs.next())
        {
            recepList.add(rs.getString(1));
        }
        return recepList;
    }
           
    public static boolean deleteReceptionistById(String RecepId)throws SQLException
    {
        Connection conn=DBconnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("select receptionist_name from receptionists where receptionist_id=?");
         ps.setString(1, RecepId);
         ResultSet rs=ps.executeQuery();
         rs.next();
         String RecepName=rs.getString(1);
         UserDao.deleteUserByName(RecepName);
         ps=conn.prepareStatement("Delete from receptionists where receptionist_id=?");
        ps.setString(1, RecepId);
        return ps.executeUpdate()==1;
    }
}
