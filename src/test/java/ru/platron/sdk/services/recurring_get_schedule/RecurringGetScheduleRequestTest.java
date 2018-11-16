package ru.platron.sdk.services.recurring_get_schedule;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;
import ru.platron.sdk.services.recurring_get_schedule.RecurringGetScheduleRequest;

public class RecurringGetScheduleRequestTest {
	@Test
	public void test() {
		RecurringGetScheduleRequest request = new RecurringGetScheduleRequest();
			
		request.merchantId = "82";
		request.recurringProfile = "337146";
		request.salt = "salt";

		request.sign(new Signer("secret_key"));
		
		String expected = Utils.readFile("src/test/resources/services/recurring_get_schedule.xml").replaceAll("\\r|\\n|\\t", "");
		
		assertEquals(expected, request.toXml());
	}
}
