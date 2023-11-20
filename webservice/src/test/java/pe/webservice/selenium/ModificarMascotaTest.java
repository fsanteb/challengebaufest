package pe.webservice.selenium;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ModificarMascotaTest {
	public static void main(String[] args) {
        // ID de la mascota que deseas modificar
        String petId = "1"; // Reemplaza esto con el ID de la mascota que deseas modificar

        // Base URL de la API
        String baseURL = "https://petstore.swagger.io/v2";

        // Cuerpo de la solicitud para modificar una mascota
        String requestBody = "{\n" +
                "  \"id\": " + petId + ",\n" + // Incluir el ID de la mascota
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie2\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        // Realizar la solicitud PUT para modificar una mascota existente
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .put(baseURL + "/pet");

        // Imprimir la respuesta
        System.out.println("Código de respuesta: " + response.getStatusCode());
        System.out.println("Respuesta: " + response.getBody().asString());
    }
}
