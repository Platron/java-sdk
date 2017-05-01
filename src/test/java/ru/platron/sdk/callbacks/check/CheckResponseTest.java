package ru.platron.sdk.callbacks.check;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.platron.sdk.Signer;
import ru.platron.sdk.Utils;

public class CheckResponseTest {
	@Test
	public void test() {
		CheckResponse response = new CheckResponse();
		response.status = "ok";
		response.timeout = "300";
		response.salt = "salt";
		response.sign("check", new Signer("secret_key"));
		
		String expected = Utils.readFile("src/test/resources/callbacks/check_response-ok.xml").replaceAll("\\r|\\n|\\t", "");
		
		assertEquals(expected, response.toXml());
	}
}
