package com.example.demo.controller;

import com.example.demo.dto.CreateDev;
import com.example.demo.dto.DevDetailDto;
import com.example.demo.dto.DevDto;
import com.example.demo.dto.EditDev;
import com.example.demo.exception.DevCreateException;
import com.example.demo.service.DevService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
//		@RequestBody 가 없으면 JSON 을 못 받음
		log.info("get/createDeveloper" + req.toString());
		return this.devService.createDev(req);
	}

	@PutMapping("{memberId}")
	public DevDto editDev(@PathVariable String memberId, @Valid EditDev.Req req) {
		return devService.editDev(memberId, req);
	}

	@DeleteMapping("{memberId}")
	public DevDetailDto removeDev(@PathVariable String memberId) {
		return devService.removeDev(memberId);
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DevCreateException.class)
	public DevCreateException handleException(Exception e) {
		return null;
	}
}
