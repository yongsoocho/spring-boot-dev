package com.example.demo.service;

import com.example.demo.dto.CreateDev;
import com.example.demo.dto.DevDetailDto;
import com.example.demo.dto.DevDto;
import com.example.demo.dto.EditDev;
import com.example.demo.entity.DevEntity;
import com.example.demo.entity.RetiredDev;
import com.example.demo.exception.DevCreateErrorCode;
import com.example.demo.exception.DevCreateException;
import com.example.demo.repository.DevRepository;
import com.example.demo.repository.RetiredRepository;
import com.example.demo.type.DevLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class DevService {
	private final DevRepository devRepository;
	private final RetiredRepository retiredRepository;
//	private final EntityManager em;

//	public DevService(DevRepository devRepository) {
//		this.devRepository = devRepository;
//	}

	public CreateDev.Res createDev(CreateDev.Req req) {
		validateCreateDevReq(req);
//		EntityTransaction transaction = em.getTransaction();
//		try {
		DevEntity devEntity = DevEntity.builder().devLevel(req.getDevLevel()).devSkill(req.getDevSkill()).years(req.getYears()).memberId(req.getMemberId()).name(req.getName()).age(req.getAge()).build();
		DevEntity result = devRepository.save(devEntity);
//			transaction.commit();
		return CreateDev.Res.fromEntity(result);
//		} catch (Exception e) {
//			transaction.rollback();
//			throw e;
//		}
	}

	private void validateCreateDevReq(CreateDev.Req req) {
		if (req.getDevLevel() == DevLevel.SENIOR && req.getYears() < 10) {
			throw new DevCreateException(DevCreateErrorCode.LEVEL_YEAR_NOT_MATCH, "년차 에러 메시지");
		}

//		Optional<DevEntity> dev = devRepository.findByMemberId(req.getMemberId());
//		if(dev.isPresent()) {
//			throw new DevCreateException(DevCreateErrorCode.DEV_DUPLICATED, "메시지2");
//		}
		devRepository.findByMemberId(req.getMemberId()).ifPresent((dev) -> {
			throw new DevCreateException(DevCreateErrorCode.DEV_DUPLICATED, "중복 에러 메세지");
		});
	}

	public List<DevDto> getAllDev() {
		return devRepository.findAll().stream().map(DevDto::fromEntity).collect(Collectors.toList());
	}

	public DevDetailDto getDevDetail(String memberId) {
		return devRepository.findByMemberId(memberId).map(DevDetailDto::fromEntity).orElseThrow(() -> new DevCreateException(DevCreateErrorCode.NO_DEV));
	}

	@Transactional
	public DevDto editDev(String memberId, EditDev.Req req) {
		DevEntity dev = devRepository.findByMemberId(memberId).orElseThrow(() -> new DevCreateException(DevCreateErrorCode.NO_DEV));

		dev.setDevLevel(req.getDevLevel());
		dev.setDevSkill(req.getDevSkill());
		dev.setYears(req.getYears());

		return DevDto.fromEntity(dev);
	}

	public DevDetailDto removeDev(String memberId) {
		DevEntity dev = devRepository.findByMemberId(memberId).orElseThrow(() -> new DevCreateException(DevCreateErrorCode.NO_DEV));

		RetiredDev retiredDev = RetiredDev.builder()
				.memberId(dev.getMemberId())
				.name(dev.getName())
				.build();

		retiredRepository.save(retiredDev);

		return DevDetailDto.fromEntity(dev);
	}

	;
}
