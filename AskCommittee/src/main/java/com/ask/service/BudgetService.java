package com.ask.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.ask.entity.BudgetInfo;
import com.ask.entity.Shop;
import com.ask.repository.BudgetRepository;

@Service
@ComponentScan("service")
@Transactional(rollbackOn = Exception.class)
public class BudgetService {
	
//	/**
//	 * 予算情報 Repository
//	 */
//	@Autowired
//	BudgetRepository budgetRepository;
//	BudgetInfoRepository budgetInfoRepository;
//	
	/**
	 * 予算情報 全検索
	 */
//	public List<BudgetInfo> findAll() {
//		return budgetInfoRepository.findAll();
//	}


	/**
	 * 予算変更
	 */
//	public void create(BudgetRepository budgetRepository) {
//		budgetRepository.create(budgetRepository);
//	}
}
