package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> cand = new TreeMap<>();
		
		System.out.println("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				if(cand.containsKey(name)) {
					int vts = cand.get(name);
					cand.put(name, votes + vts);
				}else {
					cand.put(name, votes);
				}
				
				line = br.readLine();
			}
			
			System.out.println("Candidates:");
			for(String key : cand.keySet()) {
				System.out.println(key+": "+cand.get(key));
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
