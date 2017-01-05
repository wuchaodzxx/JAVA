package T027;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,2,1,2};
		System.out.println(removeElement(nums,2));
	}
	public static int removeElement(int[] nums, int val) {
        if(nums==null) return 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==val){
				if(i<nums.length-1){
					for(int j=i+1;j<nums.length ;j++){
						if(nums[j]!=val){
							int s = nums[j];
							nums[j]=nums[i];
							nums[i]=s;
						}
					}
				}
			}
		}
		int res=0;
		for(int i=0;i<nums.length ;i++){
			if(nums[i]!=val) res++;
			else break;
		}
		return res;
    }
	
	public static void printArray(int[] nums){
		if(nums.length<=0) return;
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+",");
		}
		System.out.println("");
	}
}
