package ru.platron.sdk.response;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckResponseTest {

	@Test
	public void test() {
		CheckResponse response = new CheckResponse();
		response.status = "rejected";
		response.description = "description";
		response.errorDescription = "error description";
	}

}
