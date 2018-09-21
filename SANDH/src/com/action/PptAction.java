package com.action;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.PptDao;
import com.model.Ppt;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PptAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String path;	 
	private String filename;
	private File ppt;
	private String pptFileName;
	
	public String execute(){
		return SUCCESS;
	}

	//用户界面展示ppt
	public String userShowPpt(){
		ActionContext context=ActionContext.getContext();
		List<Ppt> list=PptDao.getPpt();
		context.put("list", list);
		return "pptlist";
	}
	
	//用户界面下载ppt
	public String pptDownload(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		Ppt ppt =PptDao.getDownloadPpt(Integer.parseInt(id));
		filename=ppt.getName();
		path=ppt.getPath();
		return SUCCESS;
	}
	public java.io.InputStream getDownloadFile()throws Exception {
		InputStream in= ServletActionContext.getServletContext().getResourceAsStream(getPath());
		 return in;
		}
	
	//get set 方法
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public File getPpt() {
		return ppt;
	}

	public void setPpt(File ppt) {
		this.ppt = ppt;
	}

	public String getPptFileName() {
		return pptFileName;
	}

	public void setPptFileName(String pptFileName) {
		this.pptFileName = pptFileName;
	}

	
	
}
