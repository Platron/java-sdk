package ru.platron.sdk.services.recurring_set_schedule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import ru.platron.sdk.services.BaseRequest;
import java.util.List;

@XmlRootElement(name = "request")
public class RecurringSetScheduleRequest extends BaseRequest {

	@XmlElement(name = "pg_recurring_profile")
	public String recurringProfile;
	
	@XmlElement(name = "pg_amount")
	public String amount;
	
	@XmlElement(name = "pg_template")
	public Template template;
	
	@XmlElement(name = "pg_dates")
	public List<String> dates;
	
	@Override
	public String getScriptName() {
		return "index.php/api/recurring/set-schedule";
	}

	@Override
	public Class<?> getResponseClass() {
		return RecurringSetScheduleResponse.class;
	}

}
