package USindhBeans;

public class FacultyBean {
    
    private int fac_Id;
    private String fac_name;
    private String remarks;

    public void setFacId(int fac_Id) {
        this.fac_Id = fac_Id;
    }

    public void setFacName(String fac_name) {
        this.fac_name = fac_name;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getFacId() {
        return fac_Id;
    }

    public String getFacName() {
        return fac_name;
    }

    public String getRemarks() {
        return remarks;
    }

   
    
    public String toString(){
         
        return fac_name;
    }
    
    
    
    
    
    
    
}// end of FacultyBean class.