package com.hansen.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.test.context.junit4.SpringRunner;

import com.hansen.Application;
import com.hansen.cnst.AttractionEnum;
import com.hansen.model.Attraction.Attraction;
import com.hansen.model.Attraction.AttractionRepository;
import com.hansen.service.CounterService;

@RunWith(SpringRunner.class)
@SpringBootTest(
	classes = Application.class,
	webEnvironment = WebEnvironment.RANDOM_PORT
)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_MongoDB_Attraction {
	
	@Autowired
	private CounterService counterService;

	@Autowired
	private AttractionRepository attractionRepository;
	
	private final String collectionName = ((Document) Attraction.class.getAnnotation(Document.class)).collection();
	
	
	@Test
	public void test_01_deleteAllAttractions() {
		attractionRepository.deleteAll();
		
		List<Attraction> allAttractions = attractionRepository.findAll();
		assertThat(allAttractions.size()).isEqualTo(0);
		
		Long currentSeqNo = counterService.resetSequence(collectionName);
		assertThat(currentSeqNo).isEqualTo(0L);
		
		System.out.println(">>>>> Test 1: deleteAllAttractions -> Delete all testing datas and reset counters done");
	}
	

	@Test
	public void test_02_addAttractions() throws Exception {
		Long id = counterService.getNextSequence(collectionName);
		AttractionEnum attractionEnum = AttractionEnum.SHOPPING;
		String country = "Taiwan";
		String name = "林口三井 OUTLET";
		Float[] loc = new Float[] {25.071159F, 121.363789F};
		attractionRepository.save(new Attraction(id, attractionEnum, country, name, loc));
		
		id = counterService.getNextSequence(collectionName);
		attractionEnum = AttractionEnum.RESTAURANT;
		name = "大嗑西式餐館";
		loc = new Float[] {25.041049F, 121.528263F};
		attractionRepository.save(new Attraction(id, attractionEnum, country, name, loc));
		
		id = counterService.getNextSequence(collectionName);
		attractionEnum = AttractionEnum.RESTAURANT;
		name = "上引水產";
		loc = new Float[] {25.066956F, 121.537046F};
		attractionRepository.save(new Attraction(id, attractionEnum, country, name, loc));
		
		id = counterService.getNextSequence(collectionName);
		attractionEnum = AttractionEnum.RESTAURANT;
		name = "WE里手工pizza 日本料理 串燒";
		loc = new Float[] {25.061350F, 121.528933F};
		attractionRepository.save(new Attraction(id, attractionEnum, country, name, loc));
		
		id = counterService.getNextSequence(collectionName);
		attractionEnum = AttractionEnum.RESTAURANT;
		name = "花家食堂";
		loc = new Float[] {25.057268F, 121.563983F};
		attractionRepository.save(new Attraction(id, attractionEnum, country, name, loc));
		
		id = counterService.getNextSequence(collectionName);
		attractionEnum = AttractionEnum.RESTAURANT;
		name = "東京紅茶餐廳 KANO嘉農";
		loc = new Float[] {25.041333F, 121.532515F};
		attractionRepository.save(new Attraction(id, attractionEnum, country, name, loc));
		
		id = counterService.getNextSequence(collectionName);
		attractionEnum = AttractionEnum.RESTAURANT;
		name = "上海隆記菜館";
		loc = new Float[] {25.042681F, 121.510857F};
		attractionRepository.save(new Attraction(id, attractionEnum, country, name, loc));
		
		
		System.out.println(">>>>> Test 2: addAttractions -> Add testing datas done, total datas: " + id);
	}
	
	
	@Test
	public void test_03_findAttractionsByAttractionEnum() throws Exception {
		AttractionEnum attractionEnum = AttractionEnum.RESTAURANT;

		List<Attraction> attractions = attractionRepository.findAttractionsByAttractionEnum(attractionEnum);
		
		for (Attraction attraction : attractions) {
			assertThat(attraction.getAttractionEnum()).isEqualTo(attractionEnum);
		}
		
		System.out.println(">>>>> Test 3: findAttractionsByAttractionType(" + attractionEnum + ") -> Data counts: " + attractions.size() + ", Datas: " + attractions);
	}
}
