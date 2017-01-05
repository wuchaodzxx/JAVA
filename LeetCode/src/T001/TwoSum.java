package T001;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target=9;
		int[] nums = {2,5,3,6};
		System.out.println(twoSum(nums,target)[0]+","+twoSum(nums,target)[1]);
	}
	public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
        	for(int j=0;j<nums.length;j++){
        		if((nums[i]+nums[j])==target){
        			int[] result = {i,j};
        			return result;
        		}
        	}
        }
		
		return null;
    }
	

}
