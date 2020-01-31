package com.ask.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Table(name = "ask_schedule")
public class ScheduleRequest {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	

	private String title;

	private String start;

	private String end;
	
	private String tag;
	
	private String memo;
		
}
