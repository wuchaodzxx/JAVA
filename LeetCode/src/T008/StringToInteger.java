package T008;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "   +0 123";
		
		System.out.println("result :"+myAtoi(s));
	}
	public static int myAtoi(String str) {
		str=str.trim();
		//str=str.replace(" ", "");
		int tag=1;
		if(str.length()<1) return 0;
		if(str.charAt(0)==43) {
			tag=1;
			str=str.substring(1);
		}else if(str.charAt(0)==45) {
			tag=-1;
			str=str.substring(1);
		}
		if(str.length()<1) return 0;
		//System.out.println(str);
		String res = "";
		for(int i = 0;i<str.length();i++){
			
			if(str.charAt(i)+0>=48 && str.charAt(i)+0 <=57){
				//System.out.println(str.charAt(i)+0);
				res=res+str.charAt(i);
			}else{
				
				break;
			}
		}
		if(res.length()==0){
			return 0;
		}
		
		if(res.length()>10 && tag>0) return Integer.MAX_VALUE;
		if(res.length()>10 && tag<0) return Integer.MIN_VALUE;
		
		long result = Long.parseLong(res)*tag;
		
		if(result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if(result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;
    }
}
