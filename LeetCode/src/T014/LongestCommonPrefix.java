package T014;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = new String[]{"abcdf","abcdfwed","abchg","abccd"};
		System.out.println(longestCommonPrefix(strs));

	}
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length==1) return strs[0];
		if(strs.length==0) return "";
		
		String s = strs[0];
		String res = "";
		for(int i=0;i<s.length();i++){
			for(int j=1;j<strs.length;j++){
				if(strs[j].length()>i){
					if(s.charAt(i)!=strs[j].charAt(i)){
						return res;
					}	
				}else{
					return res;
				}
			}
			res=res+s.charAt(i);
		}
        return res;
    }
}
