package ru.platron.sdk.services.get_receipt_status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class GetReceiptStatusResponse extends BaseResponse {
	@XmlElement(name = "pg_receipt_status")
	public String receiptStatus;
	
	@XmlElement(name = "pg_fiscal_receipt_number")
	public String fiscalReceiptNumber;
	
	@XmlElement(name = "pg_shift_number")
	public String shiftNumber;
	
	@XmlElement(name = "pg_receipt_date")
	public String receiptDate;
	
	@XmlElement(name = "pg_fn_number")
	public String fnNumber;
	
	@XmlElement(name = "pg_ecr_registration_number")
	public String ecrRegistrationNumber;
	
	@XmlElement(name = "pg_fiscal_document_number")
	public String fiscalDocumentNumber;
	
	@XmlElement(name = "pg_fiscal_document_attribute")
	public String fiscalDocumentAttribute;
}
