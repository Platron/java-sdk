package ru.platron.sdk.request;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.platron.sdk.Signer;

public class CheckRequestTest {

	@Test
	public void test() {
		CheckRequest request = new CheckRequest();
		request.salt = "8765";
		request.orderId = "654";
		request.paymentId = "765432";
		request.paymentSystem = "WEBMONEYR";
		request.amount = "100.00";
		request.currency = "RUB";
		request.psCurrency = "RUB";
		request.psAmount = "100.00";
		request.psFullAmount = "100.00";
		request.signature = "6445d65d2859be4a188f4fdb3cfa1561";
		
		Signer signer = new Signer("secret");
		boolean actual = signer.check("check.php", request);
		
		assertTrue(actual);
	}

}
