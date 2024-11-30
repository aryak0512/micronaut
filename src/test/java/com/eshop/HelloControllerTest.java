package com.eshop;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class HelloControllerTest {

    @Client("/")
    @Inject
    HttpClient httpClient;

    @Test
    public void testHelloWorldEndpointReturns200Ok() {
        HttpResponse<String> response = httpClient.toBlocking().exchange("/hello");
        assertTrue(response.getStatus() == HttpStatus.OK);
    }

    @Test
    public void testHelloWorldEndpointReturnsValidString() {
        HttpResponse<String> response = httpClient.toBlocking().exchange("/hello", String.class);
        assertEquals("Hello world!", response.getBody().get());
    }


}
