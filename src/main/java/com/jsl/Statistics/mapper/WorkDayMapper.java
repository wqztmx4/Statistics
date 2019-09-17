package com.jsl.Statistics.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsl.Statistics.entities.WorkDay;

@Repository
public interface WorkDayMapper {
	
	int insertDateAllYear(List<WorkDay> days);
	
	int deleteDateAllYear();

	int changeWeekendStatus();

	int calcWorkDay(String startDate, String endDate);

	WorkDay afterWorkDay(String startDate, int distance);

	WorkDay beforeWorkDay(String startDate, int distance);
	

}
