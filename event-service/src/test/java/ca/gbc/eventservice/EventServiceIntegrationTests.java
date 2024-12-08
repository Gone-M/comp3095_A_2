package ca.gbc.eventservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EventServiceIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateEvent() throws Exception {
        String eventJson = """
                {
                  "eventName": "New Year Party",
                  "organizerId": "1",
                  "eventType": "Party",
                  "expectedAttendees": 50
                }
                """;

        mockMvc.perform(MockMvcRequestBuilders.post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(eventJson))
                .andExpect(status().isCreated());
    }
}
