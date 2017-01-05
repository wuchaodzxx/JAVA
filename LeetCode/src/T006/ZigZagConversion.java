package T006;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "PAYPALISHIRING";
		String s="ABCDE";
		System.out.println(convert(s,4));
	}
	public static String convert(String s, int numRows) {
		if(numRows==1||s.length()<=1){
			return s;
		}
        List<String> list = new ArrayList<String>();//存放Z的V部分，每个V用一个字符串表示
        int vLen = 2*numRows-2;//每个V的元素个数
        int numV = s.length()/vLen;//V的个数
        if(s.length()%vLen!=0){
        	numV=numV+1;
        }
        for(int i=1;i<=numV;i++){
        	String V="";
        	for(int j=1;j<=vLen&&(i-1)*vLen+j<=s.length();j++){
        		V=V+s.charAt((i-1)*vLen+j -1);
        	}
        	//System.out.println(V);
        	list.add(V);
        }
        String result = "";
        for(int i=1;i<=numRows;i++){
        	for(int j=0;j<list.size();j++){
        		result=result+getVString(list.get(j),i,vLen);
        		System.out.println(j+":"+i);
        		System.out.println(list.get(j));
        		System.out.println(getVString(list.get(j),i,vLen));
        	}
        }
		return result;
    }
	public static String getVString(String V,int linNum,int vLen){
		if(V.length()<linNum) return (String) "";//如果V的长度小于行数linNum
		if(linNum==1) return V.charAt(0)+"";//如果linNum==1,返回V的第一个元素
		if(V.length()<=(vLen+2)/2) return V.charAt(linNum-1)+"";//如果V只有左侧有值
		if(linNum==(vLen+2)/2) return V.charAt((vLen+2)/2-1)+"";//如果行数等于V的总行数，则去V的底部顶点值
		if(vLen+2-linNum<=V.length()) return V.charAt(linNum-1)+""+V.charAt(vLen+2-linNum-1)+"";
		if(vLen+2-linNum>V.length()) return V.charAt(linNum-1)+"";
		return "";
	}
}
