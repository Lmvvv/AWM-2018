package com.lh.ssm.dao;

import java.util.List;

import com.lh.ssm.bean.BaseDict;

public interface  BaseDictDao {
	// 查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
