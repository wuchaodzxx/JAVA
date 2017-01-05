package T012;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 4;
		System.out.println(intToRoman(1980));
	}
	public static String intToRoman(int num) {
        
        //
        String roman = "";
        if(num<=0) return "";
        if(num<=10){
        	String[] tens = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        	roman = roman+tens[num-1];
        	
        }
        if(10<num && num<100){ //90以内都可以用I V X L表示
        	String[] ten2nines = new String[] {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"}; //10,20,30,40,50,60,70,80
        	int H = ((int) (num/10));
        	int L = num-H*10;
        	roman = roman + ten2nines[H-1] + intToRoman(L);
        }
        
        if(100<=num && num<1000){
        	String[] len = new String[] {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};//100,200,300,400,500,600,700,800,900
        	int H = ((int) (num/100));
        	int L = num-H*100;
        	roman = roman + len[H-1] + intToRoman(L);
        }
        if(1000<=num && num <4000){
        	String[] len = new String[] {"M","MM","MMM"};
        	int H = ((int) (num/1000));
        	int L = num-H*1000;
        	System.out.println("H:"+H+",L:"+L);
        	roman = roman + len[H-1] + intToRoman(L);
        }
		return roman;
    }
	public static String intToRoman2(int num) {
	    String data[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    int value[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1}, base = -1;
	    StringBuilder result = new StringBuilder();

	    for(int i = 0;i < data.length;i++){
	        if((base=num/value[i])!=0){
	            while(base--!=0) result.append(data[i]);
	            num=num%value[i];
	        }
	    }
	    return result.toString();
	}
}
