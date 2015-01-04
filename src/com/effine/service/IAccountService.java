package com.effine.service;

import java.util.List;

import com.effine.entity.Account;

public interface IAccountService {

	public boolean addAccount(Account entity) throws Exception;
	
	public Account getAccount(Long id) throws Exception;
	
	public List<Account> getAccounts() throws Exception;
	
	public List<Account> getList();
}
