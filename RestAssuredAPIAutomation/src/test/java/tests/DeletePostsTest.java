package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeletePostsTest extends BaseTest {
    @Test
    public void deletePost() {
        given().when().delete("/posts/1").then().statusCode(200);
    }
}
