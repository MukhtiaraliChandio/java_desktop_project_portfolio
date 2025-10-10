package USindhBeans;

public class StudentBean {
    
private int batchId;
private int stdId;
private String studentName;
private String fatherName;
private String surname;
private String rollNo;
private String remarks;

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBatchId() {
        return batchId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getRollNo() {
        return rollNo;
    }

    public int getStdId() {
        return stdId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSurname() {
        return surname;
    }

    public String toString(){
        
        return rollNo;
    }
    
    
}// end of StudentBean Class.