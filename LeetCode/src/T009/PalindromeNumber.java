package T009;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=121;
		System.out.println(isPalindrome(x));
	}
	public static boolean isPalindrome(int x) {
		if (x < 0) return false;
        long ans = 0;
        long num = x;
        while ( num > 0) {
            ans = ans * 10 + num % 10;
            num = num / 10;
        }
        if (ans != x) return false;
        return true;
    }
	
}
