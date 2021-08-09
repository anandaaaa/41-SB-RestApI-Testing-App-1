package in.anand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.anand.rest.WelcomeRestController;
import in.anand.service.WelcomeService;

@WebMvcTest(value=WelcomeRestController.class)
public class WelcomeRestControllerTest {
	
	@MockBean
	private WelcomeService welcomeservice;
	
	@Autowired
	private MockMvc mocmvc;
	
	@Test
	public void welcomeTest() throws Exception
	{
		when(welcomeservice.welcomeMsg()).thenReturn("welcome msg");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
		ResultActions resultActions = mocmvc.perform(requestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		
		assertEquals(200,status);
		
		
		
	}
	

}
