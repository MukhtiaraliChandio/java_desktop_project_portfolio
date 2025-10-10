package USindhBeans;

public class Decode {
    
    public static String shiftDecode(String shift){
    
      if(shift.equals("Morning"))return "M";    
      if(shift.equals("Evening"))return "E";
     
      return shift;
    
    }// end of shiftDecode method.
    
    public static String groupDecode(String group){
        if(group.equals("Engineering"))return "E";
        if(group.equals("Medical"))return "M";
        if(group.equals("General"))return "G";
        if(group.equals("Commerce"))return "C";
        
        return group;
        
    }// end of groupDecode method.
    
}// end of Decode class.