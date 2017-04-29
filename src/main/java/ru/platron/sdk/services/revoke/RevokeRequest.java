package ru.platron.sdk.services.revoke;

import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseRequest;

@XmlRootElement(name = "request")
public class RevokeRequest extends BaseRequest {

	@Override
	public String getScriptName() {
		return "revoke.php";
	}

	@Override
	public Class<RevokeResponse> getResponseClass() {
		return RevokeResponse.class;
	}

}
