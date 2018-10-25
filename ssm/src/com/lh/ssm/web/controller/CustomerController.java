package com.lh.ssm.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lh.common.utils.Page;
import com.lh.ssm.bean.BaseDict;
import com.lh.ssm.bean.Customer;
import com.lh.ssm.bean.QueryVo;
import com.lh.ssm.service.BaseDictService;
import com.lh.ssm.service.CustomerService;

/**
 * 客户管理
 * @author LH李恒
 * @date 创建时间：2018年10月22日 下午4:18:08
 */
@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	/**
	 * 显示用户列表
	 * 
	 * @return
	 */
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	//这里的查询条件是写死的，有硬编码问题。可以把类别代码提取到配置文件中，再使用@value注解进行加载
	@Value("${fromType.code}")
	private String fromTypeCode;
	@RequestMapping(value="/list.action")
	public String list(QueryVo vo ,Model model){
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		// 把前端页面需要显示的数据放到模型中
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		//通过四个条件查询分页对象
		Page<Customer> page=customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		return "customer";
	}
	@RequestMapping(value="/edit.action")
	public @ResponseBody Customer edit(Integer id){
		return customerService.selectCustomerById(id);
	}
	@RequestMapping(value="/update.action")
	//ajax json 数据交换
	public @ResponseBody  String update(Customer customer){
		customerService.updateCustomerById(customer);
		return "OK";
	}
	@RequestMapping(value="/delete.action")
	//ajax json 数据交换
	public @ResponseBody  String delete(Integer id){
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
