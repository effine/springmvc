package cn.effine.mapper;

import java.util.List;

import cn.effine.entity.Account;

public interface AccountMapper {
	
	public List<Account> getAllAccount();
	
	public Account getAccount();
	
	public Account getAccountById(Long id);
	
	public Account getAccountByNames(String spring);
	
	public Account getAccountByName(String name);
	
	public void addAccount(Account account);
	
	public void editAccount(Account account);
	
	public void removeAccount(Long id);
}
