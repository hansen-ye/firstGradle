package com.hansen.service.Attraction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import com.hansen.cnst.AttractionEnum;
import com.hansen.model.Attraction.Attraction;
import com.hansen.model.Attraction.AttractionRepository;
import com.hansen.service.CounterService;

@Service
public class AttractionService {
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private AttractionRepository attractionRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	private String collectionName = ((Document) Attraction.class.getAnnotation(Document.class)).collection();

	public void add(AttractionEnum attractionEnum, String country, String name, Float latitude, Float longitude) {
		Long id = getNextSeq();
		Float[] loc = new Float[] {latitude, longitude};
		attractionRepo.save(new Attraction(id, attractionEnum, country, name, loc));
	}
	
	public void delete(Long id) {
		attractionRepo.delete(id);
	}

	public List<Attraction> queryByType(AttractionEnum attractionEnum) {
		return attractionRepo.findAttractionsByAttractionEnum(attractionEnum);
	}
	
	private Long getNextSeq() {
		return counterService.getNextSequence(collectionName);
	}

}