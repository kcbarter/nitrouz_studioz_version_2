package com.N2O2.Nitrouz_Studioz.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.service.ProfileDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(MainController.class)
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileDoa profileDoa;
    @MockBean
    private ProfileDetailsService profileDetailsService;

    private MainController mainController;

    private boolean loggedOut = true;
    private boolean loggedIn = false;

    @BeforeEach
    public void intializeController(){
        mainController = new MainController();
    }

    @Test
    @DisplayName("Navigating to Website Correctly Displays Index page")
    public void loadsIndexPage() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/");
        MvcResult result = mockMvc.perform(request)
            .andExpect(model().attribute("loggedOut", loggedOut))
            .andExpect(model().attribute("loggedIn", loggedIn))
            .andExpect(model().attribute("profileEntity", "Not logged In"))
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    @DisplayName("Selceting the tab About correctly Displays the About page")
    public void loadsAboutPage() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/about");
        MvcResult result = mockMvc.perform(request)
            .andExpect(model().attribute("loggedOut", loggedOut))
            .andExpect(model().attribute("loggedIn", loggedIn))
            .andExpect(model().attribute("profileEntity", "Not logged In"))
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    @DisplayName("Sing Up route takes you to the Sign Up Page")
    public void loadsSignUpPage(){
        Assertions.assertEquals("signup", mainController.sign_up());
    }
}
