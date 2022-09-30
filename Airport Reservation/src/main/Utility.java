package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	public static HashMap<String, String> loadHashMap(String filename) {
		HashMap<String, String> pom = new HashMap<>();
		boolean end = false;
		try(BufferedReader out = new BufferedReader(new FileReader(filename))){
			while(!end) {
				String username = out.readLine();
				if(username != null) {
					String password = out.readLine();
					pom.put(username, password);
				} else
					end = true;
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pom;
	}
	
	public static void addNewUser(String username, String password) {
		try(PrintWriter out = new PrintWriter(new FileWriter("users.txt", true))){
			out.println(username);
			out.println(password);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
