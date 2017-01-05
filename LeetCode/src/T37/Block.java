package T37;

import java.util.ArrayList;
import java.util.List;


public class Block {
	private char[][] block = new char[3][3];
	private List<Character> selectAble = new ArrayList<Character>();
	private int steps = 0;
	public Block(char[][] b){
		this.block = b;
		for(int k=1;k<10;k++){
			boolean flag=true;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(((char) k)==b[i][j]){
						flag=false;
					}
				}
			}
			if(flag) selectAble.add((char) k);
		}
		if(selectAble.size()>0){;	
			steps=1;
			for(int i=1;i<=selectAble.size();i++){
				steps = steps*i;
			}
		}
	}
	public char[][] getNextProbableBlock(){
		return null;
	}
	public boolean hasNextProbableBlock(){
		if(steps>0) return true;
		return false;
	}
	
}
