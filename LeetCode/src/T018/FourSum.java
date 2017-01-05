package T018;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fourSum(new int[]{-493,-470,-464,-453,-451,-446,-445,-407,-406,-393,-328,-312,-307,-303,-259,-253,-252,-243,-221,-193,-126,-126,-122,-117,-106,-105,-101,-71,-20,-12,3,4,20,20,54,84,98,111,148,149,152,171,175,176,211,218,227,331,352,389,410,420,448,485
				},1057));
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res =new ArrayList<List<Integer>>();
		List<List<Integer>> res2 =new ArrayList<List<Integer>>();
	    for(int i=0;i<nums.length;i++){
	    	int [] num2 = new int[nums.length-1];
	    	int count =0;
	    	for(int j=0;j<nums.length;j++){
	    		if(j==i) continue;
		    	num2[count++] = nums[j];
		    }
	    	int target2 = target - nums[i];
	    	List<List<Integer>> list = threeSum(num2,target2);
	    	
	    	if(list.size()>0){
	    		for(int k=0;k<list.size();k++){
	    			List<Integer> listInt = list.get(k);
	    			listInt.add(nums[i]);
	    			res.add(listInt);
	    		}
	    	}	
	    }
	    if(res.size()<=0) return res;
	    res2.add(res.get(0));
		for(int k=1;k<res.size();k++){
			boolean flag = true;
			for(int t=0;t<res2.size();t++){
				//System.out.println(res2.size());
				if(compareTo(res.get(k),res2.get(t))) {flag=false;System.out.println(false);}
			}
			if(flag) res2.add(res.get(k));
		}
		return res2;
	}
	public static List<List<Integer>> threeSum(int[] nums,int target) {
		List<List<Integer>> res =new ArrayList<List<Integer>>();
		Arrays.sort(nums);  
		for(int i=0;i<nums.length-2;i++){
		       if(i>0&&nums[i]==nums[i-1])   continue;   // to exclude the duplicated number
		       twoSum(target-nums[i],nums,i+1,nums.length-1,res,target);
		}
		return res;
	}
	private static void twoSum(int target2,int[] nums, int start,int end,List<List<Integer>> res,int target){ 
		   int i=start,j=end;
		   while(i<j){
		       List<Integer> subres=new ArrayList<Integer>();
		       int sum=nums[i]+nums[j];
		       if(sum==target2){
		            subres.add(target-target2);
		            subres.add(nums[i]);
		            subres.add(nums[j]);
		            res.add(subres);
		           do {
		                i++;
		            }while(i < end && nums[i] == nums[i-1]);   // to exclude the duplicated number
		            do {
		                j--;
		            } while(j >= 0 && nums[j] == nums[j+1]); // to exclude the duplicated number
		        }
		        else if(sum<target2) i++;
		        else j--;
		    }
		}
	
	public static boolean compareTo(List<Integer> list1,List<Integer> list2){
		boolean res = false;
		Collections.sort(list1);
		Collections.sort(list2);
		if(list1.size()!=list2.size()) return false;
		for(int i=0;i<list1.size();i++){
			if(!list1.get(i).equals(list2.get(i))) return false;
		}
		
		return true;
		
	}
}
