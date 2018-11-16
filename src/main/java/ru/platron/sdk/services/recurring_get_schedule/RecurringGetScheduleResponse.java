package ru.platron.sdk.services.recurring_get_schedule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class RecurringGetScheduleResponse extends BaseResponse {
	@XmlElement(name = "pg_recurring_profile")
	public String recurringProfile;
	
	@XmlElement(name = "pg_dates")
	public String[] dates;
}
