package com.javateam.SpringMediaDemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.javateam.SpringMediaDemo.config.WebConfig;
import com.javateam.SpringMediaDemo.controller.JsonFeedController;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= WebConfig.class)
@WebAppConfiguration
@Slf4j
public class JsonTest {
	
	@Inject
	WebApplicationContext wac;
	
	MockMvc mock;
	
	String id;
	
	@Before
	public void setup() {
		
		id = "a1234";
		
		// mock = MockMvcBuilders.webAppContextSetup(wac).build();
		mock = MockMvcBuilders
				.standaloneSetup(new JsonFeedController()).build();
	}
	
	@Test
	public void testJson() throws Exception {
		
		mock.perform(get("/product/"+id+".json")
					// .accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"id\":\"a1234\",\"name\":\"마우스\",\"detail\":\"게임용 마우스\"}"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json; charset=UTF-8"))
			// .andExpect(jsonPath("$['id']").value("a1234"))
			.andExpect(jsonPath("id").value("a1234"))
			.andExpect(jsonPath("$['name']").value("마우스"))
			.andExpect(jsonPath("$['detail']").value("게임용 마우스"));
			
	} //

}
