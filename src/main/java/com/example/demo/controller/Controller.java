package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class Controller {

	@GetMapping()
	public List<String> getAllDeveloper() {
		return Arrays.asList("Hello", "World");
	}
}
