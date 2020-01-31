package com.ask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ask.dto.ScheduleRequest;
import com.ask.entity.Schedule;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>, JpaSpecificationExecutor<Schedule>{
	/**
	 * スケジュール表示
	 */
	public default List<Schedule> searchAll() {
		return this.findAll();
	}

	/**
	 * スケジュール登録
	 */
	public default void create(ScheduleRequest scheduleRequest) {
		this.save(CreateSchedule(scheduleRequest));
	}

	/**
	 *　エンティティの生成
	 */
	public default Schedule CreateSchedule(ScheduleRequest scheduleRequest) {
		Schedule schedule = new Schedule();
		schedule.setId(scheduleRequest.getId());
		schedule.setTitle(scheduleRequest.getTitle());
		schedule.setStart(scheduleRequest.getStart());
		schedule.setEnd(scheduleRequest.getEnd());
		schedule.setTag(scheduleRequest.getTag());
		schedule.setMemo(scheduleRequest.getMemo());

		return schedule;
	}
	
	/**
	 * スケジュール削除
	 */
	public default void delete(ScheduleRequest scheduleRequest) {
		this.delete(DeleteSchedule(scheduleRequest));
	}

	/**
	 * エンティティの生成
	 */
	public default Schedule DeleteSchedule(ScheduleRequest scheduleRequest) {

		Schedule schedule = new Schedule();
		schedule.setId(scheduleRequest.getId());
		schedule.setTitle(scheduleRequest.getTitle());
		schedule.setStart(scheduleRequest.getStart());
		schedule.setEnd(scheduleRequest.getEnd());
		schedule.setTag(scheduleRequest.getTag());
		schedule.setMemo(scheduleRequest.getMemo());

		return schedule;
	}
}
