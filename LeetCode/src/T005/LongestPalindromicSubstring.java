package T005;
//参考：https://www.felix021.com/blog/read.php?2040
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		
		//String s = "abccbadafadfgnjjngfdaffdlgddfmdmmdalm";
		String s = "abccbadafad";
		System.out.println(longestPalindrome(s));
	}
	 public static String longestPalindrome(String s) {
		//字符串预处理
		 String s1="$";
		 for(int i=0;i<s.length();i++){
			 s1=s1+"#"+s.charAt(i);
		 }
		 s1=s1+"#@";
		//Manacher算法：开始
		 int mx=0,id=0;//mx表示p[i]之前子串回文右边界的最大值，id为该子串的中心位置
		 int[] p=new int[s1.length()];//存放所有字符对应的回文半径
		 /*
		  * s1:  $ # a # b # c # c # b # a # d # a # f # a # d # #
		  * p[]: 1 1 2 1 2 1 2 7 2 1 2 1 2 1 4 1 2 1 6 1 2 1 2 1 1
		  */
		 
		 //以下循环i从1开始到倒数第二个值，因为首位的字符是人为加入的，可不考虑
		 for(int i=1;i<s1.length()-1;i++){
			 //当mx>i表示当前扫描点位于前面某个子串的回文字符串内，这时p[i]不需要从1开始
			 //反之，p[i]=1
			 //
			 p[i] = mx > i ? Math.min(p[2*id-i], mx-i) : 1;
			 
			 //得到p[i]的初始值后，循环判断i两侧对称点的字符是否相等
			 //tips:下面的下标i + p[i]和i - p[i]是不会溢出的
			 //首先i显然大于等于p[i]，故i-p[i]>=0;
			 //又因为p[i]>=0,i<s1.length,而s1最后两个字符是认为添加的，当进行到倒数第二个字符时
			 //不满足while循环了，此时p[i]=1；故i+p[i]<s1.length也不会溢出
			 while (s1.charAt(i + p[i]) == s1.charAt(i - p[i])){p[i]++;}
			 
			 //更新mx，id的值
			 if (i + p[i] > mx) {
			      mx = i + p[i];
			      id = i;
			   }
		 }
		 //Manacher算法：结束
		 System.out.println(s1);
		 for(int i=0;i<p.length;i++){
			 System.out.print(p[i]+" ");
		 }
		 int idx=0,rad=0;
		 for(int i=0;i<p.length;i++){
			 if(rad<p[i]){
				 idx=i;
				 rad=p[i];
			 }
		 }
		 
		 String s2 = s1.substring(idx-rad+1, idx+rad);
		 s2=s2.replace("$", "");
		 s2=s2.replace("#", "");
		 //
		 return s2;
	 }
}
