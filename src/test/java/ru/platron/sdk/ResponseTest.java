package ru.platron.sdk;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class ResponseTest {

	@Test
	public void testError() {
		String xmlString = readFile("src/test/resources/init_payment-error.xml");
		
		Response response = Response.fromXml(xmlString);
		
		assertEquals(response.status, "error");
		assertEquals(response.errorCode, "101");
		assertEquals(response.errorDescription, "Empty merchant");
	}
	
	@Test
	public void testOk() {
		String xmlString = readFile("src/test/resources/init_payment-ok.xml");
		
		Response response = Response.fromXml(xmlString);
		
		assertEquals(response.status, "ok");
		assertEquals(response.paymentId, "15826");
		assertEquals(response.redirectUrl, "redirect_url");
		assertEquals(response.redirectUrlType, "need data");
	}
	
	private String readFile(String fileName) {
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return content;
	}

}
