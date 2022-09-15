package com.example.demo.service;

import com.example.demo.entity.DevEntity;
import com.example.demo.repository.DevRepository;
import com.example.demo.type.DevLevel;
import com.example.demo.type.DevSkill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DevService {
	private final DevRepository devRepository;

//	public DevService(DevRepository devRepository) {
//		this.devRepository = devRepository;
//	}

	@Transactional
	public DevEntity createDev() {
		DevEntity devEntity = DevEntity.builder()
				.devLevel(DevLevel.JUNIOR)
				.devSkill(DevSkill.BACK_END)
				.years(3)
				.name("soo")
				.age(25)
				.build();

		return devRepository.save(devEntity);
	}
}
