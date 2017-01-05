package T031;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 	NextPermutation   {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m = new int[]{1,3,2};
		printM(nextPermutation(m));

		
	}

	public static int[] nextPermutation(int[] m) {
       	if(m.length<=0) return m;
		boolean flag=false;
		List<Integer> list = new ArrayList<Integer>();
		list.add(m[m.length-1]);
		for(int i=m.length-2;i>=0;i--){
			Collections.sort(list);
			for(int j=0;j<list.size();j++){
				if(list.get(j)>m[i]){
					flag=true;
					int c = m[i];
					m[i]=list.get(j);
					list.remove(j);
					list.add(c);
					Collections.sort(list);
					for(int n=0;n<list.size();n++){
						m[i+1+n]=list.get(n);
					}
					break;
				}
			}
			if(!flag) list.add(m[i]);
			if(flag) break;
		}
		if(!flag) Arrays.sort(m);
		
		return m;
    }
	
	
	static void printM(int[] M){
		for(int i=0;i<M.length;i++){
			System.out.print(M[i]+" ");
		}
		System.out.println("");
	}

}
