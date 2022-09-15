package com.example.demo.dto;

import com.example.demo.entity.DevEntity;
import com.example.demo.type.DevLevel;
import com.example.demo.type.DevSkill;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevDetailDto {
	private DevLevel devLevel;
	private DevSkill devSkill;
	private String memberId;
	private String name;
	private Integer age;

	public static DevDetailDto fromEntity(DevEntity devEntity) {
		return DevDetailDto.builder()
				.devLevel(devEntity.getDevLevel())
				.devSkill(devEntity.getDevSkill())
				.memberId(devEntity.getMemberId())
				.name(devEntity.getName())
				.age(devEntity.getAge())
				.build();
	}
}
