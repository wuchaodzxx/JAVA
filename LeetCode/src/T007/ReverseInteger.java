package T007;

import java.math.BigInteger;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=1534236469;
		System.out.println("result :"+reverse(x));
	}
	public static int reverse(int x) {
		int length=0;
		long result=0;//int数值反转后可能溢出，故使用long保存
		
		int tag=1;
		if(x<0) {
			tag=-1;
			x=Math.abs(x);
		}
		//计算int数值的位数
		length = String.valueOf(x).length();
		
		//以下进行反转
		//比如24875--> 2*10^(5-5)+4*10^(5-4)+8*10^(5-3)+7*10^(5-2)+5*10^(5-1) = 57842
		for(int j=length-1;j>=0;j--){
			int k = (int)(x/(Math.pow(10, j)));
			int m = (int)k%10;
			result = (long) (result+m*Math.pow(10, length-1-j));
			//System.out.println(result);
		}
        result = result*tag;
        //当反转的值超出int的范围-2147483648~2147483647时，输出0
        if(result>2147483647 || result<-2147483648) return 0;
        return (int)result;
    }
}
