package org.dozsapeter.genesys.api_testing.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.dozsapeter.genesys.helpers.MergeLists;
import org.dozsapeter.genesys.helpers.PrintMap;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.dozsapeter.genesys.constants.Urls.JSON_PLACEHOLDER_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JSONPlaceholderTest {

    @Test
    public void firstResponseEntityEmailHasAtSignInIt() {
        RestAssured.defaultParser = Parser.JSON;
        Response response = given().get(JSON_PLACEHOLDER_URL)
                        .then().contentType(ContentType.JSON).extract().response();

        assertTrue(response.jsonPath().getString("email[0]").contains("@"));

        List<String> names = response.jsonPath().get("name");
        List<String> emails = response.jsonPath().get("email");
        Map<String,String> users = MergeLists.toMap(names,emails);

        PrintMap.toTerminal(users);
    }
}
