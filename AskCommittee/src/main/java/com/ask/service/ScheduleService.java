package com.ask.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ask.entity.Schedule;
import com.ask.repository.ScheduleRepository;

@Service
@ComponentScan("service")
@Transactional(rollbackOn = Exception.class)
public class ScheduleService {
	
	@Autowired
	ScheduleRepository scheduleRepository;
	
	/*
	 * スケジュール全件表示
	 */
	public List<Schedule> findAll(){
		return scheduleRepository.findAll();
	}
	
	public Page<Schedule> findAll(Pageable pageable){
		return scheduleRepository.findAll(pageable);
	}

    /*
     * 	新規登録
     */
    public Schedule create(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }	

    /*
     * 	更新
     */
    public Schedule update(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    /*
     * 	削除
     */
    public void delete(Schedule schedule) {
            scheduleRepository.delete(schedule);
    }
	
}
