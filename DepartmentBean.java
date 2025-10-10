package USindhBeans;

public class DepartmentBean {
    private int facId;
    private int deptId;
    private String deptname;
    private String remarks;

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptname() {
        return deptname;
    }

    public int getFacId() {
        return facId;
    }

    public String getRemarks() {
        return remarks;
    }
    
    public String toString(){
        
        return deptname;
    }
    
    
    
}// end of DepartmentBean class.
