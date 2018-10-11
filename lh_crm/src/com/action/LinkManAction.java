package com.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.model.Customer;
import com.model.LinkMan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.LinkManService;
import com.utils.PageBean;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkman = new LinkMan();
	private LinkManService lms;
	private Integer currentPage; //当前页数
	private Integer pageSize;    //每页显示数据条数
	

	
	public String delete() throws Exception {
		//1.
		LinkMan lm= lms.getById(linkman.getLkm_id());
		//2.
		lms.delete(lm);
		return "delete";
	}
	
	public String toEdit() throws Exception {
		//1.
		LinkMan lm= lms.getById(linkman.getLkm_id());
		//2.
//		lm.toString();
		ActionContext.getContext().put("linkMan", lm);
		return "edit";
	}
	public String add() throws Exception {
		//1.调用service层的save方法
		lms.save(linkman);
		linkman.toString();
		//2.重定向到页面
		return "toList";
	}
	
	public String list()  throws Exception {
		//封装离线查询对象
		DetachedCriteria dc=DetachedCriteria.forClass(LinkMan.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(linkman.getLkm_name())){
			//模糊查询用于搜索
			dc.add(Restrictions.like("lkm_name", "%" + linkman.getLkm_name() + "%"));
			
		}
		
		//1.调用service层查询分页数据(PageBean)
		PageBean pb= lms.getPageBean(dc,currentPage,pageSize);
		//2.将PageBean放到request域转发到页面并显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	

	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkman;
	}

	public void setLms(LinkManService lms) {
		this.lms = lms;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
