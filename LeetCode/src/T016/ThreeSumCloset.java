package T016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumCloset {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSum(new int[]{1,1,0},3));
	}
	public static int threeSum(int[] nums,int target) {
		   Arrays.sort(nums);  
		   int res = Integer.MAX_VALUE;
		   int d = Integer.MAX_VALUE;
		   for(int i=0;i<nums.length-2;i++){
			   int j = nums.length-1;
			   int k = i+1;
			   while(k<j){
				   int a = target - nums[i];
				   if(nums[k]+nums[j]==a) return nums[k]+nums[j]+nums[i];
				   if(nums[k]+nums[j]>a){
					   //System.out.println(">a");
					   if( d>Math.abs(target-nums[k]-nums[j]-nums[i])){
						   d=Math.abs(target-nums[k]-nums[j]-nums[i]);
						   res = nums[k]+nums[j]+nums[i];
					   }
					   
					   j--;
				   }
				   if(nums[k]+nums[j]<a){
					   //System.out.println("<a");
					   if( d>Math.abs(target-nums[k]-nums[j]-nums[i])){
						   d=Math.abs(target-nums[k]-nums[j]-nums[i]);
						   res = nums[k]+nums[j]+nums[i];
					   }
					   k++;
				   }
			   }
		   }
		   return res;
		}
	
}
