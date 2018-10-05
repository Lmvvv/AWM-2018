package com.service;

import java.util.List;

import com.model.BaseDict;

public interface BaseDictService {

	//更具数据字典雷翔获得对象
	List<BaseDict> getListByTypeCode(String dist_type_code);

}
