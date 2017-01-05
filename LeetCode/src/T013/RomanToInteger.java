package T013;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMLXXX"));
	}
	public static int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("I", 1);
        map.put("X", 10);
        map.put("V", 5);
        map.put("M", 1000);
        map.put("C", 100);
        map.put("L", 50);
        map.put("D", 500);
        int x = 0;
        for(int i = s.length()-1;i>=0;i--){
        	if(i==0) return x = x + map.get(s.charAt(i)+"");
        	if(map.get(s.charAt(i)+"")>map.get(s.charAt(i-1)+"")){
        		x = x + map.get(s.charAt(i)+"")-map.get(s.charAt(i-1)+"");
        		i--;
        	}else{
        		x = x + map.get(s.charAt(i)+"");
        	}
        }
		return x;
    }
}
