package AlgorithmsBases;

public class DynamicProgramming_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//有三种面值的硬币
		int[] V = new int[] {1,3,5};
		System.out.println("result:"+getBinNum(4,V));
	}
	
	//value表示总值，V表示硬币面值，返回最少需要的硬币数目
	public static int getBinNum(int value,int[] V){
		int[] Min = new int[value+1];
		Min[0]=0;
		//除了Min[0]以外，其余先设为最大值
		for(int i=1;i<Min.length;i++){
			Min[i]=Integer.MAX_VALUE;
		}
		
		//以下为核心代码
		//Min[i]表示凑足i需要的硬币数
		for(int i=0;i<=value;i++){
			//V表示现有的各个面值的硬币
			for(int j=0;j<V.length;j++){
				System.out.println(V[j]+":"+i);
				
				if(V[j]<=i && Min[i-V[j]]+1<Min[i]){
					Min[i]=Min[i-V[j]]+1;
				}
				
			}
		}
		return Min[value];
	}
}
