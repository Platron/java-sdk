package ru.platron.sdk.services.cancel;

import ru.platron.sdk.services.BaseRequest;

public class CancelRequest extends BaseRequest {

	@Override
	public String getScriptName() {
		return "cancel.php";
	}

	@Override
	public Class<CancelResponse> getResponseClass() {
		return CancelResponse.class;
	}

}
