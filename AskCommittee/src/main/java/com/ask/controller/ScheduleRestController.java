package com.ask.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ask.entity.Schedule;
import com.ask.service.ScheduleService;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleRestController {
	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping(value = "/schedule")
	public List<Schedule> getSchedules() throws IOException{
		List<Schedule> schedules = scheduleService.findAll();
		return schedules;
	}

}
