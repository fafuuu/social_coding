import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class worteZaehlen {

	String satz = "No, no, no, I kill the bus driver";
		
	public void count() {

		if(satz.contains(",") ) {
			satz = satz.replace(",", "");
		}
		
		satz = satz.toUpperCase();
		
	    List<String> list = Arrays.asList(satz.split(" "));

	    Set<String> woerter = new HashSet<String> (list);
	    
	    for (String word : woerter) {
	        System.out.println(word + ": " + Collections.frequency(list, word));
	    }
	}
	

	
	@Test
	public void test() {
		//fail("Not yet implemented");
		assertTrue(satz instanceof String);
		assertFalse(satz.isEmpty());
		count();
		System.out.println(satz);
	}

}
