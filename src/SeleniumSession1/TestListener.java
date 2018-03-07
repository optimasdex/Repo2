package SeleniumSession1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(SeleniumSession1.Listener.class)

public class TestListener
{
	 @Test
	 
	  public void main() {
	 
		  System.out.println("Test: Execution of Main test is carring on");
	 
	  }
}
