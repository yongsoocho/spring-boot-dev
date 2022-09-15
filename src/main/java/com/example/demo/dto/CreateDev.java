package com.example.demo.dto;

import com.example.demo.entity.DevEntity;
import com.example.demo.type.DevLevel;
import com.example.demo.type.DevSkill;
import lombok.*;

import javax.persistence.criteria.From;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateDev {

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	@ToString
	public static class Req {
		@NotNull
		private DevLevel devLevel;
		@NotNull
		private DevSkill devSkill;
		@NotNull
		@Min(0)
		@Max(20)
		private Integer years;
		@NotNull
		@Size(min = 3, max = 50, message = "memberId size must 3 ~ 50")
		private String memberId;
		@NotNull
		@Size(min = 3, max = 20, message = "name size must 3 ~ 50")
		private String name;

		@Min(18)
		private Integer age;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Res {
		private DevLevel devLevel;
		private DevSkill devSkill;
		private Integer years;
		private String memberId;

		public static Res fromEntity(DevEntity devEntity) {
			return Res.builder()
					.devLevel(devEntity.getDevLevel())
					.devSkill(devEntity.getDevSkill())
					.years(devEntity.getYears())
					.memberId(devEntity.getMemberId())
					.build();
		}
	}
}
