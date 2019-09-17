package com.jsl.Statistics.utils;

public enum WeekDaysEnum {

	Mon(1, "星期一"), Tus(2, "星期二"), Wen(3, "星期三"), Thu(4, "星期四"), Fri(5, "星期五"), Sat(6, "星期六"), sun(7, "星期日");

	private int typeId;
	private String typeName;

	WeekDaysEnum(int typeId, String typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}
	
	public static int getIdByTypeName(String typeName) {
		int value = 0;
		WeekDaysEnum[] values = values();
		
		for(int i = 0 ; i < values.length ; i++) {
			WeekDaysEnum type = values[i];
			if(type.getTypeName().equals(typeName)) {
				value = type.getTypeId();
				break;
			}
		}
		
		return value;
	}
	


}
