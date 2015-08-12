/**
 *  Copyright (c) 2011, AlipayPayResponseAction.java NEO and/or its affiliates. All rights reserved.
 *
 *  Licensed under the NEO License, Version 1.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package cn.effine.mapper;

import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.effine.entity.Account;
import cn.effine.mapper.AccountMapper;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * CreateTime: 2012-2-26 下午06:21:51
 * </p>
 * <p>
 * Copyright: Copyright (c) 2012 NEO-CONCEPT.COM Inc.
 * </p>
 *
 * @author zhangzehao
 * @since 1.0
 */
public class MyBatisTest {

	private static ApplicationContext context;

	private static AccountMapper mapper;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"applicationContext-common.xml");
		System.out.println(context);
		mapper = (AccountMapper) context.getBean("accountMapper");
		System.out.println(mapper);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAdd() {
		Account account = new Account();
		account.setId((long) new Random().nextInt(9999999));
		account.setName("Jack");
		mapper.addAccount(account);
	}

	@Test
	public void testRemove() {
		long id = 1219418;
		mapper.removeAccount(id);
	}

	@Test
	public void testEdit() {
		long id = 2172775;
		Account account = new Account();
		account.setId(id);
		account.setName("effine");
		mapper.editAccount(account);
	}

	@Test
	public void testGetAllAccount() {
		List<Account> list = mapper.getAllAccount();
		for(Account account: list){
			System.err.println(account.getName());
		}
	}

	@Test
	public void testGetList() {
		Account account = new Account();
		account.setId((long) new Random().nextInt(9999999));
		account.setName("Jack");
		mapper.addAccount(account);
	}
}
