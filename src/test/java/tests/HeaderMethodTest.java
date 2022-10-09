package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import lib.baseTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeaderMethodTest extends baseTestCase{
    @Test
    public void testHeaderMethod(){
        String headerName = "x-secret-homework-header";
        String headerValue = "Some secret value";
        Response responseHeader = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();
        System.out.println(responseHeader.getHeaders());
        String header = getHeader(responseHeader, headerName);
        assertEquals(header, headerValue," header havent header with value:"+headerValue);
    }
}
