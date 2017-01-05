package T022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("(())");
		list.add("()()");
		printList(generateParenthesis(3));
	}
	public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        if(n<=0) return list;
        if(n==1){
        	list.add("()");
        	return list;
        }
        list.add("()");
        for(int i=1;i<n;i++){
        	list = getParenthesis(list);
        }
		return list;
    }
	
	//向List内的String插入“()”
	public static List<String> getParenthesis(List<String> list){
		Set<String> set = new HashSet<String>();
		 List<String> list2 = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			String s = list.get(i);
			for(int k=0;k<=s.length();k++){
				StringBuffer stringBuffer = new StringBuffer(s);
				String s2 = stringBuffer.insert(k, "()", 0, 2).toString();
				set.add(s2);
			}
		}
		list2.addAll(set);
		return list2;
	}
	public static void printList(List<String> list){
		if(list==null || list.size()<=0) return;
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
