package com.interview.controller;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.SpringWithAngularApplication;
import com.interview.datatransferobject.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringWithAngularApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest
{

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate;


    private String createURLWithPort(String uri)
    {
        return "http://localhost:" + port + uri;
    }


    @Before
    public void setUp() throws Exception
    {
        restTemplate = new TestRestTemplate();
    }


    @Test
    public void testRegisterValidUser() throws JSONException, JsonParseException, JsonMappingException, IOException
    {

        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO =
            mapper.readValue(
                "{\"username\":\"maclean123\",\"password\":\"MACxav123#\",\"dateOfBirth\":\"1991-01-15T18:25:43.511Z\",\"socialSecNo\":\"499995559\"}", UserDTO.class);
        UserDTO response = restTemplate.postForObject(createURLWithPort("/v1/user/register"), userDTO, UserDTO.class);
        String actual = mapper.writeValueAsString(response);
        String expected = "{\"id\":1,\"username\":\"maclean123\",\"password\":\"MACxav123#\",\"dateOfBirth\":\"1991-01-15T18:25:43.511Z\",\"socialSecNo\":\"499995559\"}";
        JSONAssert.assertEquals(expected, actual, false);
    }


    @Test
    public void testRegisterUserIsAlreadyRegistered() throws JSONException, JsonParseException, JsonMappingException, IOException
    {

        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO =
            mapper.readValue(
                "{\"username\":\"maclean123\",\"password\":\"MACxav123#\",\"dateOfBirth\":\"1991-01-15T18:25:43.511Z\",\"socialSecNo\":\"499995559\"}", UserDTO.class);
        restTemplate.postForObject(createURLWithPort("/v1/user/register"), userDTO, UserDTO.class);

        String actual = restTemplate.postForObject(createURLWithPort("/v1/user/register"), userDTO, String.class);
        String expected = "{\"status\":400,\"error\":\"Bad Request\",\"message\":\"user has been already registered.\",\"path\":\"/v1/user/register\"}";
        JSONAssert.assertEquals(expected, actual, false);
    }


    @Test
    public void testRegisterUserIsBlackListed() throws JSONException, JsonParseException, JsonMappingException, IOException
    {

        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO =
            mapper.readValue(
                "{\"username\":\"maclean123\",\"password\":\"MACxav123#\",\"dateOfBirth\":\"1991-01-15T18:25:43.511Z\",\"socialSecNo\":\"999995559\"}", UserDTO.class);
        restTemplate.postForObject(createURLWithPort("/v1/user/register"), userDTO, UserDTO.class);

        String actual = restTemplate.postForObject(createURLWithPort("/v1/user/register"), userDTO, String.class);
        String expected = "{\"status\":400,\"error\":\"Bad Request\",\"message\":\"User is black listed.\",\"path\":\"/v1/user/register\"}";
        JSONAssert.assertEquals(expected, actual, false);
    }

}
