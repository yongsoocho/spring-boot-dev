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
public class DevDto {
	private DevLevel devLevel;
	private DevSkill devSkill;
	private String memberId;

	public static DevDto fromEntity(DevEntity devEntity) {
		return DevDto.builder()
				.devLevel(devEntity.getDevLevel())
				.devSkill(devEntity.getDevSkill())
				.memberId(devEntity.getMemberId())
				.build();
	}
}
