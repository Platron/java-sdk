package ru.platron.sdk.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.platron.sdk.Client;
import ru.platron.sdk.Signer;
import ru.platron.sdk.request.InitPaymentRequest;
import ru.platron.sdk.responses.InitPaymentResponse;
import ru.platron.sdk.utils.XmlUtils;

public class CreatePaymentIT {

	@Test
	public void test() {
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

}
