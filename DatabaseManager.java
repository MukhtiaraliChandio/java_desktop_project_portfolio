/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package USindhDatabaseManager;

import USindhBeans.*;
import java.sql.*;
import java.util.Vector;


public class DatabaseManager {
    
    private static Connection conn;
    
    static{
        
       try{
          init();   
       }catch(Exception e){
           e.printStackTrace();
       } 
        
    }// end of static method.

    private static void init() throws Exception {
   
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String path="C:\\Users\\MUKHTIAR ALI CHANDIO\\Documents\\NetBeansProjects\\usindhAdmissionSystem\\usindh.accdb";
        String url="jdbc:ucanaccess://"+path;
        conn = DriverManager.getConnection(url);
        System.out.println("Conntion Established");
        
    }// end of static init method.
    
    public static Vector getFaculty() throws Exception{
      
        String query="select * from Faculty";
        System.out.println(query);
        
        Statement st=null;
        ResultSet result=null;
        try{
            st=conn.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                
                FacultyBean bean=new FacultyBean();
                
                bean.setFacId(result.getInt("fac_id"));
                bean.setFacName(result.getString("fac_name"));
                bean.setRemarks(result.getString("remarks"));
                
                v.addElement(bean);
                        
            }// end of while loop.
            
            return v;
            
        }finally{
            if(result!=null)result.close();
            if(st!=null)st.close();
        }
        
    }// end of getFaculty select method to show record from databse.
    
 public static Vector getDepartment(int facId) throws Exception{
        
        String query="SELECT * FROM Department where fac_Id="+facId;
        System.out.println(query);
        
        Statement st=null;
        ResultSet result=null;
        try{
            st=conn.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                
             DepartmentBean bean=new DepartmentBean();
             
             bean.setFacId(result.getInt("fac_Id"));
             bean.setDeptId(result.getInt("dept_Id"));
             bean.setDeptname(result.getString("dept_name"));
             bean.setRemarks(result.getString("remarks"));
             
             //bean.setDeptId(facId);
             
             v.addElement(bean);
                     
            }// end of while loop.
            return v;
            
        }finally{
            if(result!=null)result.close();
            if(st!=null)st.close();
        }
        
  
    }// end of getDepartment select method to show record from databse.
 
public static Vector getProgram(int dept_Id)throws Exception{

    
        String query="Select * from Program where dept_Id="+dept_Id;
        System.out.println("Query: "+query);
        
        Statement st=null;
        ResultSet result=null;
        try{
            st=conn.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                
             ProgramBean bean=new ProgramBean();
             
             bean.setDeptId(result.getInt("dept_Id"));
             bean.setProgId(result.getInt("prog_Id"));
             bean.setProgName(result.getString("prog_name"));
             bean.setDuration(result.getString("duration"));
             bean.setRemarks(result.getString("remarks"));
             
             
             
             v.addElement(bean);
                     
            }// end of while loop.
            return v;
            
        }finally{
            if(result!=null)result.close();
            if(st!=null)st.close();
        }
           
}// end of getDepartment select method to show record from databse. 

public static Vector getBatch(int progId)throws Exception{

    
        String query="Select * from Batch where prog_Id="+progId;
        System.out.println("Query: "+query);
        
        Statement st=null;
        ResultSet result=null;
        try{
            st=conn.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                
             BatchBean bean=new BatchBean();
             
           
             bean.setProgId(result.getInt("prog_Id"));
             bean.setBatchId(result.getInt("batch_Id"));
             bean.setBatchYear(result.getString("batch_year"));
             bean.setShift(result.getString("shift"));
             bean.setGroupDesc(result.getString("group_desc"));
             bean.setRemarks(result.getString("remarks"));
             
             
             
             v.addElement(bean);
                     
            }// end of while loop.
            return v;
            
        }finally{
            if(result!=null)result.close();
            if(st!=null)st.close();
        }
           
}// end of getDepartment select method to show record from databse. 

public static Vector getStudent(int batchId)throws Exception{

    
        String query="Select * from Student where batch_Id="+batchId;
        System.out.println("Query: "+query);
        
        Statement st=null;
        ResultSet result=null;
        try{
            st=conn.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                
             StudentBean bean=new StudentBean();
             
             bean.setBatchId(result.getInt("batch_Id"));
             bean.setStdId(result.getInt("std_Id"));
             bean.setStudentName(result.getString("std_name"));
             bean.setFatherName(result.getString("father_name"));
             bean.setSurname(result.getString("surname"));
             bean.setRollNo(result.getString("roll_no"));
             bean.setRemarks(result.getString("remarks"));
             
             
             
             v.addElement(bean);
                     
            }// end of while loop.
            return v;
            
        }finally{
            if(result!=null)result.close();
            if(st!=null)st.close();
        }
           
}// end of getDepartment select method to show record from databse. 
    
public static int deleteFaculty(int facId)throws Exception{
   
    String query="delete from Faculty where fac_Id="+facId;
    System.out.print("Query:"+query);
    Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
        
                
    }finally{
        if(st!=null)st.close();
    }
    
    
}// end of getFaculty select method to  delete record from databse.
   
public static int deleteDepartment(int dept_Id)throws Exception{
   
    String query="delete from Department where dept_Id="+dept_Id;
    System.out.print("Query:"+query);
    Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
        
                
    }finally{
        if(st!=null)st.close();
    }
    
    
}// end of getFaculty select method to  delete record from databse.
   
public static int deleteProgram(int progId)throws Exception{
   
    String query="delete from Program where prog_Id="+progId;
    System.out.print("Query:"+query);
    Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
        
                
    }finally{
        if(st!=null)st.close();
    }
    
    
}// end of getFaculty select method to  delete record from databse.
   

