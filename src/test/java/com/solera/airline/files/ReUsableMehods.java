package com.solera.airline.files;

import io.restassured.path.json.JsonPath;

public class ReUsableMehods {

	public static JsonPath rawToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}

}
