public class Test2 {
	 public static void main(String[] args)  {
	         
	        String line =  "AB";
	         
	        String res = fullStr(line);
	        System.out.println(res);
		 System.out.println("test local git commit");

	    }
	 
	    public static String fullStr(String line) {
	        char[] ch = line.toCharArray();
	        char[] ch1 = new char[ch.length];
	        char[] ch2 = new char[ch.length];
	        int j = ch.length -1;
	        int k = 0;
	        int i = 0;
	        for (; i < ch.length; i++) {
	            if (i < j ) {
	                if (ch[i] == ch[j]) {
	                    ch1[i] = ch[i];  
	                    ch2[k++] = ch[j--];
	                } else {
	                    ch1[i] = ch[i]; 
	                    ch2[k++] = ch[i]; 
	                }
	            }
	            if (j == i) {
	                ch1[i] = ch[i];
	                break;
	            }
	        }
	        StringBuffer sb = new StringBuffer();
	        for (int l = 0; l <= i; l++)
	        sb.append(ch1[l]);
	        for (k--; k >=0; k--) {
	            sb.append(ch2[k]);
	        } 
	        return sb.toString();

	    }
}
