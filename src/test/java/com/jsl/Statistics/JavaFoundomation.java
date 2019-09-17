package com.jsl.Statistics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaFoundomation {
	
	public void listTest() {
		List<Object> l = new ArrayList<Object>();
		Iterator<Object> i = l.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}

}
