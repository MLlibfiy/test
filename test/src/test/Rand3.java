package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Rand3 {
	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("D:\\work\\result2");
		long frlength = (new File("D:\\work\\result2")).length()/12;
		BufferedReader br=new BufferedReader(fr);
		FileWriter fw=new FileWriter(new File("D:\\work\\result3"));
		//写入中文字符时会出现乱码
		BufferedWriter  bw=new BufferedWriter(fw);
		String line="";
		int count = 0;
		while ((line=br.readLine())!=null) {
			if(count%3==0){
				bw.write(line+"\t\n");
			}
			count++;
		}
		br.close();
		fr.close();
		bw.close();
		fw.close();
		
		
		
	}
}
