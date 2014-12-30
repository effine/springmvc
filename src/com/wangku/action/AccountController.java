package com.wangku.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wangku.entity.Account;
import com.wangku.service.IAccountService;

@Controller
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	@RequestMapping("add")
	public String addAccount(Account acc) throws Exception {
		accountService.addAccount(acc);
		return "redirect:/account/list.shtml";
	}
	
	@RequestMapping("del")
	public String del(Account acc) throws Exception {
		accountService.addAccount(acc);
		return "redirect:/account/list.shtml";
	}
	
	@RequestMapping("get")
	public String get(Long id, Model model) throws Exception {
		System.out.println("##ID:" + id);
		model.addAttribute(accountService.getAccount(id));
		return "/show.jsp";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", accountService.getList());
		return "/list.jsp";
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "/error.jsp";
	}
}
