package ru.platron.sdk.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import ru.platron.sdk.Client;
import ru.platron.sdk.Signer;
import ru.platron.sdk.services.get_status.GetStatusRequest;
import ru.platron.sdk.services.get_status.GetStatusResponse;
import ru.platron.sdk.services.init_payment.InitPaymentRequest;
import ru.platron.sdk.services.init_payment.InitPaymentResponse;

public class CreatePaymentIT {
	private Signer signer;
	private Client client;
	
	@Before
	public void setUp() {
		signer = new Signer(MerchantSettings.secretKey);
		client = new Client();
	}
	
	@Test
	public void createPayment() {
		InitPaymentRequest initPaymentRequest = new InitPaymentRequest();
		initPaymentRequest.merchantId = MerchantSettings.merchantId;
		initPaymentRequest.amount = "3.24";
		initPaymentRequest.description = "Test payment";
		initPaymentRequest.userPhone = "79999999999";
		initPaymentRequest.testingMode = "1";
		initPaymentRequest.paymentSystem = "TESTCARD";
		
		initPaymentRequest.cardNumber = "5285000000000005";
		initPaymentRequest.userCardholder = "CARD HOLDER";
		initPaymentRequest.expYear = "2019";
		initPaymentRequest.expMonth = "01";
		initPaymentRequest.cvv2 = "123";
		initPaymentRequest.userIp = "109.252.75.103";
		
		initPaymentRequest.sign(signer);
		
		InitPaymentResponse initPaymentResponse = (InitPaymentResponse) client.send(initPaymentRequest);
		
		assertEquals("ok", initPaymentResponse.status);
		assertNotNull(initPaymentResponse.paymentId);
		assertNotNull(initPaymentResponse.redirectUrl);
		assertEquals("payment system", initPaymentResponse.redirectUrlType);
		
		
		GetStatusRequest getStatusRequest = new GetStatusRequest();
		getStatusRequest.merchantId = MerchantSettings.merchantId;
		getStatusRequest.paymentId = initPaymentResponse.paymentId;
		
		getStatusRequest.sign(signer);
		
		GetStatusResponse getStatusResponse = (GetStatusResponse) client.send(getStatusRequest);
		
		assertEquals("ok", getStatusResponse.status);
		assertEquals("partial", getStatusResponse.transactionStatus);
		assertEquals("TESTCARD", getStatusResponse.paymentSystem);
	}
}
