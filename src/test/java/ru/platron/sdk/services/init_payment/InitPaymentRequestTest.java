package ru.platron.sdk.services.init_payment;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;
import ru.platron.sdk.services.init_payment.InitPaymentRequest;

public class InitPaymentRequestTest {

	@Test
	public void test() {
		InitPaymentRequest request = new InitPaymentRequest();
		request.merchantId = "82";
		request.amount = "12.3";
		request.description = "Test description";
		request.salt = "test_salt";
		
		request.sign(new Signer("secret_key"));
		
		String actual = request.toXml();
		
		String expected = Utils.readFile("src/test/resources/requests/init_payment.xml").replaceAll("(\\t|\\n|\\r)", "");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testParams() {
		InitPaymentRequest request = new InitPaymentRequest();
		request.merchantId = "82";
		request.amount = "12.3";
		request.description = "Test description";
		
		Map<String, String> expected = new TreeMap<String, String>();
		expected.put("pg_merchant_id", "82");
		expected.put("pg_amount", "12.3");
		expected.put("pg_description", "Test description");
		
		assertEquals(expected, request.getParamsMap());
	}
}
