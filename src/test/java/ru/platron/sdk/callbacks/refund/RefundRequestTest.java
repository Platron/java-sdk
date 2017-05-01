package ru.platron.sdk.callbacks.refund;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;

public class RefundRequestTest {

	@Test
	public void test() {
		String xml = Utils.readFile("src/test/resources/callbacks/refund_request.xml");
		RefundRequest request = new RefundRequest().fromXml(xml);
		Signer signer = new Signer("secret_key");
		
		assertEquals("2614", request.orderId);
		assertEquals("825941", request.paymentId);
		assertEquals("CREDITCARD", request.paymentSystem);
		assertEquals("100.00", request.amount);
		assertEquals("100.00", request.netAmount);
		assertEquals("RUB", request.currency);
		assertEquals("RUB", request.psCurrency);
		assertEquals("100.00", request.psFullAmount);
		assertEquals("2009-09-30 15:32:30", request.refundDate);
		assertTrue(request.checkSignature("refund", signer));
	}

}
