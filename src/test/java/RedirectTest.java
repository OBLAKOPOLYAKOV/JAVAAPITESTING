import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class RedirectTest {

    @Test
    public void testRedirect(){
        String url = "https://playground.learnqa.ru/api/long_redirect";
        int count = 0;
        int statusCod = 300;

        while (statusCod!=200){
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .get(url)
                    .andReturn();

            url = response.getHeader("Location");
            statusCod = response.getStatusCode();
            if (statusCod !=200){
                System.out.println(url);
                count++;
            }
        }
        System.out.println("\nNumber of redirects:");
        System.out.println(count);


    }
}
