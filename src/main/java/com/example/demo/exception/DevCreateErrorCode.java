package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DevCreateErrorCode {
	LEVEL_YEAR_NOT_MATCH("개발과 레벨 년차가 맞지 않습니다."),
	NO_DEV("개발자를 찾을 수 없습니다."),
	DEV_DUPLICATED("개발자가 곂치고 있습니다.");

	private final String message;
}
