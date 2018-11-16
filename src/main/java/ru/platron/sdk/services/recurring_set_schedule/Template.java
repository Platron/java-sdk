package ru.platron.sdk.services.recurring_set_schedule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pg_template")
public class Template {
	
	@XmlElement(name = "pg_start_date")
	public String startDate;
	
	@XmlElement(name = "pg_interval")
	public String interval;
	
	@XmlElement(name = "pg_period")
	public String period;
	
	@XmlElement(name = "pg_max_periods")
	public String maxPeriods;
}
