package utils;
/**
 *
 * @description Class that encapsulate methods of input validation
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class Validator {
    /**
     *
     * @description Method to validate a valid a positive integer number
     * @param s String to validate
     * @return boolen valid/not valid
     */
    public static boolean isPositiveInteger(String s) {
        int testInt;
        boolean result;
        try { 
            testInt=Integer.parseInt(s);
            if (testInt>0){
                result= true; 
            }else {
                result= false; 
            }
            
        } catch(NumberFormatException e) { 
            result= false; 
        }
        return result;
    }
}
