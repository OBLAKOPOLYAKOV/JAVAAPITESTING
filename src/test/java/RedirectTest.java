import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class RedirectTest {

    @Test
    public void testRedirect(){
        String url = "https://playground.learnqa.ru/api/long_redirect";

        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .get(url)
                .andReturn();

        String location = response.getHeader("Location");
        System.out.println(location);
    }
}
