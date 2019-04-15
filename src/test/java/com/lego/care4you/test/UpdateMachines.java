package com.lego.care4you.test;

import com.google.gson.JsonObject;
import com.lego.care4you.Config;
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
//TODO Export static variables to enum
public class UpdateMachines {

    private String idMachine;

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

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JsonObject requestParams1 = new JsonObject();
        requestParams1.addProperty("capacity", "LOW");
        requestParams1.addProperty("description", config.getDescription());
        requestParams1.addProperty("mark", config.getMark());
        requestParams1.addProperty("model", config.getModel());
        requestParams1.addProperty("name", config.getName());
        requestParams1.addProperty("price", config.getPrice());
        request.body(requestParams1.toString());
        Response response = request.post("/machines");
        idMachine = response.jsonPath().getString("id");
    }

    @Test
    public void UpdateMachines() {
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
        Response response = request.put("/machines/" + idMachine);
        int code = response.getStatusCode();
        Assert.assertEquals(200, code);
    }
}
