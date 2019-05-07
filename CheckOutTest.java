import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckOutTest {
CheckOut c = new CheckOut();
	
	@Test
	void testTotal() {
		CheckOut c = new CheckOut();
		c.scan("TSHIRT").scan("TSHIRT").scan("MUG").scan("TSHIRT").scan("TSHIRT");
		assertEquals(c.total() ,(85.5));
	}
	
}
