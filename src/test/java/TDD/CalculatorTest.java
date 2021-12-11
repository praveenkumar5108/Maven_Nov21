package TDD;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
	
	Calculator obj = new Calculator();
	@Test
	public void AddTest1() {
		Assert.assertEquals(10, obj.Add(6, 4));
	}
	
	@Test
	public void AddTest2() {
		Assert.assertEquals(11, obj.Add(6, 4));
	}

}
