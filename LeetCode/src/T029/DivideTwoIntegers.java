package T029;

public class DivideTwoIntegers {

	public static void main(String[] args) {
//divide(-2147483648,-1)
		System.out.println(divide(-2147483648,-2));
	}
	
	public static int divide(int dividend, int divisor) {
	    long isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -1 : 1;
	    long absDividend = Math.abs((long) dividend);
	    long absDivisor = Math.abs((long) divisor);
	    long result = 0;
	    while(absDividend >= absDivisor){
	        long tmp = absDivisor, count = 1;
	        while(tmp <= absDividend){
	            tmp <<= 1;
	            count <<= 1;
	        }
	        result += count >> 1;
	        absDividend -= tmp >> 1;
	    }
	    result = result*isNegative;
	    if(result>Integer.MAX_VALUE || result <Integer.MIN_VALUE) return Integer.MAX_VALUE;
	    return  (int) result;
	}
	
}
