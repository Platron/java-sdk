package ru.platron.sdk;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;

import ru.platron.sdk.response.InitPaymentResponse;
import ru.platron.sdk.response.PaymentSystem;

public class InitPaymentResponseTest {

	@Test
	public void testError() {
		String xmlString = readFile("src/test/resources/init_payment-error.xml");
		
		InitPaymentResponse response = InitPaymentResponse.fromXml(xmlString);
		
		assertEquals(response.status, "error");
		assertEquals(response.errorCode, "101");
		assertEquals(response.errorDescription, "Empty merchant");
	}
	
	@Test
	public void testOk() {
		String xmlString = readFile("src/test/resources/init_payment-ok.xml");
		
		InitPaymentResponse response = InitPaymentResponse.fromXml(xmlString);
		
		assertEquals(response.status, "ok");
		assertEquals(response.paymentId, "15826");
		assertEquals(response.redirectUrl, "redirect_url");
		assertEquals(response.redirectUrlType, "need data");
	}
	
	@Test
	public void testOk2() {
		String xmlString = readFile("src/test/resources/init_payment-ok-with-additional-data.xml");
		
		InitPaymentResponse response = InitPaymentResponse.fromXml(xmlString);
		
		assertEquals("ok", response.status);
		assertEquals("15826", response.paymentId);
		assertEquals("redirect_url", response.redirectUrl);
		assertEquals("need data", response.redirectUrlType);
		assertEquals("NAME1,NAME2", response.acceptedPaymentSystems);
		
		assertFalse(response.psAdditionalData.isEmpty());
		assertEquals(1, response.psAdditionalData.size());
		
		PaymentSystem ps = response.psAdditionalData.get(0);
		assertEquals("NAME1", ps.name);
		
		assertFalse(ps.psData.isEmpty());
		assertEquals(2, ps.psData.size());
		
		assertEquals("value1", ps.psData.get("key1"));
		assertEquals("value2", ps.psData.get("key2"));
	}
	
	private String readFile(String fileName) {
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return content;
	}

}
