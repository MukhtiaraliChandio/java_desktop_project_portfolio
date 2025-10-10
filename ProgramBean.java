package USindhBeans;

public class ProgramBean {

    private int deptId;
    private int progId;
    private String progName;
    private String duration;
    private String remarks;

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setProgId(int progId) {
        this.progId = progId;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDuration() {
        return duration;
    }

    public int getProgId() {
        return progId;
    }

    public String getProgName() {
        return progName;
    }

    public String getRemarks() {
        return remarks;
    }
    
    public String toString(){
        
        return progName;
    }
    
    
    
    
    
    
}// end of ProgramBean Class.