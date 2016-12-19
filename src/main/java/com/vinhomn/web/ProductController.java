package com.vinhomn.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinhomn.data.domain.Product;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

	@GetMapping
	public Map<String, List<Product>> getList() {

		List<Product> products = new ArrayList<Product>();
		Map<String, List<Product>> modelMap = new HashMap<String, List<Product>>();
		modelMap.put("model", products);
		return modelMap;
	}
}
