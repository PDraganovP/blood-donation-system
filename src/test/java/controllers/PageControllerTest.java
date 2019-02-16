package controllers;

import app.BloodDonationApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BloodDonationApp.class)
@AutoConfigureMockMvc
public class PageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetBloodDonationCenterPage() throws Exception {
        this.mockMvc.perform(get("/blood-donation-center")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("basicPages/blood-donation-center"));

    }

    @Test
    public void testGetBloodDonorsPage() throws Exception {
        this.mockMvc.perform(get("/blood-donors")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("basicPages/blood-donors"));

    }
    @Test
    public void testGetBloodGrooupsPage() throws Exception {
        this.mockMvc.perform(get("/blood-groups")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("basicPages/blood-groups"));

    }

    @Test
    public void testGetBloodRecipientsPage() throws Exception {
        this.mockMvc.perform(get("/blood-recipients")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("basicPages/blood-recipients"));

    }

    @Test
    public void testGetBloodTestingPage() throws Exception {
        this.mockMvc.perform(get("/blood-testing")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("basicPages/blood-testing"));

    }

    @Test
    public void testGetBloodTransfusionPage() throws Exception {
        this.mockMvc.perform(get("/blood-transfusion")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("basicPages/blood-transfusion"));

    }

    @Test
    public void testGetHomePage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("basicPages/home"));

    }
}
