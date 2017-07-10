package ru.platron.sdk.services.get_receipt_status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseRequest;

@XmlRootElement(name = "request")
public class GetReceiptStatusRequest extends BaseRequest {
	@XmlElement(name = "pg_receipt_id")
	public String receiptId;
	
	@Override
	public String getScriptName() {
		return "get_receipt_status.php";
	}

	@Override
	public Class<GetReceiptStatusResponse> getResponseClass() {
		return GetReceiptStatusResponse.class;
	}

}
