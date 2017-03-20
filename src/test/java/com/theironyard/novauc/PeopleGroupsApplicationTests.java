package com.theironyard.novauc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theironyard.novauc.entities.PersonRepositoryInterFace;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PeopleGroupsApplicationTests {

	@Autowired
	WebApplicationContext wap;

	@Autowired
	PersonRepositoryInterFace persons;

	MockMvc mockMvc;

	@Before
	public void before(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
	}

	@Test
	public void addPerson() throws Exception {


		Person person = new Person();
		person.setName("Alice");
		person.setAddress("17 Princess St");
		person.setEmail("alice@gmail.com");
		person.setPhonenumber("123-345-3344");
		person.setSsn("222-33-3333");

		ObjectMapper Mapper = new ObjectMapper();
		String json = Mapper.writeValueAsString(person);



		mockMvc.perform(
				MockMvcRequestBuilders.post("/user")
						.content(json)
						.contentType("application/json")

		);
		Assert.assertTrue(persons.count() == 2);

	}

	@Test
	public void updateUser() throws Exception{
		Assert.assertTrue(persons.findOne(1).getName().equals("John"));
			Person person = new Person();
			person.setName("Alex");
			person.setAddress("17 Prince St");
			person.setEmail("alex@gmail.com");
			person.setPhonenumber("123-344-3344");
			person.setSsn("222-33-3333");
			person.setId(1);

			ObjectMapper Mapper = new ObjectMapper();
			String json = Mapper.writeValueAsString(person);



			mockMvc.perform(
					MockMvcRequestBuilders.put("/user")
							.content(json)
							.contentType("application/json")

			);
			Assert.assertTrue(persons.findOne(1).getName().equals("Alex"));

		}


	@Test
	public void deleteUser() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/user/2")
		);

		Assert.assertTrue(persons.count() == 1);
	}

	@Test
	public void getUsers() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(persons.findAll());
		Person person = new Person();
		person.setName("");
		person.setEmail("");
		person.setAddress("");
		person.setEmail("");
		person.setSsn("");
		ResultActions actions = mockMvc.perform(
			MockMvcRequestBuilders.get("/user"))
				.andExpect(status().isOk())
				.andExpect(content().json(json));

		
//		when((persons.findAll() == true)
//		return(getUsers()));
//		mockMvc.perform(getUsers("/user")
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//				.andExpect(jsonPath("$", hasSize(2)))
//				.andExpect(jsonPath("$[0].id", Integer.valueOf(1)))
//				.andExpect(jsonPath("$[0].username",String.valueOf ("Daenerys Targaryen")))
//				.andExpect(jsonPath("$[1].id", Integer.valueOf(2)))
//				.andExpect(jsonPath("$[1].username", String.valueOf("John Snow"))));
//
//		;


		}





	@Test
	public void contextLoads() {
	}

}
