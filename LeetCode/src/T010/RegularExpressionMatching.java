package T010;

public class RegularExpressionMatching {

	public static void main(String[] args) {

		System.out.println(isMatch("aab","c*a*b"));
	}
	public static boolean isMatch(String s, String p) {

	    if (s == null || p == null) {
	        return false;
	    }
	    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	    dp[0][0] = true;
	    for (int i = 0; i < p.length(); i++) {
	        if (p.charAt(i) == '*' && dp[0][i-1]) {
	            dp[0][i+1] = true;
	        }
	    }
	    printArray(dp);
	    for (int i = 0 ; i < s.length(); i++) {
	        for (int j = 0; j < p.length(); j++) {
	            if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == '*') {
	                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
	                    dp[i+1][j+1] = dp[i+1][j-1];
	                } else {
	                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
	                }
	            }
	        }
	    }
	   // printArray(dp);
	    return dp[s.length()][p.length()];
	}
	/* 
	 * isMatch("aa","a") → false
	 * isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false
	 * isMatch("aa", "a*") → true
	 * isMatch("aa", ".*") → true
	 * isMatch("ab", ".*") → true
	 * isMatch("aab", "c*a*b") → true
	 */
	public static void printArray(boolean [] arr){
		System.out.print("printArray:");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	
	public static void printArray(boolean[][] V){
		System.out.println("printArray:");
		int rows = V.length;
		int cols = V[0].length;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				System.out.print(V[i][j]+" ");
			}
			System.out.println("");
			
		}
		System.out.println("");
	}
}
