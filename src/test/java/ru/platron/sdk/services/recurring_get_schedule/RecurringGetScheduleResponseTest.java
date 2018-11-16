package ru.platron.sdk.services.recurring_get_schedule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import ru.platron.sdk.Utils;
import ru.platron.sdk.services.BaseResponse;
import ru.platron.sdk.services.recurring_get_schedule.RecurringGetScheduleResponse;
import ru.platron.sdk.utils.XmlUtils;

public class RecurringGetScheduleResponseTest { 
	@Test
	public void test() {
		String xml = Utils.readFile("src/test/resources/services/recurring_get_schedule_ok.xml");
		RecurringGetScheduleResponse response = (RecurringGetScheduleResponse) XmlUtils.fromXml(xml, BaseResponse.class, RecurringGetScheduleResponse.class);
		
		String[] datesToVerify = {"2018-08-15 14:00:00", "2018-08-15 14:30:00", "2018-08-15 15:00:00"};
		
		assertEquals("ok", response.status);
		assertEquals("337146", response.recurringProfile);
		assertArrayEquals(datesToVerify, response.dates);
	}
}