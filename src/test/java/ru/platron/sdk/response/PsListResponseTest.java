package ru.platron.sdk.response;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.platron.sdk.Utils;
import ru.platron.sdk.response.data_objects.PsListResponsePaymentSystem;
import ru.platron.sdk.response.data_objects.SubPaymentSystem;
import ru.platron.sdk.utils.XmlUtils;

public class PsListResponseTest {

	@Test
	public void test() {
		PsListResponse response = (PsListResponse) XmlUtils.fromXml(Utils.readFile("src/test/resources/responses/ps_list_response.xml"), PsListResponse.class);
		
		assertEquals(4, response.paymentSystems.size());
		
		PsListResponsePaymentSystem paymentSystem = response.paymentSystems.get(1);
		//System.out.println(paymentSystem.subPaymentSystems.get(0).name);
		assertEquals("CASH", paymentSystem.name);
		assertEquals("Наличные: Евросеть, ОСМП, Элекснет", paymentSystem.description);
		assertEquals("offline", paymentSystem.paymentScenario);
		assertEquals("830.00", paymentSystem.amountToPay);
		assertEquals("RUB", paymentSystem.amountToPayCurrency);
		assertEquals("cash", paymentSystem.category);
		
		assertEquals(3, paymentSystem.subPaymentSystems.size());
		SubPaymentSystem subPaymentSystem = paymentSystem.subPaymentSystems.get(0);
		
		assertEquals("ELECSNET", subPaymentSystem.name);
		assertEquals("Elecsnet", subPaymentSystem.description);
	}

}
