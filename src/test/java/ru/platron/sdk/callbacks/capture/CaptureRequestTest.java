package ru.platron.sdk.callbacks.capture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;

public class CaptureRequestTest {

	@Test
	public void test() {
		String xml = Utils.readFile("src/test/resources/callbacks/capture_request.xml");
		CaptureRequest request = new CaptureRequest().fromXml(xml);
		Signer signer = new Signer("secret_key");
		
		assertTrue(request.checkSignature("capture", signer));
		assertEquals("654", request.orderId);
		assertEquals("765432", request.paymentId);
	}

}
