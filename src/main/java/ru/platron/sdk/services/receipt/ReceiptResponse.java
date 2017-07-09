package ru.platron.sdk.services.receipt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class ReceiptResponse extends BaseResponse {
	@XmlElement(name = "pg_receipt_id")
	public String receiptId;
}
