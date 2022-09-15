package com.example.demo.controller;

import com.example.demo.dto.CreateDev;
import com.example.demo.dto.DevDetailDto;
import com.example.demo.dto.DevDto;
import com.example.demo.service.DevService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DevController {

	private final DevService devService;

	@GetMapping()
	public List<DevDto> getAllDeveloper() {
		log.info("get/getAllDeveloper");
		// this 생략가능
		return devService.getAllDev();
	}

	@GetMapping("{memberId}")
	public DevDetailDto getDevDetail(@PathVariable String memberId) {
		return this.devService.getDevDetail(memberId);
	}

	@PostMapping()
	public CreateDev.Res createDeveloper(
			@Valid CreateDev.Req req
	) {
//		application/x-www-form-urlencoded 은 @RequestBody 를 인식못함
		log.info("get/createDeveloper" + req.toString());
		return this.devService.createDev(req);
	}
}
