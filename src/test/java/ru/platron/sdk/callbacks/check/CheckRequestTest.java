package ru.platron.sdk.callbacks.check;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;

public class CheckRequestTest {

	@Test
	public void test() {
		String xml = Utils.readFile("src/test/resources/callbacks/check_request.xml");
		CheckRequest request = new CheckRequest().fromXml(xml);
		Signer signer = new Signer("secret_key");
		
		assertTrue(request.checkSignature("check", signer));
		assertEquals("654", request.orderId);
		assertEquals("765432", request.paymentId);
		assertEquals("WEBMONEYR", request.paymentSystem);
		assertEquals("100.00", request.amount);
		assertEquals("RUB", request.currency);
		assertEquals("RUB", request.psCurrency);
		assertEquals("100.00", request.psAmount);
		assertEquals("100.00", request.psFullAmount);
	}

}
