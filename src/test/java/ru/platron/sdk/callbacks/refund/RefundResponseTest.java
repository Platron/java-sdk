package ru.platron.sdk.callbacks.refund;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;

public class RefundResponseTest {

	@Test
	public void test() {
		RefundResponse response = new RefundResponse();
		response.status = "error";
		response.errorDescription = "System error";
		response.salt = "salt";
		response.sign("refund", new Signer("secret_key"));
		
		String expected = Utils.readFile("src/test/resources/callbacks/refund_response-error.xml").replaceAll("\\r|\\n|\\t", "");
		
		assertEquals(expected, response.toXml());
	}

}
