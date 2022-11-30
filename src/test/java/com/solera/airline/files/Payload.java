package com.solera.airline.files;

public class Payload {
	public static String addFlight() {
		return "{\r\n" + "    \"origin\":\"Barcelona\",\r\n" + "    \"destiny\": \"Madrid\",\r\n"
				+ "    \"airline\": \"Ryaner\",\r\n" + "    \"flightNumber\":55555,\r\n" + "    \"transitTime\":2,\r\n"
				+ "    \"scales\": 0,\r\n" + "    \"luggage\": \"false\",\r\n" + "    \"price\": 50\r\n" + "}";
	}

	public static String array() {
		return "{\r\n" + "\r\n" + "\"dashboard\": {\r\n" + "\r\n" + "\"purchaseAmount\": 910,\r\n" + "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n" + "\r\n" + "},\r\n" + "\r\n" + "\"courses\": [\r\n"
				+ "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"Selenium Python\",\r\n" + "\r\n" + "\"price\": 50,\r\n"
				+ "\r\n" + "\"copies\": 6\r\n" + "\r\n" + "},\r\n" + "\r\n" + "{\r\n" + "\r\n"
				+ "\"title\": \"Cypress\",\r\n" + "\r\n" + "\"price\": 40,\r\n" + "\r\n" + "\"copies\": 4\r\n" + "\r\n"
				+ "},\r\n" + "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"RPA\",\r\n" + "\r\n" + "\"price\": 45,\r\n"
				+ "\r\n" + "\"copies\": 10\r\n" + "\r\n" + "}\r\n" + "\r\n" + "]\r\n" + "\r\n" + "}";
	}

	public static String firsFlight() {
		return "{\"flightId\":1,\"origin\":\"Barcelona\",\"destiny\":\"Berlin\",\"airline\":\"Iberia\",\"flightNumber\""
				+ ":54321,\"departureDate\":\"2022-11-29T15:03:05.691+00:00\",\"transitTime\":1.5,\"scales\":0,\"luggage\":true,\"price\":100.0}";
	}
}
