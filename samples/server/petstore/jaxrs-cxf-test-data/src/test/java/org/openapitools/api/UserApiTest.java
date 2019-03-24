/**
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.openapitools.api;

import java.util.List;
import java.util.Map;
import org.openapitools.model.User;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.jaxrs.xml.JacksonXMLProvider;
import org.apache.cxf.jaxrs.provider.MultipartProvider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import java.io.File;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.BeforeClass;
import org.openapitools.codegen.utils.JsonCache;

/**
 * OpenAPI Petstore
 *
 * <p>This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * API tests for UserApi.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserApiTest {
    private static Validator validator;
    private static JsonCache cache;

    @BeforeClass
    public static void beforeClass() throws Exception {
        File cacheFile = new File(System.getProperty("jaxrs.test.client.json",
                "C:\\source\\GitHub\\demonfiddler\\openapi-generator\\samples\\server\\petstore\\jaxrs-cxf-test-data\\src\\main\\resources\\test-data.json"));
        cache = JsonCache.Factory.instance.get("test-data").load(cacheFile).child("/org.openapitools.api/UserApi");

        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @LocalServerPort
    private int serverPort;

    private UserApi api;

    @Before
    public void setup() {
        List<?> providers = Arrays.asList(new JacksonJsonProvider(), new JacksonXMLProvider(), new MultipartProvider());

        api = JAXRSClientFactory.create("http://localhost:" + serverPort + "/services", UserApi.class, providers);
        org.apache.cxf.jaxrs.client.Client client = WebClient.client(api);

        ClientConfiguration config = WebClient.getConfig(client); 
    }

    private void validate(Object o) {
        assertNotNull(o);
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        if (!violations.isEmpty()) {
            StringBuilder message = new StringBuilder("Validation failed");
            for (ConstraintViolation<Object> violation : violations)
                message.append("; ").append(violation.getPropertyPath()).append(": ").append(violation.getMessage());
            fail(message.toString());
        }
    }

    
    /**
     * Create user
     *
     * This can only be done by the logged in user.
     *
     * @throws ApiException if the API call fails
     */
    @Test
    public void createUserTest() throws Exception {
        User body = cache.getObject("/createUser/body", User.class);
        api.createUser(body);
    }
    
    /**
     * Creates list of users with given input array
     *
     * @throws ApiException if the API call fails
     */
    @Test
    public void createUsersWithArrayInputTest() throws Exception {
        List<User> body = cache.getObjects("/createUsersWithArrayInput/body", User.class);
        api.createUsersWithArrayInput(body);
    }
    
    /**
     * Creates list of users with given input array
     *
     * @throws ApiException if the API call fails
     */
    @Test
    public void createUsersWithListInputTest() throws Exception {
        List<User> body = cache.getObjects("/createUsersWithListInput/body", User.class);
        api.createUsersWithListInput(body);
    }
    
    /**
     * Delete user
     *
     * This can only be done by the logged in user.
     *
     * @throws ApiException if the API call fails
     */
    @Test
    public void deleteUserTest() throws Exception {
        String username = cache.getString("/deleteUser/username");
        api.deleteUser(username);
    }
    
    /**
     * Get user by user name
     *
     * @throws ApiException if the API call fails
     */
    @Test
    public void getUserByNameTest() throws Exception {
        String username = cache.getString("/getUserByName/username");
        User response = api.getUserByName(username);
        // TODO: complete test assertions
        validate(response);
    }
    
    /**
     * Logs user into the system
     *
     * @throws ApiException if the API call fails
     */
    @Test
    public void loginUserTest() throws Exception {
        String username = cache.getString("/loginUser/username");
        String password = cache.getString("/loginUser/password");
        String response = api.loginUser(username, password);
        // TODO: complete test assertions
        validate(response);
    }
    
    /**
     * Logs out current logged in user session
     *
     * @throws ApiException if the API call fails
     */
    @Test
    public void logoutUserTest() throws Exception {

        api.logoutUser();
    }
    
    /**
     * Updated user
     *
     * This can only be done by the logged in user.
     *
     * @throws ApiException if the API call fails
     */
    @Test
    public void updateUserTest() throws Exception {
        String username = cache.getString("/updateUser/username");
        User body = cache.getObject("/updateUser/body", User.class);
        api.updateUser(username, body);
    }
    
}
