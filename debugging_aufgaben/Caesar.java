import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class Caesar {


	Scanner scan = new Scanner(System.in);
	String message = scan.nextLine();
	int shift = scan.nextInt();
	
	String cipher(String msg, int shift){
	
	    String s = "";
	    int len = msg.length();
	    for(int i = 0; i < len; i++){
	        char c = (char)(msg.charAt(i) + shift);
	        if (c > 'z')
	            s += (char)(msg.charAt(i) - (26-shift));
	        else
	            s += (char)(msg.charAt(i) + shift);
	    }
	    return s;
	}
	
	String decrypt(String msg, int shift) {
		String s = "";
		int len = msg.length();
		assertTrue(!msg.isEmpty());
		for(int i = 0; i < len; i++) {
			char c = (char) (msg.charAt(i) - shift);
			if (c > 'z') {
				s += (char)(msg.charAt(i) - (26-shift));
			}
			else {
				s += (char)(msg.charAt(i) - shift);
			}
		}
		return s;
	}
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		assertFalse(message.isEmpty());
		assertFalse(shift == 0);
		
		assertTrue(decrypt(message, shift) instanceof String);
		assertTrue(!decrypt(message, shift).isEmpty());
		
		System.out.println(cipher(message, shift));
		System.out.println(decrypt(cipher(message, shift), shift));
		
		assertTrue(decrypt(cipher(message, shift), shift).equals(message));
		
	}

}
