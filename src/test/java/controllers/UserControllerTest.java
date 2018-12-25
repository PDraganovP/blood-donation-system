package controllers;

import app.BloodDonationApp;
import app.controllers.UserController;
import app.entities.Role;
import app.entities.User;
import app.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
@SpringBootTest(classes = BloodDonationApp.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetMenuAdnin() throws Exception {
        this.mockMvc.perform(get("/menu-admin")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("users/user"));
    }
/*
    @MockBean
    private UserService userService;

    @Test
    @WithMockUser(roles = {"ADMIN", "BLOOD DONATION CENTER", "BLOOD DONATOR"})
    public void testChangeRole() throws Exception {
        // User user=userService.findByUsername("user");
        // when(userService.findByUsername("user")).thenReturn(user);
      *//*  this.mockMvc.perform(post("/change-role")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("users/user"));*//*

        when(userService.findByUsername("username").getUsername()).thenReturn("Shivachevo");
        this.mockMvc.perform(post("/change-role")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Shivachevo")));
    }*/

   /* @Test
    @WithMockUser(roles = "ADMIN")
    public void testChangeRole() throws Exception {
        this.mockMvc.perform(post("/change-role")).andDo(print()).andExpect(status().is(403))
                .andExpect(view().name("unauthorized"));
    }*/
   @Test
   @WithMockUser(roles = "ADMIN")
   public void testChangeRole() throws Exception {
       this.mockMvc.perform(post("/change-role")).andDo(print()).andExpect(status().isOk())
               .andExpect(view().name("users/user"));

   }

}
