package com.jsl.Statistics.entities;

import org.springframework.stereotype.Repository;

@Repository
public class WorkDay {

	private int id;

	private String workdate;

	private int week_day;

	private int isHoliday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeek_day() {
		return week_day;
	}

	public void setWeek_day(int week_day) {
		this.week_day = week_day;
	}
	
	public int getIsHoliday() {
		return isHoliday;
	}

	public void setIsHoliday(int isHoliday) {
		this.isHoliday = isHoliday;
	}

	public String getWorkdate() {
		return workdate;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

}
