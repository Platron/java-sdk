package ru.platron.sdk.services.recurring_set_schedule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class RecurringSetScheduleResponse extends BaseResponse {
	@XmlElement(name = "pg_recurring_profile")
	public String recurringProfile;
}
