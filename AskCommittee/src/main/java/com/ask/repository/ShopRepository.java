package com.ask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ask.dto.ShopRequest;
import com.ask.entity.Shop;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, JpaSpecificationExecutor<Shop> {
	/**
	 * お店情報 全検索
	 * @return 検索結果
	 */
	public default List<Shop> searchAll() {
		return this.findAll();
	}

	/**
	 * お店情報新規登録
	 * @param user ユーザー情報
	 */
	public default void create(ShopRequest shopRequest) {
		this.save(CreateShop(shopRequest));
	}

	/**
	 * お店TBLエンティティの生成
	 * @param shopRequest お店情報リクエストデータ
	 * @return お店TBLエンティティ
	 */
	public default Shop CreateShop(ShopRequest shopRequest) {

		Shop shop = new Shop();
		shop.setName(shopRequest.getName());
		shop.setUrl(shopRequest.getUrl());
		shop.setPhoneNumber(shopRequest.getPhoneNumber());
		shop.setRemark(shopRequest.getRemark());

		return shop;
	}
}