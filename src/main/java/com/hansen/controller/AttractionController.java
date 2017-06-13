package com.hansen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hansen.cnst.AttractionEnum;
import com.hansen.cnst.ResultCode;
import com.hansen.model.Attraction.Attraction;
import com.hansen.service.Attraction.AttractionService;
import com.hansen.vo.response.RespCommon;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <pre>
 * 景點相關 API
 * </pre>
 * 
 */
@Controller
@RequestMapping(value = "/attraction")
@Api(value = "AttractionController - 景點相關 API")
public class AttractionController {

	@Autowired
	private AttractionService attractionService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "新增景點")
	@ResponseBody
	public RespCommon add(
			@RequestParam(name = "景點類別", required = true) AttractionEnum attractionEnum,
			@RequestParam(name = "國家", required = true) String country,
			@RequestParam(name = "名稱", required = true) String name,
			@RequestParam(name = "緯度", required = true) Float latitude,
			@RequestParam(name = "經度", required = true) Float longitude) {
		attractionService.add(attractionEnum, country, name, latitude, longitude);
		return new RespCommon(ResultCode.SUCCESS);
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.PUT)
	@ResponseBody
	public RespCommon delete(
			@RequestParam(name = "ID", required = true) Long id) {
		attractionService.delete(id);
		return new RespCommon(ResultCode.SUCCESS);
	}

	@RequestMapping(value = "queryByType", method = RequestMethod.GET)
	@ApiOperation(value = "根據景點類別, 查詢景點資料", responseContainer = "List", response = Attraction.class)
	@ResponseBody
	public List<Attraction> queryByType(
			@RequestParam(name = "景點類別", required = true) AttractionEnum attractionEnum) {
		return attractionService.queryByType(attractionEnum);
	}
}