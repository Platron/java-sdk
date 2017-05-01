package ru.platron.sdk.callbacks.result;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;
import ru.platron.sdk.callbacks.check.CheckRequest;

public class ResultRequestTest {

	@Test
	public void test() {
		String xml = Utils.readFile("src/test/resources/callbacks/result_request.xml");
		CheckRequest request = new CheckRequest().fromXml(xml);
		Signer signer = new Signer("secret_key");
		
		assertEquals("654", request.orderId);
		assertEquals("765432", request.paymentId);
		assertEquals("100.00", request.amount);
		assertEquals("RUB", request.currency);
		assertEquals("100.00", request.netAmount);
		assertEquals("105.00", request.psAmount);
		assertEquals("105.00", request.psFullAmount);
		assertEquals("RUB", request.psCurrency);
		assertEquals("INPLATMTS", request.paymentSystem);
		assertEquals("1", request.result);
		assertEquals("2008-12-30 23:59:30", request.paymentDate);
		assertEquals("0", request.canReject);
		assertEquals("79818244116", request.userPhone);
		assertEquals("1", request.needPhoneNotification);
		assertEquals("test@test.ru", request.userContactEmail);
		assertEquals("1", request.needEmailNotification);
		assertTrue(request.checkSignature("result", signer));
	}

}
