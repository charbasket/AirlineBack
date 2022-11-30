package com.solera.airline.flight;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.solera.airline.files.Payload;
import com.solera.airline.files.ReUsableMehods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class test {

	@Test
	public void getFlight() {
		RestAssured.baseURI = "http://localhost:8080/";

		String response = given().log().all().queryParam("origin", "barcelona").when().get("flights/desOrg").then()
				.assertThat().statusCode(200).body("[0].airline", equalTo("Iberia")).extract().response().asString();

		System.err.println(response);

//		JsonPath js = new JsonPath(response);
		JsonPath js = ReUsableMehods.rawToJson(response);

		System.err.println(js.getString("[0].airline"));
		System.err.println(js.getString("size()"));

	}

	public static void main(String[] args) {
		JsonPath jsonPath = new JsonPath(Payload.array());
		System.err.println(jsonPath.getInt("courses.size()"));
	}
}
