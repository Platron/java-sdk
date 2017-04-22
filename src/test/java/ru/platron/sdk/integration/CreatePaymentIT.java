package ru.platron.sdk.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ru.platron.sdk.Client;
import ru.platron.sdk.Signer;
import ru.platron.sdk.request.InitPaymentRequest;
import ru.platron.sdk.response.InitPaymentResponse;

public class CreatePaymentIT {
	@Test
	public void createPaymentWithMinimumRequiredData() {
		InitPaymentRequest request = new InitPaymentRequest();
		request.merchantId = MerchantSettings.merchantId;
		request.amount = "3.24";
		request.description = "Test payment";
		
		Signer signer = new Signer(MerchantSettings.secretKey);
		request.sign(signer);
		
		Client client = new Client();
		InitPaymentResponse response = (InitPaymentResponse) client.send(request);
		
		//System.out.println(XmlUtils.toXml(response));
		assertEquals("ok", response.status);
		assertNotNull(response.paymentId);
		assertNotNull(response.redirectUrl);
		assertEquals("need data", response.redirectUrlType);
	}
	
	@Test
	public void createPaymentWithPaymentSystem() {
		InitPaymentRequest request = new InitPaymentRequest();
		request.merchantId = MerchantSettings.merchantId;
		request.amount = "3.24";
		request.description = "Test payment";
		request.userPhone = "79999999999";
		request.testingMode = "1";
		request.paymentSystem = "TEST";
		
		Signer signer = new Signer(MerchantSettings.secretKey);
		request.sign(signer);
		
		Client client = new Client();
		InitPaymentResponse response = (InitPaymentResponse) client.send(request);
			
		assertEquals("ok", response.status);
		assertNotNull(response.paymentId);
		assertNotNull(response.redirectUrl);
		assertEquals("payment system", response.redirectUrlType);
	}
	
	@Test
	public void createPaymentWithCardData() {
		InitPaymentRequest request = new InitPaymentRequest();
		request.merchantId = MerchantSettings.merchantId;
		request.amount = "3.24";
		request.description = "Test payment";
		request.userPhone = "79999999999";
		request.testingMode = "1";
		request.paymentSystem = "TESTCARD";
		
		request.cardNumber = "5285000000000005";
		request.userCardholder = "CARD HOLDER";
		request.expYear = "2019";
		request.expMonth = "01";
		request.cvv2 = "123";
		request.userIp = "109.252.75.103";
		
		Signer signer = new Signer(MerchantSettings.secretKey);
		request.sign(signer);
		
		Client client = new Client();
		InitPaymentResponse response = (InitPaymentResponse) client.send(request);
			
		assertEquals("ok", response.status);
		assertNotNull(response.paymentId);
		assertNotNull(response.redirectUrl);
		assertEquals("payment system", response.redirectUrlType);
	}
}
