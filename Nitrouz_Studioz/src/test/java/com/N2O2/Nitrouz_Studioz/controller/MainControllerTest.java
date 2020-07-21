package com.N2O2.Nitrouz_Studioz.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    ProfileEntity profileEntity;
    @Autowired
    ProfileDoa profileDoa;

    private MainController mainController;
    @Mock
    private Model model;
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
            .andReturn();
        Assertions.assertEquals("index", result);
    }
}