public static int deleteBatch(int batchId)throws Exception{
   
    String query="delete from Batch where batch_Id="+batchId;
    System.out.print("Query:"+query);
    Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
        
                
    }finally{
        if(st!=null)st.close();
    }
    
    
}// end of getFaculty select method to  delete record from databse.
   

public static int deleteStudent(int stdId)throws Exception{
   
    String query="delete from Student where std_Id="+stdId;
    System.out.print("Query:"+query);
    Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
                
    }finally{
        if(st!=null)st.close();
    }
    
    
}// end of getFaculty select method to  delete record from databse.
   
public static int addFaculty(String facName, String remarks)throws Exception{
   
    String query="insert into Faculty(fac_name, remarks) values ('"+facName+"','"+remarks+"')";
    System.out.print("Query:"+query);
    Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
                
    }finally{
        if(st!=null)st.close();
    }
    
    
}// end of getFaculty select method to  delete record from databse.
   
public static int addDepartment(int facId, String deptName, String remarks)throws Exception{
   
   String query="insert into Department(fac_Id, dept_name, remarks) values ('"+facId+"', '"+deptName+"', '"+remarks+"')";
    System.out.print("Query :"+query);
    Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
                
    }finally{
        if(st!=null)st.close();
        
    }    
}// end of getFaculty select method to  delete record from databse.
   
public static int addProgram(int deptId, String progName, String duration, String remarks)throws Exception{
   
    String query="insert into Program(dept_Id, prog_name, duration, remarks) values ('"+deptId+"', '"+progName+"','"+duration+"','"+remarks+"')";
    System.out.print("Query:"+query);
    Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
                
    }finally{
        if(st!=null)st.close();
    }
    
    
}// end of getFaculty select method to  delete record from databse.
   
public static int addBatch(int progId, String batchYear, String remarks)throws Exception{
   
   String query="insert into Batch(prog_Id, batch_year, remarks) values ('"+progId+"' , '"+batchYear+"', '"+remarks+"')";
    
    System.out.print("Query:"+query);
    Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
                
    }finally{
        if(st!=null)st.close();
    }
    
    
}// end of getFaculty select method to  delete record from databse.
   
public static int addStudent(int batchId ,String stdName, String  fatherName, String surname, String rollNo, String remarks)throws Exception{
   
    String query="insert into Student(batch_Id, std_name, father_name, surname, roll_no, remarks) values ('"+batchId+"','"+stdName+"','"+fatherName+"', '"+surname+"', '"+rollNo+"', '"+remarks+"')";
    System.out.print("Query:"+query);
    Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
                
    }finally{
        if(st!=null)st.close();
    }
    
    
}// end of getFaculty select method to  delete record from databse.
   
 public static int updateFaculty(int facId, String facName, String remarks) throws Exception{
     
     String query="Update Faculty Set fac_name='"+facName+"',remarks='"+remarks+"' where fac_Id="+facId;
     System.out.print("Query:"+query);
     
     Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
                
    }finally{
        if(st!=null)st.close();
    }
    
     
     
     
 } // end of getFaculty update method to  delete record from databse. 
    
   public static int updateDepartment(int deptId, String deptName, String remarks) throws Exception{
     
     String query="update Department Set dept_name='"+deptName+"',remarks='"+remarks+"' where dept_Id="+deptId;
     System.out.print("Query:"+query);
     
     Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
                
    }finally{
        if(st!=null)st.close();
    }
    
     
     
     
 } // end of getFaculty update method to  delete record from databse.
   
public static int updateProgram(int progId, String progName,  String duration ,String remarks) throws SQLException{
     
     String query="update Program Set prog_name='"+progName+"',duration='"+duration+"', remarks='"+remarks+"' where prog_Id="+progId;
     System.out.print("Query:"+query);
     
     Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
                
    }finally{
        if(st!=null)st.close();
    }
    
     
} // end of getFaculty update method to  delete record from databse. 
public static int updateBatch(int batchId, String batchYear, String remarks) throws SQLException{
     
     String query="update Batch Set batch_year='"+batchYear+"',remarks='"+remarks+"' where batch_Id="+batchId;
     System.out.print("Query:"+query);
     
     Statement st=null;
    try{
        st=conn.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
                
    }finally{
        if(st!=null)st.close();
    }
    
     
     
     
 } // end of getFaculty update method to  delete record from databse. 
 /*public static int updateStudent(int stdId, String stdName,  String fatherName , String surname, String rollNo,  String remarks) throws Exception{
     
        String query="update student Set std_name='"+stdName+"', father_name='"+fatherName+"',surname='"+surname+"',  roll_no='"+rollNo+"'  remarks='"+remarks+"' where std_Id="+stdId;
        System.out.print("Query:"+query);

        Statement st=null;
        try{
            st=conn.createStatement();
            int rows=st.executeUpdate(query);
            return rows;

        }finally{
            if(st!=null)st.close();
        }
    
     
} // end of getFaculty update method to  delete record from databse.*/ 

    public static int updateStudent(int stdId, String stdName, String fatherName, String surname, String rollNo , String remarks)throws Exception {
         
        String query="update student Set std_name='"+stdName+"', father_name='"+fatherName+"',surname='"+surname+"',  roll_no='"+rollNo+"' , remarks='"+remarks+"' where std_Id="+stdId;
        
        System.out.print("Query:"+query);

        Statement st=null;
        try{
            st=conn.createStatement();
            int rows=st.executeUpdate(query);
            return rows;

        }finally{
            if(st!=null)st.close();
        }
     
    }

    



}// end of DatabaseManager class.