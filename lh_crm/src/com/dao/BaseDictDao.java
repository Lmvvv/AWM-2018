package com.dao;

import java.util.List;

import com.model.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
