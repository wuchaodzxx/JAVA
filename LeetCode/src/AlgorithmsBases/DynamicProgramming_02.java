package AlgorithmsBases;

public class DynamicProgramming_02 {

	public static void main(String[] args) {
		//
		int[] V = new int[] {5,3,4,8,6,7};
		System.out.println("result:"+getLongestNonDecreasingSequence(V));
	}
	
	//以下代码实现输入一个数组，输出最长非降子序列的长度
	//比如{5,3,4,8,6,7}的非降最长子序列为{3,4,6,7}，长度为4
	public static int getLongestNonDecreasingSequence(int[] V){
		int[] MaxLen = new int[V.length];
		//MaxLen最小值为1
		for(int i=0;i<MaxLen.length;i++){
			MaxLen[i]=0;
		}
		
		for(int i=0;i<V.length;i++){
			//以下代码求解d[i]=max{1,d[j]+1},其中j<=i,V[j]<=V[i]
			int maxb=1;
			for(int j=0;j<=i;j++){
				if(V[j]<=V[i] && MaxLen[j]+1>=maxb) maxb=MaxLen[j]+1;
			}
			MaxLen[i]=maxb;
		}
		
		int max=0;
		for(int k=0;k<MaxLen.length;k++){
			if(max<MaxLen[k]) max=MaxLen[k];
		}
		printArray(MaxLen);
		return max;
	}
	public static void printArray(int[] maxLen){
		System.out.print("printArray:");
		for(int i=0;i<maxLen.length;i++){
			System.out.print(maxLen[i]+" ");
		}
		System.out.println("");
	}
}
