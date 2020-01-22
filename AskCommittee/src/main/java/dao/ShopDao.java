package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import entity.Shop;

public class ShopDao {
	
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public Shop createShop(Map<String, Object> row) {
		Integer id = (Integer) row.get("id");
		String name = (String) row.get("name");
		String url = (String) row.get("url");
		String phoneNumber = (String) row.get("phoneNumber");
		String remark = (String) row.get("remark");
		Shop shop = new Shop();
		shop.setId(id);
		shop.setName(name);
		shop.setUrl(url);
		shop.setPhoneNumber(phoneNumber);
		shop.setRemark(remark);
		return shop;		
	}
	
	public List<Shop> createList(List<Map<String, Object>> rows){
		List<Shop> shopList = new ArrayList<Shop>();
		for(Map<String, Object> row :rows) {
			Shop shop = createShop(row);
			shopList.add(shop);
		}
		return shopList;
		
	}
	
	public int insert(Shop shop) {
		String sql = "INSERT INTO shop(name,url,phoneNumber,remark) VALUES(?,?,?,?):";
		Object[] parameters = {shop.getName(), shop.getUrl(), shop.getPhoneNumber(), shop.getRemark()};
		
		TransactionStatus transactionStatus = null;
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		int numberOfRow = 0;
		try {
			transactionStatus = transactionManager.getTransaction(transactionDefinition);
			numberOfRow = jdbcTemplate.update(sql, parameters);
			transactionManager.commit(transactionStatus);
		}catch(DataAccessException e) {
			e.printStackTrace();
			transactionManager.rollback(transactionStatus);
		}catch(TransactionException e) {
			e.printStackTrace();
			if(transactionStatus != null) {
				transactionManager.rollback(transactionStatus);
			}
		}
		return numberOfRow;
		
	}
	
}
