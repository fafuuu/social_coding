import static org.junit.Assert.*;

import org.junit.Test;

public class Acronyms {

	String test = "portable network graphics";
	String acronym = "";
	public void createAcronym(String s) {
		
		s = s.toUpperCase();
		String parts[] = s.split(" ");
		assertTrue(parts != null);
		assertTrue(parts instanceof String[]);
		for(int i = 0; i < parts.length; i++) {
			if(!parts[i].isEmpty()) {
				//System.out.println(parts[i].charAt(0));
				acronym += parts[i].substring(0, 1);
				
			}
		}
		
		System.out.println(acronym);
	}
	
	
	@Test
	public void test() {
		
		assertTrue(test instanceof String);
		assertFalse(test.isEmpty());
		createAcronym(test);
	}

}
