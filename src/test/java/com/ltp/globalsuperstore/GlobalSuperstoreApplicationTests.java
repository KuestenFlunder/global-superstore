package com.ltp.globalsuperstore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.ltp.globalsuperstore.controller.StoreController;
import com.ltp.globalsuperstore.service.StoreService;
@AutoConfigureMockMvc
@SpringBootTest
class GlobalSuperstoreApplicationTests {

@Autowired
private StoreController controller;

@MockBean
private StoreService storeService;

@Autowired
private MockMvc mockMvc;


@Test
public void showInventoryTest()throws Exception{
	RequestBuilder request = MockMvcRequestBuilders.get("/inventory");
	mockMvc.perform(request)
		.andExpect(status().is2xxSuccessful())
		.andExpect(view().name("inventory"))
		.andExpect(model().attributeExists("items"))
		;
}


}
