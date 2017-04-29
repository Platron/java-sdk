package ru.platron.sdk.services.moneyback_system_list;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class MoneybackSystemListResponse extends BaseResponse {
	@XmlElement(name = "pg_contract_list")
	public List<?> contractList;
}
