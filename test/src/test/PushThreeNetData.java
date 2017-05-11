package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class PushThreeNetData {
	public static void main(String[] args) throws Exception {
		FileReader dxdata=new FileReader("D:\\work\\170510\\dianxing");
		BufferedReader dxdataBr=new BufferedReader(dxdata);
		
		FileReader Ratio=new FileReader("D:\\work\\170510\\ct_ratio.properties");
		BufferedReader RatioBr=new BufferedReader(Ratio);
		
		FileWriter fw=new FileWriter(new File("D:\\work\\170510\\sanwang"));
		BufferedWriter  bw=new BufferedWriter(fw);
		
		HashMap<String, Double> RatioMap = new HashMap<>();
		
		String line="";
		while ((line=RatioBr.readLine())!=null) {
			if(line!=null&&line.trim().length()!=0){
				String [] strs = line.split("=");
				RatioMap.put(strs[0], Double.parseDouble(strs[1]));
			}
			
		}
		
		String line2="";
		while ((line2=dxdataBr.readLine())!=null) {
			if(line2!=null&&line2.trim().length()!=0){
				String [] strs = line2.split("\t");
				System.out.println(strs[1]+"\t"+ Integer.parseInt(strs[0])/(RatioMap.containsKey(strs[1])?RatioMap.get(strs[1]):1));
				bw.write(strs[1]+"\t"+ Integer.parseInt(strs[0])/(RatioMap.containsKey(strs[1])?RatioMap.get(strs[1]):1)+"\n");
				
			}
			
		}
		dxdata.close();
		dxdataBr.close();
		Ratio.close();
		dxdataBr.close();
		bw.close();
		fw.close();
		
		
	}
}
