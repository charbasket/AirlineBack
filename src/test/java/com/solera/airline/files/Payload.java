package com.solera.airline.files;

public class Payload {
	public static String addFlight() {
		return "{\r\n" + "    \"origin\":\"Madrid\",\r\n" + "    \"destiny\": \"Paris\",\r\n"
				+ "    \"airline\": \"Ryaner\",\r\n" + "    \"flightNumber\":12345,\r\n" + "    \"transitTime\":2,\r\n"
				+ "    \"scales\": 0,\r\n" + "    \"luggage\": \"false\",\r\n" + "    \"price\": 150\r\n" + "}";
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
}
