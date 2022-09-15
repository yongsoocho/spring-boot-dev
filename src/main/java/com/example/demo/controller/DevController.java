package com.example.demo.controller;

import com.example.demo.entity.DevEntity;
import com.example.demo.service.DevService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DevController {

	private final DevService devService;

	@GetMapping()
	public List<String> getAllDeveloper() {
		log.info("get/getAllDeveloper");
		return Arrays.asList("Hello", "World");
	}

	@PostMapping()
	public DevEntity createDeveloper() {
		log.info("get/createDeveloper");
		return this.devService.createDev();
	}
}
