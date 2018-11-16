package ru.platron.sdk.services.recurring_set_schedule;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.platron.sdk.Utils;
import ru.platron.sdk.services.BaseResponse;
import ru.platron.sdk.utils.XmlUtils;
import ru.platron.sdk.services.recurring_set_schedule.RecurringSetScheduleResponse;

public class RecurringSetScheduleResponseTest {
	@Test
	public void test() {
		String xml = Utils.readFile("src/test/resources/services/recurring_set_schedule_ok.xml");
		RecurringSetScheduleResponse response = (RecurringSetScheduleResponse) XmlUtils.fromXml(xml, BaseResponse.class, RecurringSetScheduleResponse.class);
		
		assertEquals("ok", response.status);
		assertEquals("337146", response.recurringProfile);
	}
}
