package com.jsl.Statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsl.Statistics.entities.WorkDay;
import com.jsl.Statistics.utils.WorkDayUtil;


@Controller
public class UserController {

	@Autowired
	WorkDayUtil workDayUtil;
	
	@RequestMapping("index")
	@ResponseBody
	public String Index() {
		return "Welcome to SpringBoot World";
	}
	
	/*
	 * @RequestMapping("addWorkDate")
	 * 
	 * @ResponseBody public String addWorkDate() { return
	 * workDayUtil.insertWorkDay2DB()==true?"成功插入年份数据":"插入失败"; }
	 */
	
	@RequestMapping("afterWorkDay/{startDate}/{distance}")
	@ResponseBody
	public WorkDay afterWorkDay(@PathVariable String startDate, @PathVariable int distance) {
		return workDayUtil.afterWorkDay(startDate, distance);
	}
	
	
	@RequestMapping("beforeWorkDay/{startDate}/{distance}")
	@ResponseBody
	public WorkDay beforeWorkDay(@PathVariable String startDate, @PathVariable int distance) {
		return workDayUtil.beforeWorkDay(startDate, distance);
	}
	
	
	
	@RequestMapping("calcWorkDay/{startDate}/{endDate}")
	@ResponseBody
	public int calcWorkDay(@PathVariable String startDate, @PathVariable String endDate) {
		return workDayUtil.calcWorkDay(startDate, endDate);
	}
	
	
	
	
	
	/*
	 * @RequestMapping("removeWorkDate")
	 * 
	 * @ResponseBody public String removeWorkDate() { return
	 * workDayUtil.removeWorkDayInDB()==true?"成功清空Date表":"清除表内容失败"; }
	 */
}
