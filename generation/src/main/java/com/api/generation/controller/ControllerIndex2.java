package com.api.generation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerIndex2 {
	
	@RequestMapping("/index2.html")
	public String index_dois() {
		return "index2";
	}

}
