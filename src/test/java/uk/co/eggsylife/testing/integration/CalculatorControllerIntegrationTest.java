package uk.co.eggsylife.testing.integration;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import uk.co.eggsylife.testing.categories.IntegrationTest;


@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-context/test-context.xml"})
@WebAppConfiguration
public class CalculatorControllerIntegrationTest {
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testShowCalculator() throws Exception {
		this.mockMvc.perform(
					get("/calculator"))
					.andExpect(status().isOk())
					.andExpect(model().attributeExists("calculatorCommand"));
		
		Assert.assertFalse(true);
		
	}
	
	@Test
	public void testPostCalculator() throws Exception {
		this.mockMvc.perform(
					post("/calculator").param("numberOne", "1").param("numberTwo", "2"))
					.andExpect(status().isOk())
					.andExpect(model().attributeExists("result"))
					.andExpect(model().attribute("result", 3));
		
	}

}
