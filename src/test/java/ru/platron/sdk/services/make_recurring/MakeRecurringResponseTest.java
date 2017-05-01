package ru.platron.sdk.services.make_recurring;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.platron.sdk.Utils;
import ru.platron.sdk.services.BaseResponse;
import ru.platron.sdk.utils.XmlUtils;

public class MakeRecurringResponseTest {

	@Test
	public void test() {
		String xml = Utils.readFile("src/test/resources/services/make_recurring_response-ok.xml");
		MakeRecurringResponse response = (MakeRecurringResponse) XmlUtils.fromXml(xml, BaseResponse.class, MakeRecurringResponse.class);
		
		assertEquals("ok", response.status);
		assertEquals("22241128", response.paymentId);
		assertEquals("1", response.amount);
		assertEquals("RUB", response.currency);
		assertEquals("109642", response.recurringProfileId);
		assertEquals("2029-01-29 00:00:00", response.recurringProfileExpiryDate);
	}

}
