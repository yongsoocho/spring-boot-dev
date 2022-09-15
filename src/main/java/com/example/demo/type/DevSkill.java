package com.example.demo.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DevSkill {
	BACK_END("서버"),
	FRONT_END("웹"),
	FULL_STACK("풀스택");

	private final String description;
}
