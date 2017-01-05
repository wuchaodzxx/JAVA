package T017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("234"));
	}
	 public static List<String> letterCombinations(String digits) {
	     String[] s = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	     List<List<String>> list = new ArrayList<List<String>>();
	     List<String> res = new ArrayList<String>();
	     if(digits.length()<=0) return res;
	     
	     for(int i=0;i<digits.length();i++){
	    	 int num = Integer.parseInt(digits.charAt(i)+"");
	    	 List<String> L = new ArrayList<String>();
	    	 char [] c = s[num].toCharArray();
	    	 for(int k=0;k<c.length;k++){
	    		 L.add(c[k]+"");
	    	 }
	    	 list.add(L);
	     }
	     
	     list = getStringList(list);
	     res = list.get(0);
	    
		 return res;
	}
	 
	public static List<List<String>> getStringList(List<List<String>> list){
		if(list.size()==1) return list;
		List<List<String>> list2 = new ArrayList<List<String>>();
		List<String> s = new ArrayList<String>();
		if(list.size()==2){
			for(int i=0;i<list.get(0).size();i++){
				for(int j=0;j<list.get(1).size();j++){
					s.add(list.get(0).get(i)+list.get(1).get(j));
				}
			}
			list2.add(s);
			list = getStringList(list2);
		}
		if(list.size()>2){
			for(int i=0;i<list.get(0).size();i++){
				for(int j=0;j<list.get(1).size();j++){
					s.add(list.get(0).get(i)+list.get(1).get(j));
				}
			}
			list2.add(s);
			for(int k=2;k<list.size();k++){
				list2.add(list.get(k));
			}
			list = getStringList(list2);
		}
		return list;
	}
}
