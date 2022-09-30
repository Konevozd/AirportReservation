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
		String line = "";
		try(BufferedReader out = new BufferedReader(new FileReader(filename))){
			while((line = out.readLine()) != null) {
				String[] array = line.split(",");
				pom.put(array[0], array[1]);
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pom;
	}
	
	public static boolean exists(String username, String password) {
		boolean exists = false;
		
		try(BufferedReader in = new BufferedReader(new FileReader("users.txt"))){
			String line = "";
			
			while((line = in.readLine()) != null) {
				String[] arr = line.split(",");
				if(arr[0].equals(username)) {
					exists = true;
					break;
				}
			}
			
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return exists;
	}
	
	public static boolean addNewUser(String username, String password) {
		boolean in = false;
		try(PrintWriter out = new PrintWriter(new FileWriter("users.txt", true))){
			if(!exists(username,password)) {
				out.println(username + "," + password);
				in = true;
			}
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return in;
	}
	
}
