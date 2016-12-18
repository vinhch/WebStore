package com.vinhomn.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinhomn.web.model.TestModel;

@Controller
@RequestMapping("/test")
public class TestController {

	@GetMapping
    public Map<String, TestModel> get() {
		
		TestModel model = new TestModel();
		model.setA("aaa");
		model.setB("bbb");
		
		Map<String, TestModel> modelMap = new HashMap<String, TestModel>();
		modelMap.put("model", model);
        return modelMap;
    }
	
	@PostMapping
	public TestModel post(@ModelAttribute("model") TestModel model) {
		
		return model;
	}
}
