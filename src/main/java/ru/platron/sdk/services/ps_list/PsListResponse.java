package ru.platron.sdk.services.ps_list;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.XmlObject;

@XmlRootElement(name = "response")
public class PsListResponse extends XmlObject {
	@XmlElement(name = "pg_status")
	public String status;

	@XmlElementRef
	public List<PaymentSystem> paymentSystems = null;
}
