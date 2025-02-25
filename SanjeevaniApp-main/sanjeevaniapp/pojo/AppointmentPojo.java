/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevaniapp.pojo;

/**
 *
 * @author sumon
 */
public class AppointmentPojo {

    @Override
    public String toString() {
        return "AppointmentPojo{" + "Patient_id=" + Patient_id + ", patient_name=" + patient_name + ", Status=" + Status + ", OPD=" + OPD + ", Date_Time=" + Date_Time + ", Doctor_Name=" + Doctor_Name + ", Mobile_no=" + Mobile_no + '}';
    }

    public AppointmentPojo(String Patient_id, String patient_name, String OPD) {
        this.Patient_id = Patient_id;
        this.patient_name = patient_name;
        this.OPD = OPD;
    }

    public String getPatient_id() {
        return Patient_id;
    }

    public void setPatient_id(String Patient_id) {
        this.Patient_id = Patient_id;
    }

    public AppointmentPojo(String Patient_id, String patient_name, String Status, String OPD, String Date_Time, String Doctor_Name, String Mobile_no) {
        this.Patient_id = Patient_id;
        this.patient_name = patient_name;
        this.Status = Status;
        this.OPD = OPD;
        this.Date_Time = Date_Time;
        this.Doctor_Name = Doctor_Name;
        this.Mobile_no = Mobile_no;
    }

    public AppointmentPojo() {
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getOPD() {
        return OPD;
    }

    public void setOPD(String OPD) {
        this.OPD = OPD;
    }

    public String getDate_Time() {
        return Date_Time;
    }

    public void setDate_Time(String Date_Time) {
        this.Date_Time = Date_Time;
    }

    public String getDoctor_Name() {
        return Doctor_Name;
    }

    public void setDoctor_Name(String Doctor_Name) {
        this.Doctor_Name = Doctor_Name;
    }

    public String getMobile_no() {
        return Mobile_no;
    }

    public void setMobile_no(String Mobile_no) {
        this.Mobile_no = Mobile_no;
    }
    private String Patient_id;
    private String patient_name;
    private String Status;
    private String OPD;
    private String Date_Time;
    private String Doctor_Name;
    private String Mobile_no;
    
}
