package com.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.model.BaseDict;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaseDictService;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport {

	private String dist_type_code;
	private BaseDictService baseDictService;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//1.调用Service根据typecode获得数据字典对象list
		List<BaseDict> list= baseDictService.getListByTypeCode(dist_type_code);
		//2.将list转换为 json格式
		String json=JSONArray.fromObject(list).toString();
		//3. 将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	public String getDist_type_code() {
		return dist_type_code;
	}
	public void setDist_type_code(String dist_type_code) {
		this.dist_type_code = dist_type_code;
	}
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

}
