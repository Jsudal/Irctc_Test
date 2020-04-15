package test.java.concepts;

import java.util.*;

public class MapUsage {

	public static void main (String[] args) {
		Map<String,ArrayList<String>> m1 = new HashMap<String,ArrayList<String>>();
		
		ArrayList<String> l1 = new ArrayList<String>(Arrays.asList("Jayakumar","30","Upper"));
		
		m1.put("Jayakumar", l1);
		
		System.out.println(l1);
		System.out.println(l1.get(2));
		
		System.out.println(m1);
		System.out.println(m1.get("Jayakumar").get(2));
		
		
	}
	
}
