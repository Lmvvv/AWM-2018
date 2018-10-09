package com.service.impl;

import com.dao.LinkManDao;
import com.model.LinkMan;
import com.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao lmd;
	@Override
	public void save(LinkMan linkman) {
		// TODO Auto-generated method stub
		lmd.save(linkman);
	}
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	
}
