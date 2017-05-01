package ru.platron.sdk.services.make_recurring;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;

public class MakeRecurringRequestTest {

	@Test
	public void test() {
		MakeRecurringRequest request = new MakeRecurringRequest();
		
		request.merchantId = "82";
		request.recurringProfile = "12345";
		request.description = "Description example";
		request.amount = "5";
		request.sign(new Signer("secret_key"));
		
		String expected = Utils.readFile("src/test/resources/services/make_recurring_request.xml").replaceAll("\\r|\\n|\\t", "");
		
		assertEquals(expected, request.toXml());
	}

}
