package T003;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "jbpnbwwd"; 
		System.out.print(lengthOfLongestSubstring(s));
	}
	public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        String res = "";
        char[] carray = s.toCharArray();
        for(char c : carray) {
            int index = res.indexOf(c);
            if (index == -1) {
                res += c;
                max = Math.max(max,res.length());
            } else {
                res = res.substring(index+1);
                res += c;
            }
        }
        return max;
    }
}
