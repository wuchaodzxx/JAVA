package T011;

import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater {
	//由于是装水的容器，则容器的容量由最短的那条线确定
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,5,2,4,7};
		System.out.println("result:"+maxArea(a));
	}
	
	public static int maxArea(int[] height) {
	    int max = 0, i = 0, j = height.length - 1;
	    while(i < j)
	    	//System.out.println("i:"+i+", j:"+j);
	        max = Math.max(max, (j - i) * (height[i] < height[j] ? height[i++] : height[j--]));
	    return max;
	}

	public static int getArea(int height1,int i,int height2,int j){
		int L = height1>height2 ? height2:height1;
		return L*Math.abs(i-j);
	}

}
