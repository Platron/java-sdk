package ru.platron.sdk.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.platron.sdk.Client;
import ru.platron.sdk.Signer;
import ru.platron.sdk.request.InitPaymentRequest;
import ru.platron.sdk.responses.InitPaymentResponse;

public class InitPaymentTest {

	@Test
	public void test() {
		InitPaymentRequest request = new InitPaymentRequest();
		request.merchantId = 82;
		request.amount = 12.3;
		request.description = "Test description";
		request.testingMode = "1";
		request.salt = "test_salt";
		request.sign(new Signer("secret_key"));
		
		Client client = new Client();
		InitPaymentResponse response = (InitPaymentResponse) client.send(request);
		
		System.out.println(response.errorCode);
		System.out.println(response.errorDescription);
		System.out.println(response.paymentId);
	}

}
