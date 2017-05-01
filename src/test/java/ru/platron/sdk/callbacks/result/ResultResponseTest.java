package ru.platron.sdk.callbacks.result;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;
import ru.platron.sdk.callbacks.BaseResponse;

public class ResultResponseTest extends BaseResponse {

	@Test
	public void test() {
		ResultResponse response = new ResultResponse();
		response.status = "ok";
		response.description = "Товар передан покупателю";
		response.salt = "salt";
		response.sign("check", new Signer("secret_key"));
		
		String expected = Utils.readFile("src/test/resources/callbacks/result_response-ok.xml").replaceAll("\\r|\\n|\\t", "");
		
		assertEquals(expected, response.toXml());
	}

}
