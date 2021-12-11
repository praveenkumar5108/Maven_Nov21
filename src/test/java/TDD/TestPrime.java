package TDD;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPrime {
	
	PrimeCheck obj = new PrimeCheck();
	@Test
	public void PrimecheckTest1() {
		Assert.assertEquals(obj.isPrime(23), true);
	}
	
	@Test
	public void PrimecheckTest2() {
		Assert.assertEquals(obj.isPrime(24), true);
	}

}
