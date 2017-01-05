package T020;

import java.util.Stack;

public class ValidParentheses {
	static char[] ch1 = new char[]{'{','(','['}; 
	static char[] ch2 = new char[]{'}',')',']'}; 
	public static void main(String[] args) {
		System.out.println("start");
		System.out.println(isValid("{()[({)]}"));

		 
	}
	public static boolean isValid(String s) {
		boolean res = true;
	    Stack<Character> stack = new Stack<Character>();
	    if(s.length()==0) return true;

	    for(int i=0;i<s.length();i++){
	    	if((stack.size()-1)>=0 && matchTo(stack.get(stack.size()-1),s.charAt(i))){
	    		stack.pop();
	    	}else{
	    		stack.push(s.charAt(i));
	    	}
	    }
	    if(stack.size()<=0) res = true;
	    else res = false;
		return res;
	}
	public static boolean matchTo(char c1,char c2){
		for(int i=0;i<3;i++){
			if(ch1[i]==c1&&ch2[i]==c2) return true;
		}
		return false;
	}
}
