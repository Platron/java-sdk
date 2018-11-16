package ru.platron.sdk.services.recurring_clear_schedule;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.platron.sdk.Utils;
import ru.platron.sdk.services.BaseResponse;
import ru.platron.sdk.utils.XmlUtils;
import ru.platron.sdk.services.recurring_clear_schedule.RecurringClearScheduleResponse;

public class RecurringClearScheduleResponseTest { 
	@Test
	public void test() {
		String xml = Utils.readFile("src/test/resources/services/recurring_clear_schedule_ok.xml");
		RecurringClearScheduleResponse response = (RecurringClearScheduleResponse) XmlUtils.fromXml(xml, BaseResponse.class, RecurringClearScheduleResponse.class);
		
		assertEquals("ok", response.status);
		assertEquals("337146", response.recurringProfile);
	}
}
