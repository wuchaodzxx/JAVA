package T028;

public class ImplementStrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("afasfgaksadgskfaddghjhkd","kd"));
	}
	
	public static int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        int res=-1;
        
        for(int i=0;i<=(haystack.length()-needle.length());i++){
        	boolean flag = true;
        	for(int j=0;j<needle.length();j++){
        		if(needle.charAt(j)!=haystack.charAt(i+j)) flag=false;
        	}
        	if(flag) return i;
        }
		
		return -1;
    }
	
}
