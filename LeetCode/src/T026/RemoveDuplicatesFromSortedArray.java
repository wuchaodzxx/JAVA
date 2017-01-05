package T026;
import java.util.*;
public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		
		int[] nums = new int[]{1,1,2};
		System.out.println(removeDuplicates(nums));
	}
	//以下代码为去除数组中的重复元素，但我分配了额外的内存，所以算法不太好，可以试试在原有的数组上操作。
	public static int removeDuplicates(int[] nums) {
		if(nums == null) return 0;
        if(nums.length<=1) return nums.length ;
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
        	if(nums[i]==list.get(list.size()-1)){
        		continue;
        	}else{
        		list.add(nums[i]);
        	}
        }
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
		return list.size();
    }
	
	public static void printArray(int[] nums){
		if(nums.length<=0) return;
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+",");
		}
		System.out.println("");
	}
}
