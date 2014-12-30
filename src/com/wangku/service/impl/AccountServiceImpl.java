package com.wangku.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangku.dao.IDAO;
import com.wangku.entity.Account;
import com.wangku.service.IAccountService;

@Service
@Transactional(rollbackFor=Exception.class)
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	private IDAO iDao;

	public boolean addAccount(Account entity) throws Exception{
		entity.setId((long)new Random().nextInt(99999));
		entity.setName("名字");
		iDao.save(entity);
		return true;
	}

	public Account getAccount(Long id) throws Exception {
		return iDao.find(id);
	}

	public List<Account> getAccounts() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> getList() {
		return iDao.getList();
	}

}
