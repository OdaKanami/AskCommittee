package service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.sun.xml.fastinfoset.sax.Properties;

import dto.ShopRequest;
import entity.Shop;
import repository.ShopRepository;

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
	 * @return 検索結果
	 */
	public List<Shop> searchAll() {
		return shopRepository.searchAll();
	}

	/**
	 * お店情報新規登録
	 * @param user ユーザー情報
	 */
	public void create(ShopRequest shopRequest) {
		shopRepository.create(shopRequest);
	}

}
