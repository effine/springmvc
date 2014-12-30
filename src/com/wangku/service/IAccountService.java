package com.wangku.service;

import java.util.List;
import com.wangku.entity.Account;

public interface IAccountService {

	public boolean addAccount(Account entity) throws Exception;
	
	public Account getAccount(Long id) throws Exception;
	
	public List<Account> getAccounts() throws Exception;
	
	public List<Account> getList();
	
	
}
