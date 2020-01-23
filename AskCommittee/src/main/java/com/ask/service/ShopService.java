package com.ask.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.ask.dto.ShopRequest;
import com.ask.entity.Shop;
import com.ask.repository.ShopRepository;
import com.sun.xml.fastinfoset.sax.Properties;

@Service
@ComponentScan("service")
@Transactional(rollbackOn = Exception.class)
public class ShopService {
	
	/**
	 * お店情報 Repository
	 */
	@Autowired
	ShopRepository shopRepository;

	/**
	 * お店情報 全検索
	 */
	public List<Shop> searchAll() {
		return shopRepository.searchAll();
	}

	/**
	 * お店情報新規登録
	 */
	public void create(ShopRequest shopRequest) {
		shopRepository.create(shopRequest);
	}

	/**
	 * お店削除
	 */
	public void delete(ShopRequest shopRequest) {
		shopRepository.deleteAll();
	}
}
