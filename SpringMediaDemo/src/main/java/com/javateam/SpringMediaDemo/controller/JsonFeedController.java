package com.javateam.SpringMediaDemo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javateam.SpringMediaDemo.domain.ProductVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class JsonFeedController {
	
	// xml, json
	@GetMapping(value = "/product/{id}", 
				headers="Accept=*/*", 
				// method = RequestMethod.GET,
				produces = {"application/json; charset=UTF-8", "application/xml; charset=UTF-8"})
				// produces = {MediaType.APPLICATION_XML_VALUE, 
				//		    MediaType.APPLICATION_JSON_VALUE})
				// produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductVO> product(@PathVariable("id") String id, Model model) {
		
		log.info("product(JSON)");
		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.add("Content-Type", "application/json; charset=UTF-8");
		
		ProductVO product = new ProductVO();
		product.setId(id);
		product.setName("마우스");
		product.setDetail("게임용 마우스");
		
		return ResponseEntity.ok(product);
	}

}
