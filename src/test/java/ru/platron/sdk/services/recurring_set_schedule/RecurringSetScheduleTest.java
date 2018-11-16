package ru.platron.sdk.services.recurring_set_schedule;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;
import ru.platron.sdk.services.recurring_set_schedule.RecurringSetScheduleRequest;
import ru.platron.sdk.services.recurring_set_schedule.Template;
import java.util.ArrayList;

public class RecurringSetScheduleTest {
	@Test
	public void testTemplate() {
		RecurringSetScheduleRequest requestTemplate = new RecurringSetScheduleRequest();
			
		requestTemplate.merchantId = "82";
		requestTemplate.amount = "12.41";
		requestTemplate.recurringProfile = "337146";
		requestTemplate.salt = "salt";
		
		Template template = new Template();
		template.startDate = "2018-08-15 15:30:00";
		template.interval = "week";
		template.period = "2";
		template.maxPeriods = "5";
		
		requestTemplate.template = template;
		requestTemplate.sign(new Signer("secret_key"));
		
		String expected = Utils.readFile("src/test/resources/services/recurring_set_schedule_template.xml").replaceAll("\\r|\\n|\\t", "");
		
		assertEquals(expected, requestTemplate.toXml());
	}
	
	@Test
	public void testDates() {
		RecurringSetScheduleRequest requestDates = new RecurringSetScheduleRequest();
		
		requestDates.merchantId = "82";
		requestDates.amount = "12.41";
		requestDates.recurringProfile = "337146";
		requestDates.salt = "salt";
		
		requestDates.dates = new ArrayList<String>();
		requestDates.dates.add("2018-08-15 14:00:00");
		requestDates.dates.add("2018-08-15 14:30:00");
		requestDates.dates.add("2018-08-15 15:00:00");
		
		requestDates.sign(new Signer("secret_key"));
		
		String expected = Utils.readFile("src/test/resources/services/recurring_set_schedule_dates.xml").replaceAll("\\r|\\n|\\t", "");
		
		assertEquals(expected, requestDates.toXml());
	}
}
