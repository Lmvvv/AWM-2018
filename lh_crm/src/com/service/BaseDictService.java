package com.service;

import java.util.List;

import com.model.BaseDict;

public interface BaseDictService {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
