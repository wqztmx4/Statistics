package com.jsl.Statistics.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsl.Statistics.entities.WorkDay;
import com.jsl.Statistics.mapper.WorkDayMapper;

@Component
public class WorkDayUtil {

	@Autowired
	WorkDayMapper dateMapper;

	public boolean insertWorkDay2DB() {
		int result = 0;
		List<WorkDay> days = new ArrayList<WorkDay>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1992);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		for (int y = 1992; y < 2030; y++, calendar.add(Calendar.YEAR, 0)) {
			for (int i = 0; i < 12; i++, calendar.add(Calendar.MONTH, 0)) {
				int sumdayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				for (int j = 1; j <= sumdayOfMonth; j++, calendar.add(Calendar.DAY_OF_MONTH, 1)) {
					String date_string = new SimpleDateFormat("yyyy-MM-dd E").format(calendar.getTime());
					String workday = date_string.split(" ")[0];
					int weekday = WeekDaysEnum.getIdByTypeName(date_string.split(" ")[1]);
					WorkDay workDay = new WorkDay();
					workDay.setIsHoliday(0);
					workDay.setWorkdate(workday);
					workDay.setWeek_day(weekday);
					days.add(workDay);
				}
			}
		}
		result = dateMapper.insertDateAllYear(days);
		return result > 0 ? true : false;
	}

	public boolean changeWeekendStatus() {
		return dateMapper.changeWeekendStatus() > 0 ? true : false;
	}

	public int calcWorkDay(String startDate, String endDate) {
		return dateMapper.calcWorkDay(startDate, endDate);
	}

	public WorkDay afterWorkDay(String startDate, int distance) {
		return dateMapper.afterWorkDay(startDate, distance);
	}
	
	public WorkDay beforeWorkDay(String startDate, int distance) {
		return dateMapper.beforeWorkDay(startDate, distance);
	}

	public boolean removeWorkDayInDB() {
		return dateMapper.deleteDateAllYear() >= 1 ? true : false;
	}

}
