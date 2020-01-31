package com.ask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ask.entity.Shop;

/**
 * 予算情報 Repository
 */
@Repository
public interface BudgetRepository extends JpaRepository<Shop, Long>, JpaSpecificationExecutor<Shop> {
	
	/**
	 * 予算変更
	 */
//	public default void create(ShopRequest shopRequest) {
//		this.save(CreateShop(shopRequest));
//	}

}