package ru.platron.sdk.webhook;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class CheckHookTest {

	@Test
	public void test() {
		CheckHook hook = new CheckHook();
		hook.salt = "salt";
		hook.signature = "signature";
		hook.paymentId = "123";
		
		Map<String, String> expected = new TreeMap<String, String>();
		expected.put("pg_salt", "salt");
		expected.put("pg_payment_id", "123");
		
		assertEquals(expected, hook.getParamsMap());
	}

}
