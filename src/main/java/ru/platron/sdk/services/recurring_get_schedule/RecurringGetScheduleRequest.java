package ru.platron.sdk.services.recurring_get_schedule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseRequest;
import ru.platron.sdk.services.recurring_clear_schedule.RecurringClearScheduleResponse;

@XmlRootElement(name = "request")
public class RecurringGetScheduleRequest  extends BaseRequest{

	@XmlElement(name = "pg_recurring_profile")
	public String recurringProfile;
	
	@Override
	public String getScriptName() {
		return "index.php/api/recurring/clear-schedule";
	}

	@Override
	public Class<?> getResponseClass() {
		return RecurringClearScheduleResponse.class;
	}

}