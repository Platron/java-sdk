package ru.platron.sdk.callbacks.capture;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;

public class CaprureResponseTest {

	@Test
	public void test() {
		CaptureResponse response = new CaptureResponse();
		response.status = "error";
		response.errorDescription = "System error";
		response.salt = "salt";
		response.sign("capture", new Signer("secret_key"));
		
		String expected = Utils.readFile("src/test/resources/callbacks/capture_response-error.xml").replaceAll("\\r|\\n|\\t", "");
		
		assertEquals(expected, response.toXml());
	}

}
