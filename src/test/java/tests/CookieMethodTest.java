package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import lib.baseTestCase;

public class CookieMethodTest extends baseTestCase{
    @Test
    public void testCookieMthod (){
        String nameCookie = "HomeWork";
        Response responseCookie = RestAssured
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();
        String cookieValue = getCookie(responseCookie, nameCookie);
        String cookie = getCookieValue(responseCookie, nameCookie, "hw_value");
        System.out.println("Cookie with name homeWork have are value:" + cookie);



    }

}
