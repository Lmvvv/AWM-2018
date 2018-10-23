package com.lh.ssm.service;

import java.util.List;

import com.lh.ssm.bean.BaseDict;

public interface BaseDictService {
	// 查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
