package USindhBeans;

public class Encode {
    
  
     public static String shiftDecode(String shift){
    
      if(shift.equals("M"))return "Morning";    
      if(shift.equals("E"))return "Evening";
     
      return shift;
    
    }// end of shiftDecode method.
    
    public static String groupDecode(String group){
        if(group.equals("E"))return "Engineering";
        if(group.equals("M"))return "Medical";
        if(group.equals("G"))return "GGeneral";
        if(group.equals("C"))return "Commerce";
        
        return group;
        
    }// end of groupDecode method.
        
    
}// end of Encode class.