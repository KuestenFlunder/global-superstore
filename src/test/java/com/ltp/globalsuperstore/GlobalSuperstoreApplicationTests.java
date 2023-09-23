package com.ltp.globalsuperstore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.Instant;
import java.util.Date;

import com.ltp.globalsuperstore.controller.StoreController;
import com.ltp.globalsuperstore.repository.StoreRepository;
import com.ltp.globalsuperstore.service.StoreService;

@AutoConfigureMockMvc
@SpringBootTest
class GlobalSuperstoreApplicationTests {

	@Autowired
	StoreRepository storeRepository;

	@MockBean
	private StoreService storeService;

	private Instant instant = Instant.now();
	private Date currentDate = Date.from(instant);
	private Item[] items = new Item[] {
			new Item("Furniture", "table", 12.33, 5.00, currentDate, "1"),
			new Item("Office", "pencil", 1.33, 5.00, currentDate, "2"),
			new Item("Automotive", "motor", 1234.45, 5.00, currentDate, "3")
	};

	@BeforeEach
	public void prepareItems() {
		for (Item item : items) {
			storeRepository.addItem(item);
		}
	}

	@AfterEach
	private void cleanItems() {
		storeRepository.getItems().clear();
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void showInventoryTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/inventory");
		mockMvc.perform(request)
				.andExpect(status().is2xxSuccessful())
				.andExpect(view().name("inventory"))
				.andExpect(model().attributeExists("items"));
	}

	@Test
	public void showFormTest() throws Exception {
		when(storeService.getItemFromId("1")).thenReturn(items[1]);

		RequestBuilder request = MockMvcRequestBuilders
			.get("/form")
			.param("id", "1");

		mockMvc.perform(request)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("form"))
			.andExpect(model().attributeExists("item"))
			;
	}

}
