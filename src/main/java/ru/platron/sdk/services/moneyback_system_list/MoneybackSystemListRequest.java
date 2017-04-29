package ru.platron.sdk.services.moneyback_system_list;

import ru.platron.sdk.services.BaseRequest;

public class MoneybackSystemListRequest extends BaseRequest {

	@Override
	public String getScriptName() {
		return "moneyback_system_list.php";
	}

	@Override
	public Class<MoneybackSystemListResponse> getResponseClass() {
		return MoneybackSystemListResponse.class;
	}

}
