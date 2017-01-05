package T015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	static List<List<Integer>> res =new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		
		System.out.println(threeSum(new int[]{-8,-4,-1,-1,0,0,0,0,0,1,2,5,7}));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		   Arrays.sort(nums);  
		   for(int i=0;i<nums.length-2;i++){
		       if(i>0&&nums[i]==nums[i-1])   continue;   // to exclude the duplicated number
		       twoSum(0-nums[i],nums,i+1,nums.length-1);
		   }
		   return res;
		}
	private static void twoSum(int target,int[] nums, int start,int end){ 
		   int i=start,j=end;
		   while(i<j){
		       List<Integer> subres=new ArrayList<Integer>();
		       int sum=nums[i]+nums[j];
		       if(sum==target){
		            subres.add(0-target);
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
		        else if(sum<target) i++;
		        else j--;
		    }
		}
		
	public static void printList(List<Integer> list){
		System.out.print("list: ");
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
		System.out.println("");
	}
}
