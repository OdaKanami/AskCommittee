//package com.ask.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//
//import com.ask.entity.BudgetInfo;
//
//public interface BudgetInfoRepository extends JpaRepository<BudgetInfo, Long>, JpaSpecificationExecutor<BudgetInfo>{
//
//	/**
//	 * 予算内容情報全件取得 
//	 */
//	public default List<BudgetInfo> findAll() {
//		return this.findAll();
//	}
//}
