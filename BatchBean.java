package USindhBeans;

public class BatchBean {
    
    private int progId;
    private int batchId;
    private String batchYear;
    private String shift;
    private String groupDesc;
    private String remarks;

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public void setBatchYear(String batchYear) {
        this.batchYear = batchYear;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public void setProgId(int progId) {
        this.progId = progId;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getBatchId() {
        return batchId;
    }

    public String getBatchYear() {
        return batchYear;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public int getProgId() {
        return progId;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getShift() {
        return shift;
    }
    
    public String toString(){
        return batchYear;
    }
    
    
    
    
    
    
}// end of BatchBean Class.