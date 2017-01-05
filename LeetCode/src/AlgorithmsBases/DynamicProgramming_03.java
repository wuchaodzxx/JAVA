package AlgorithmsBases;

public class DynamicProgramming_03 {

	public static void main(String[] args) {
		//
		int[][] V = new int[][] {{1,2,1,1,2},{2,1,2,2,1},{1,1,2,2,1},{2,2,1,1,1},{1,1,2,1,2},{1,1,2,1,2}};
		//printArray(V);
		System.out.println("result:"+getLongestNonDecreasingSequence(V));
	}
	
	
	public static int getLongestNonDecreasingSequence(int[][] V){
		int rows = V.length;
		int cols = V[0].length;
		int[][] dp = new int[rows][cols];
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(i>0 && j>0){
					dp[i][j]=V[i][j]+(dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1]);
				}
				if(i>0&&j<=0){
					dp[i][j]=V[i][j]+dp[i-1][j];
				}
				if(i<=0&&j>0){
					dp[i][j]=V[i][j]+dp[i][j-1];
				}
				if(i<=0&&j<=0){
					dp[i][j]=V[i][j];
				}
				
			}
		}
		int max=0;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(max<=dp[i][j]){
					max=dp[i][j];
				}
			}
		}
		return max;
	}
	public static void printArray(int[] V){
		System.out.print("printArray:");
		for(int i=0;i<V.length;i++){
			System.out.print(V[i]+" ");
		}
		System.out.println("");
	}
	public static void printArray(int[][] V){
		System.out.println("printArray:");
		int rows = V.length;
		int cols = V[0].length;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				System.out.print(V[i][j]+" ");
			}
			System.out.println("");
			
		}
		System.out.println("");
	}
}
