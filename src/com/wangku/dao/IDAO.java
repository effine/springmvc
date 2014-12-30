package com.wangku.dao;

import java.util.List;

import com.wangku.entity.Account;

public interface  IDAO {
	/*
	 * 保存实体
	 */
	public void save(Account entity) throws Exception;
	/*
	 * 更新实体
	 */
	public void update(Account entity) throws Exception;
	
	/*
	 * 删除实体
	 */
	public  void delete(Long entity_id) throws Exception;
	
	public void delete(Long[] entity_ids) throws Exception;
	
	/*
	 * 查询实体
	 */
	public  Account find(Long entity_id);
	
	public List<Account> getList();
	
}
