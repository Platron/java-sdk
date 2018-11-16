package ru.platron.sdk.services.recurring_clear_schedule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class RecurringClearScheduleResponse extends BaseResponse {
	@XmlElement(name = "pg_recurring_profile")
	public String recurringProfile;
}
