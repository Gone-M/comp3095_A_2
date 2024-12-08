package ca.gbc.approvalservice;

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
public class ApprovalServiceIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApproveRequest() throws Exception {
        String approvalJson = """
                {
                  "eventId": "1",
                  "approved": true
                }
                """;

        mockMvc.perform(MockMvcRequestBuilders.post("/api/approvals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(approvalJson))
                .andExpect(status().isCreated());
    }
}
