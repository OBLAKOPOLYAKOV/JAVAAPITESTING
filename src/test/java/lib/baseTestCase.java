package lib;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.hasKey;

import java.awt.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class baseTestCase {
    protected String getHeader(Response Response, String name){
        Headers headers = Response.getHeaders();

        assertTrue(headers.hasHeaderWithName(name), "Response doesnt have header with name "+name);
        return headers.getValue(name);
    }

    protected String getCookie(Response Response, String name){
        Map<String, String> cookies = Response.getCookies();

        assertTrue(cookies.containsKey(name), "Response doesnt have cookie with name "+name);
        return cookies.get(name);
    }

    protected String getCookieValue(Response Response, String name, String value){
        Map<String, String> cookies = Response.getCookies();

        assertEquals(cookies.get(name), value, "Response doesnt have cookie with name "+name +" or cr cookie havent value: "+value);
        return cookies.get(name);
    }

    protected int getIntFromJson(Response Response, String name){
        Response.then().assertThat().body("$", hasKey(name));
        return Response.jsonPath().getInt(name);
    }
}
