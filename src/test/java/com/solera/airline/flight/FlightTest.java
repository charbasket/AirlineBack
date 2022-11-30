package com.solera.airline.flight;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.solera.airline.files.Payload;
import com.solera.airline.files.ReUsableMehods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class FlightTest {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "http://localhost:8080/flights";
	}

	@Test
	public void getFlight2() {

		String response = given().log().all().queryParam("origin", "barcelona").when().get("flights/desOrg").then()
				.assertThat().statusCode(200).body("[0].airline", equalTo("Iberia")).extract().response().asString();

		System.err.println(response);

//		JsonPath js = new JsonPath(response);
		JsonPath js = ReUsableMehods.rawToJson(response);

		System.err.println(js.getString("[0].airline"));
		System.err.println(js.getString("size()"));

	}

//	public static void main(String[] args) {
//		JsonPath jsonPath = new JsonPath(Payload.array());
//		System.err.println(jsonPath.getInt("courses.size()"));
//	}

	@Test
	public void getAllFlights() {
		String response = given().when().get("all").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = ReUsableMehods.rawToJson(response);
		int size = js.getInt("size()");
		System.err.println(size);

//		Assert.assertEquals(js.getInt("size()"), 2);
	}

	@Test
	public void getFlight() {
		String response = given().when().get("1").then().assertThat().statusCode(200).extract().response().asString();
		Assert.assertEquals(response, Payload.firsFlight());
	}

	@Test
	public void deleteFlight() {

		ReUsableMehods.createFlight();
		int sizeBefore = ReUsableMehods.getAllFlightsSize();

		String response = given().when().delete(ReUsableMehods.getLastFlightId() + "/delete").then().assertThat()
				.statusCode(200).extract().response().asString();
		Assert.assertEquals(response, "ok");

		int sizeAfter = ReUsableMehods.getAllFlightsSize();
		System.err.println(sizeAfter);
		Assert.assertEquals(sizeAfter, sizeBefore - 1);

	}

	@Test
	public void createFlight() {

//		String response = given().when().get("all").then().assertThat().statusCode(200).extract().response().asString();
//		JsonPath js = ReUsableMehods.rawToJson(response);
		int sizeBefore = ReUsableMehods.getAllFlightsSize();

		String response = given().header("Content-Type", "application/json").body(Payload.addFlight()).when()
				.post("create").then().log().all().assertThat().statusCode(200).extract().response().asString();
		Assert.assertEquals(response, "ok");

		int sizeAfter = ReUsableMehods.getAllFlightsSize();
		Assert.assertEquals(sizeAfter, sizeBefore + 1);

		ReUsableMehods.deleteFlight(sizeAfter);

	}

}
