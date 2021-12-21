import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
public class Txx{ 
	 
    	  public static void main(String[] args) throws Exception{
    	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	        String strings = br.readLine();
    	        String str = br.readLine();
    	        int len = str.length();
    	        //RingBuffer
    	       
    	        LinkedList<String> solution = new LinkedList<>();
    	        solution.pollLast();
    	        List<List<String>> res = null;
    	        
    	        
    	        char[] ch = strings.toCharArray(); 
    	          if(ch[0] == '-'){
    	              if (strings.length() > 11){
    	            System.out.println(0);
    	            return ;
    	              }
    	        } else {
    	            if (strings.length() > 10){
    	                System.out.println(0);
    	                return ;
    	            }  
    	           
    	        }
    	        Integer result = 0;
    	        if ((ch[0] > 48 && ch[0] <=57)) {
    	            for(char c : ch) {
    	                if (c >= 48 && c <= 57 ){
    	                    result = result * 10 - 48 + Integer.valueOf(c);
    	                    if (result > 2147483647 || result < 0) {
    	                        System.out.println(0);
    	                        return ;
    	                    }
    	                    continue;
    	                }else {
    	                    System.out.println(0);
    	                    return ;
    	                }
    	            }
    	             System.out.println(result);
    	                    return ;
    	        }
    	           
    	        if(ch[0] == '-'){ 
    	             for (int i = 1; i < ch.length; i++){
    	                if (ch[i] >= 48 && ch[i] <= 57 ){
    	                    if(result < -2147483648 || result > 0){
    	                        System.out.println(0);
    	                        return ;
    	                    } else {
    	                        result = result * 10 + 48 - Integer.valueOf(ch[i]);
    	                    
    	                        continue;
    	                    }
    	                    
    	                }else {
    	                    System.out.println(0);
    	                    return ;
    	                }
    	            }
    	             System.out.println(result);
    	                    return ;
    	        }
    	          System.out.println(0);
    	           
    	                    return ;
    	        
    	       
    }
    	          
    	          
    	  
    	      
}