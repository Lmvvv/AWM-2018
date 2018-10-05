package com.service.impl;

import java.util.List;

import com.dao.BaseDictDao;
import com.model.BaseDict;
import com.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao bdd;
	@Override
	public List<BaseDict> getListByTypeCode(String dist_type_code) {
		
		return bdd.getListByTypeCode(dist_type_code);
	}
	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

}
