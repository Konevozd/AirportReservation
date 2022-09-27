package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utility {

	public static List<String> findDestinations(String filename) {
		List<String> list = new ArrayList<String>();
		boolean end = false;
		try(BufferedReader out = new BufferedReader(new FileReader(filename))){
			while (!end) {
				String s = out.readLine();
				if(s != null)
					list.add(s);
				else
					end = true;
			}
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}