package ru.platron.sdk.services.receipt;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;

public class ReceiptRequestTest {

	@Test
	public void test() {
		ReceiptRequest request = new ReceiptRequest();
		
		request.merchantId = "82";
		request.operationType = "payment";
		request.paymentId = "33221100";
		request.additionalPaymentType = "credit";
		request.additionalPaymentAmount = "100";
		request.customerName = "name";
		request.customerInn = "526317984689";
		
		ReceiptItem item1 = new ReceiptItem();
		item1.label = "test1";
		item1.price = "1.00";
		item1.quantity = "1";
		item1.amount = "1.00";
		item1.vat = "18";
		item1.type = "product";
		item1.paymentType = "full_payment";
		item1.agentType = "commissionaire";
		item1.agentName = "test agent";
		item1.agentPhone = "79050000000";
		item1.agentInn = "123456789012";
		item1.nomenclatureCode = "44h4Dh04h2Fh1Fh96h81h78h4Ah67h58h4Ah35h2Eh54h31h31h32h30h30h30h";
		
		ReceiptItem item2 = new ReceiptItem();
		item2.label = "test2";
		item2.price = "2";
		item2.quantity = "2";
		
		request.items = new ArrayList<ReceiptItem>();
		request.items.add(item1);
		request.items.add(item2);
		
		request.sign(new Signer("secret_key"));
		
		String expected = Utils.readFile("src/test/resources/services/receipt_request.xml").replaceAll("\\r|\\n|\\t", "");

		assertEquals(expected, request.toXml());
	}

}
