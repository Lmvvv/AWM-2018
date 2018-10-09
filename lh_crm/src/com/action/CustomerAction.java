package com.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CustomerService;
import com.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private static final long serialVersionUID = 1L;

	// 上传的文件会自动封装到File对象
	// 在后台提供一个与前台input type=file组件 name相同的属性
	private File photo;
	// 在提交键名后加上固定后缀FileName,文件名称会自动封装到属性中
	private String photoFileName;
	// 在提交键名后加上固定后缀ContentType,文件MIME类型会自动封装到属性中
	private String photoContentType;

	private Customer customer = new Customer();
	private CustomerService cs;
	private Integer currentPage;
	private Integer pageSize;
	//显示客户信息
	public String list() throws Exception {
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		// 判断并封装参数
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}

		// 1 调用Service查询分页数据(PageBean)
		PageBean pb = cs.getPageBean(dc, currentPage, pageSize);
		// 2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	//添加客户
	public String add() throws Exception {
		
		
		photo.renameTo(new File("G:/haha.jpg"));
		//--------------------------------
		//1 调用Service,保存Customer对象
		cs.save(customer);
		//2 重定向到客户列表Action
		return "toList";
	}
	//修改客户
	public String toEdit(){
		//1.
		Customer c= cs.getById(customer.getCust_id());
		//2.
		ActionContext.getContext().put("customer", c);
		return "edit";
	}
	
	public String delete(){
		//1.根据用户的id的到要删除customer对象
		Customer c= cs.getById(customer.getCust_id());
		//2.
		cs.delete(c);
		return "delete";
	}
	
	@Override
	public Customer getModel() {
		return customer;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
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

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

}
