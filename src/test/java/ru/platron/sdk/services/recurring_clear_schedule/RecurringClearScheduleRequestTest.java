package ru.platron.sdk.services.recurring_clear_schedule;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;
import ru.platron.sdk.services.recurring_clear_schedule.RecurringClearScheduleRequest;

public class RecurringClearScheduleRequestTest {
	@Test
	public void test() {
		RecurringClearScheduleRequest request = new RecurringClearScheduleRequest();
			
		request.merchantId = "82";
		request.recurringProfile = "337146";
		request.salt = "salt";

		request.sign(new Signer("secret_key"));
		
		String expected = Utils.readFile("src/test/resources/services/recurring_clear_schedule.xml").replaceAll("\\r|\\n|\\t", "");
		
		assertEquals(expected, request.toXml());
	}
}
