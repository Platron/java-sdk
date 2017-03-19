package ru.platron.sdk;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

public class SignatureTest {
	private Signature signature;
	
	@Before
	public void setUp() {
		signature = new Signature("secret_key");
	}
	
	@Test
	public void md5() {
		String actual = signature.md5("тест");
		String expected = "ebb5e89e8a94e9dd22abf5d915d112b2";
		assertEquals(expected, actual);
	}
	
	@Test
	public void make() {
		TreeMap<String, String> params = new TreeMap<String, String>();
		params.put("testKey", "test value");
		params.put("aKey", "value");
		
		String actual = signature.make("index.php", params );
		String expected = "7d3568b4ba955e2d03b96e99f14c9c9a";
		
		assertEquals(expected, actual);
	}
}
