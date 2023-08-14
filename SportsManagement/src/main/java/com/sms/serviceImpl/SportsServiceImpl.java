package com.sms.serviceImpl;

import java.util.List;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dto.SportsDTO;
import com.sms.entity.Sports;

import com.sms.repository.PlayerRepository;
import com.sms.repository.SportsRepository;
import com.sms.service.SportsService;

import com.sms.util.SportsConverter;

@Service
public  class SportsServiceImpl implements SportsService {

	@Autowired
	SportsRepository sportsRepository;
	@Autowired
	SportsConverter sportsConverter;
	@Autowired
	PlayerRepository playerRepository;
	@Override
	public SportsDTO addSports(Sports sports) {
		Sports s=sportsRepository.save(sports);
						
			return sportsConverter.convertToSportsDTO(s);
				
		
	}
	@Override
	public List<SportsDTO> getAllSports() {
		List<Sports>sports=sportsRepository.findAll();
		List<SportsDTO>dtoList=new ArrayList<>();
		for (Sports s:sports) {
			dtoList.add(sportsConverter.convertToSportsDTO(s));
		}
		return dtoList;
	}
	@Override
	public SportsDTO getSportsById(int id) {
		SportsDTO sports=sportsRepository.findById(id).get(id);
		
		return sportsConverter.convertToSportsEntity(sports);
	}
	
	@Override
	public String deleteSports(int id) {
		sportsRepository.deleteById(id);
		return "Sports details got deleted successfully";
	}
	@Override
	public List<SportsDTO> getsportsByName(String name) {
		
		return sportsRepository.finfByName(name) ;
	}
	@Override
	public List<SportsDTO> getsportsByLocation(String location) {
		
		return sportsRepository.findByLocation(location);
	}
	@Override
	public Sports addSports(SportsDTO sportsDTO) {
		Sports sports=Sports.builder()
				.id(sportsDTO.getId())
				.name(sportsDTO.getName())
				.location(sportsDTO.getLocation())
		.build();
		return sportsRepository.save(sports);
	}
}
