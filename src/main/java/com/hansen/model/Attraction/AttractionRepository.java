package com.hansen.model.Attraction;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hansen.cnst.AttractionEnum;

/**
 * <pre>
 * 參考: <a href="http://blog.didispace.com/springbootmongodb/">Spring Boot MongoDB</a>
 * 
 * 參考: <a href="https://tests4geeks.com/spring-data-boot-mongodb-example/">Spring data boot mongodb example</a>
 * </pre>
 */
public interface AttractionRepository extends MongoRepository<Attraction, Long> {
	
	List<Attraction> findAttractionsByAttractionEnum(AttractionEnum attractionEnum);

}
