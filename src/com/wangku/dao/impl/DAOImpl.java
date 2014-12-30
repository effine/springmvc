package com.wangku.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wangku.dao.IDAO;
import com.wangku.entity.Account;
import com.wangku.mapper.AccountMapper;

@Repository
@Transactional(rollbackFor=Exception.class)
public  class DAOImpl implements  IDAO {
	
	@Autowired
	private AccountMapper accountMapper;
	
	public void delete(Long entity_id) throws Exception{
		delete(new Long[]{entity_id});
	}

	public  void delete(Long[] entity_ids) throws Exception{
		for(Long id:entity_ids){
			accountMapper.removeAccount(id);
		}
	}

	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public Account find(Long entity_id) {
		return accountMapper.getAccountById(entity_id);
	}

	public void save(Account entity) throws Exception{
		accountMapper.addAccount(entity);
	}

	public void update(Account entity) throws Exception{
		accountMapper.editAccount(entity);
	}
	
	public List<Account> getList(){
		return (List<Account>) accountMapper.getAllAccount();
	}

}
