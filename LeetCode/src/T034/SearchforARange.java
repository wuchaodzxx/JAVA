package T034;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;



public class SearchforARange{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("D:\\MyWork\\workspace2\\project002\\src\\result.log"));
		FileWriter step =new FileWriter("D:\\MyWork\\workspace2\\project002\\step.txt", true); 
		FileWriter loss =new FileWriter("D:\\MyWork\\workspace2\\project002\\loss.txt", true); 
		FileWriter acc =new FileWriter("D:\\MyWork\\workspace2\\project002\\acc.txt", true); 
		FileWriter top5 =new FileWriter("D:\\MyWork\\workspace2\\project002\\top5.txt", true); 
		int i=0;
		String s = "";
		while(in.hasNextLine()){
			
			System.out.println(i);
			s = in.nextLine();
			String[] s2 = s.split("loss = ");
			String[] s3 = s.split("accuracy = ");
			String[] s4 = s.split("accuracy_top5 = ");
			if(s2.length==2){
				String[] ss = s2[1].split(" ");
				if(ss.length<=2){
					loss.write(ss[0]+" ");
				}
				
			}
			if(s3.length==2){
				i=i+2;
				acc.write(s3[1]+" ");
				step.write(i*10+" ");
			}
			if(s4.length==2){
				top5.write(s4[1]+" ");
			}
			
			
		}
		step.close();
		acc.close();
		top5.close();
		loss.close();
		in.close();
		////////////////////
		
		
	}

	
}
