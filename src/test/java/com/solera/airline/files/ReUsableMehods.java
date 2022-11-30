package com.solera.airline.files;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class ReUsableMehods {
	JsonPath js;

	public static JsonPath rawToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}

	public static int getAllFlightsSize() {
		String response = given().when().get("all").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = ReUsableMehods.rawToJson(response);
		int size = js.getInt("size()");
		return size;
	}

	public static int getLastFlightId() {
		String response = given().when().get("last").then().assertThat().statusCode(200).extract().response()
				.asString();
		JsonPath js = ReUsableMehods.rawToJson(response);
		int flightId = js.getInt("flightId");
		return flightId;
	}

	public static void createFlight() {
		given().header("Content-Type", "application/json").body(Payload.addFlight()).when().post("create").then().log()
				.all().assertThat().statusCode(200);
	}

	public static void deleteFlight(int flightId) {
		given().when().delete(+flightId + "/delete").then().assertThat().statusCode(200).extract().response()
				.asString();
	}
}
