package ca.gbc.bookingservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingServiceIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateBooking() throws Exception {
        String bookingJson = """
                {
                  "roomId": "101",
                  "userId": "1",
                  "date": "2024-12-01",
                  "time": "10:00"
                }
                """;

        mockMvc.perform(MockMvcRequestBuilders.post("/api/bookings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookingJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.roomId").value("101"))
                .andExpect(jsonPath("$.userId").value("1"))
                .andExpect(jsonPath("$.date").value("2024-12-01"))
                .andExpect(jsonPath("$.time").value("10:00"));
    }
}
