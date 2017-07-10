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
		
		ReceiptItem item1 = new ReceiptItem();
		item1.label = "test1";
		item1.price = "1.00";
		item1.quantity = "1";
		item1.amount = "1.00";
		item1.vat = "18";
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
