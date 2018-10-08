package com.service.impl;

import java.util.List;

import com.dao.BaseDictDao;
import com.model.BaseDict;
import com.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao bdd;
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// TODO Auto-generated method stub
		return bdd.getListByTypeCode(dict_type_code);
	}
	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

}
