package com.lego.care4you.test;

import com.lego.care4you.Config;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

/**
 * @author Boris Pérez
 */

@ContextConfiguration(classes = {Config.class})
@TestPropertySource("classpath:application.properties")
public class RegisterMachines {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    private Config config;

    @Before
    public void setup() {
        RestAssured.baseURI = config.getUrl();
        RestAssured.port = config.getPort();

    }

    @Test
    public void RegisterMachines() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("capacity", "LOW");
        requestParams.addProperty("description", config.getDescription());
        requestParams.addProperty("mark", config.getMark());
        requestParams.addProperty("model", config.getModel());
        requestParams.addProperty("name", config.getName());
        requestParams.addProperty("price", config.getPrice());
        request.body(requestParams.toString());
        Response response = request.post("/machines");
        int code = response.getStatusCode();
        Assert.assertEquals(200, code);
    }
}
