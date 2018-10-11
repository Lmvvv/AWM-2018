package com.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.model.Customer;
import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;
import com.utils.PageBean;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private User user = new User();

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		// TODO Auto-generated method stub
		// 1.调用service执行业务逻辑
		User u = userService.getUserByCodePassword(user);
		// 2.将返回的对象放入session域
		ActionContext.getContext().getSession().put("user", u);
		// 3.重定向到项目首页
		return "toHome";
	}

	public String regist() throws Exception {
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		return "toLogin";
	}

	private Integer page;
	private Integer rows;

	// 显示用户信息
	public String list() throws Exception {
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);

		// 1 调用Service查询分页数据(PageBean)
		PageBean pb = userService.getPageBean(dc, page, rows);
		// total:总记录数
		// rows:每行显示的数据
		// {total:xx,rows:[{user_id:1,user_name:'tom'}]}
		Map map = new HashMap();
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		// 将map转换为json
		String json = JSON.toJSONString(map);

		System.out.println(json);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);

		return null;
	}
	
	public String toEdit() throws Exception {
		//调用Service根据id查询User对象
		User u = userService.getById(user.getUser_id());
		//设置密码为空,禁止回显
		u.setUser_password("");
		//以json形式输出到浏览器
		String json = JSON.toJSONString(u);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	public String delete() throws Exception {
		//调用Service根据id查询User对象
		userService.deleteById(user.getUser_id());
		return null;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}



}
