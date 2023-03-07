package BasicTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class hardassert {
  @Test
  public void f() {
	  
	int a = 15;
	int b = 16;
	
	assertEquals(a, b);
	
	 System.out.println("AFTER Assert");
  }
  
  
}
