package T004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] a = {1,5,7,9,13};
		int[] b = {2,3,4};
		System.out.println(findMedianSortedArrays(a,b));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//当有一个数组为空时
		if(nums1.length<1){
			 float br = (float) nums2.length/2;
			 if((float)br%1 == 0){
				 return (double) (nums2[(int) (br-1)]+nums2[(int) (br)])/2;
			 }else{
				 return (double) nums2[(int) (br)];
			 }
		}
		if(nums2.length<1){
			float ar = (float) nums1.length/2;
			 if((float)ar%1 == 0){
				 return (double) (nums1[(int) (ar-1)]+nums1[(int) (ar)])/2;
			 }else{
				 return (double) nums1[(int) (ar)];
			 }
		}
		
       ArrayList<Integer> list = new ArrayList<Integer>();
       for(int i=0;i<nums1.length;i++){
    	   list.add(nums1[i]);
       }
       for(int i=0;i<nums2.length;i++){
    	   list.add(nums2[i]);
       }
       Collections.sort(list,new Comparator<Integer>(){  
           public int compare(Integer arg0, Integer arg1) {  

        	   if(arg0<arg1) return -1;
        	   if(arg0>arg1) return 1;
        	   return 0;
           }  
       });
       
       while(list.size()>2){
    	   
    	   list.remove(0);
    	   list.remove(list.size()-1);
       }
       if(list.size()==1) return (double) list.get(0);
       if(list.size()==2) return (double) (list.get(0)+list.get(1))/2;
		return 0;
    }
}
