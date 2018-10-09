package com.action;

import com.model.Customer;
import com.model.LinkMan;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkman = new LinkMan();
	private LinkManService lms;
	

	public String add() throws Exception {
		//1.
		lms.save(linkman);
		//2.
		return "toList";
	}

	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkman;
	}

	public void setLms(LinkManService lms) {
		this.lms = lms;
	}

}
