package com.lego.care4you;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Boris Pérez
 */
//TODO Find a better way to read global properties
@Component
public class Config {

    @Value("${url}")
    private String url;

    @Value("${port}")
    private Integer port;

    @Value("${mark}")
    private String mark;

    @Value("${description}")
    private String description;

    @Value("${name}")
    private String name;

    @Value("${price}")
    private String price;

    @Value("${model}")
    private String model;

    public String getUrl() {
        return url;
    }

    public Integer getPort() {
        return port;
    }

    public String getMark() {
        return mark;
    }

    public String getDescription() { return description; }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

}
