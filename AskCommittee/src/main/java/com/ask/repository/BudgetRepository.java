package com.ask.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ask.dto.BudgetRequest;
import com.ask.entity.Budget;
import com.ask.entity.BudgetInfo;
import com.ask.entity.Shop;

/**
 * 予算情報 Repository
 */
@Repository
public interface BudgetRepository extends JpaRepository<Shop, Long>, JpaSpecificationExecutor<Shop> {
	
	public static final JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	/**
	 * 予算内容表示
	 */
	public default void view(BudgetRequest budgetRequest) {
		
		List<BudgetInfo> budgetInfoList = new ArrayList<BudgetInfo>();
		
		List<Map<String, Object>> detailList;
		detailList = jdbcTemplate.queryForList("select * from ask_budget_detail");
		
		BudgetInfo budgetInfo = new BudgetInfo();
		
		
		//予算内容の数だけ回す
		for(int i = 0; i <= detailList.size(); i++) {
		
		//budget_infoとidが等しい場合、contentをaddする
		if(ask_budget_info == ask) {
		}
		}
	}
}