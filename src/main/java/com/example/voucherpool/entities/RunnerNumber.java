package com.example.voucherpool.entities;

import java.util.UUID;

public  class RunnerNumber {
	
	protected static String getNumber() {
		String uniq =UUID.randomUUID().toString();
        StringBuffer strUniq = new StringBuffer();
		return strUniq.append(uniq.substring(0,8)).toString();
		
	}

}
