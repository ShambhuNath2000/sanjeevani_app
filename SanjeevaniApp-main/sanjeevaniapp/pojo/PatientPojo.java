/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevaniapp.pojo;

import java.sql.Date;



/**
 *
 * @author sumon
 */
public class PatientPojo {

    @Override
    public String toString() {
        return "PatientPojo{" + "Patient_id=" + Patient_id + ", F_Name=" + F_Name + ", L_Name=" + L_Name + ", Age=" + Age + ", Gender=" + Gender + ", M_status=" + M_status + ", Address=" + Address + ", City=" + City + ", Mobile_no=" + Mobile_no + ", date=" + date + ", OTP=" + OTP + ", OPD=" + OPD + ", Doctor_id=" + Doctor_id + ", Status=" + Status + '}';
    }

    public PatientPojo(String Patient_id, String F_Name, String L_Name, int Age, String Gender, String M_status, String Address, String City, String Mobile_no, Date date, int OTP, String OPD, String Doctor_id, String Status) {
        this.Patient_id = Patient_id;
        this.F_Name = F_Name;
        this.L_Name = L_Name;
        this.Age = Age;
        this.Gender = Gender;
        this.M_status = M_status;
        this.Address = Address;
        this.City = City;
        this.Mobile_no = Mobile_no;
        this.date = date;
        this.OTP = OTP;
        this.OPD = OPD;
        this.Doctor_id = Doctor_id;
        this.Status = Status;
    }

    public PatientPojo() {
    }

    public String getPatient_id() {
        return Patient_id;
    }

    public void setPatient_id(String Patient_id) {
        this.Patient_id = Patient_id;
    }

    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String F_Name) {
        this.F_Name = F_Name;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setL_Name(String L_Name) {
        this.L_Name = L_Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getM_status() {
        return M_status;
    }

    public void setM_status(String M_status) {
        this.M_status = M_status;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getMobile_no() {
        return Mobile_no;
    }

    public void setMobile_no(String Mobile_no) {
        this.Mobile_no = Mobile_no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getOTP() {
        return OTP;
    }

    public void setOTP(int OTP) {
        this.OTP = OTP;
    }

    public String getOPD() {
        return OPD;
    }

    public void setOPD(String OPD) {
        this.OPD = OPD;
    }

    public String getDoctor_id() {
        return Doctor_id;
    }

    public void setDoctor_id(String Doctor_id) {
        this.Doctor_id = Doctor_id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    private String Patient_id;
    private String F_Name;
    private String L_Name;
    private int Age;
    private String Gender;
    private String M_status;
    private String Address;
    private String City;
    private String Mobile_no;
    private Date date;
    private int OTP;
    private String OPD;
    private String Doctor_id;
    private String Status;
    
    
}
