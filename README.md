# Platron Java SDK
## Описание
SDK используется для быстрой интеграции к платежному агрегатору Платрон ([https://platron.ru](https://platron.ru))
### Установка
Для использования SDK необходимо скачать jar файл по этой ссылке **тут будет ссылка**.
Jar файл можно собрать из исходников с помощью Maven, для этого необходимо выполнить команду:
```
mvn package
```

### Использование
#### Создание платежа
```java
import ru.platron.sdk.Client;
import ru.platron.sdk.Signer;
import ru.platron.sdk.services.init_payment.InitPaymentRequest;
import ru.platron.sdk.services.init_payment.InitPaymentResponse;

public class InitPaymentExample {
	public static String merchantId = "your_merchant_id";
	public static String secretKey = "your_secret_key";
	
	public static void main(String[] args) {
		InitPaymentRequest request = new InitPaymentRequest();
		request.merchantId = InitPaymentExample.merchantId;
		request.amount = "10";
		request.description = "Test description";
		request.testingMode = "1";
		request.sign(new Signer(InitPaymentExample.secretKey));
		
		Client client = new Client();
		InitPaymentResponse response = (InitPaymentResponse) client.send(request);

		if (response.status.equals("ok")) {
			System.out.println(response.paymentId);
			System.out.println(response.redirectUrl);
		} else if (response.status.equals("error")) {
			System.out.println(response.errorCode);
			System.out.println(response.errorDescription);
		} else {
			System.out.println("System error");
		}
	}

}
```

#### Запрос на result url мерчанта
```java
import ru.platron.sdk.Signer;
import ru.platron.sdk.callbacks.result.ResultRequest;
import ru.platron.sdk.callbacks.result.ResultResponse;

public class ResultExample {
	public static String scriptName = "scriptName";
	public static String secretKey = "your_secret_key";
	
	public static void main(String[] args) {
		//  XML полученный в запросе на result url мерчанта
		String xml = "XML string received from platron";
		
		ResultRequest request = new ResultRequest().fromXml(xml);
		Signer signer = new Signer(ResultExample.secretKey);
		if (request.checkSignature(ResultExample.scriptName, signer)) {
			System.out.println(request.paymentId);
			System.out.println(request.result);
			
			ResultResponse response = new ResultResponse();
			response.status = "ok";
			response.description = "Order is finished";
			response.sign(ResultExample.scriptName, signer);
			System.out.println(response.toXml());
		} else {
			System.out.println("Invalid signature");
		}
	}
}
```
