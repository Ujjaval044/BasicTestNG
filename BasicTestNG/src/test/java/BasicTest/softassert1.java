package BasicTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softassert1 {
  @Test
  public void f() {
	  int a = 12;
	  int b = 13;
	  
	  SoftAssert s = new SoftAssert();
	  s.assertEquals(a, b);
	  
	  System.out.println("AFTER SoftAssert");
	  
	  s.assertAll();
  }
}
