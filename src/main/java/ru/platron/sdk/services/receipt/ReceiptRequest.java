package ru.platron.sdk.services.receipt;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseRequest;

@XmlRootElement(name = "request")
public class ReceiptRequest extends BaseRequest {
	@XmlElement(name = "pg_operation_type")
	public String operationType;
	
	@XmlElement(name = "pg_payment_id")
	public String paymentId;
	
	@XmlElement(name = "pg_order_id")
	public String orderId;

	@XmlElement(name = "pg_customer_name")
	public String customerName;

	@XmlElement(name = "pg_customer_inn")
	public String customerInn;
	
	@XmlElement(name = "pg_additional_payment_type")
	public String additionalPaymentType;
	
	@XmlElement(name = "pg_additional_payment_amount")
	public String additionalPaymentAmount;
	
	//@XmlElement(name = "pg_items")
	@XmlElementRef
	public List<ReceiptItem> items = new ArrayList<ReceiptItem>();
	
	public Map<String, String> getParamsMap() {
		Map<String, String> paramsMap = super.getParamsMap();
		
		int i = 1;
		for (ReceiptItem item: items) {
			for (Field field : item.getClass().getFields()) {
				Object value = null;
				try {
					value = field.get(item);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					System.exit(1);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					System.exit(1);
				}
				if (value == null) {
					continue;
				}
				
				XmlElement annotation = field.getAnnotation(XmlElement.class);
				if (annotation == null) {
					continue;
				}
				
				paramsMap.put(String.format("%3d", i) + annotation.name(), value.toString());
			}
			++i;
		}
		
		return paramsMap;
	}
	
	@Override
	public String getScriptName() {
		return "receipt.php";
	}

	@Override
	public Class<ReceiptResponse> getResponseClass() {
		return ReceiptResponse.class;
	}

}
