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
package com.sfpay.mapper;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.effine.entity.User;
import com.effine.mapper.UserMapper;

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
public class UserTest {

	private static ApplicationContext context;

	private static UserMapper mapper;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"applicationContext-common.xml");
		System.out.println(context);
		mapper = (UserMapper) context.getBean("userMapper");
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
		User user = new User();
		user.setId(new Random().nextInt(9999999));
		user.setName("effine");
		mapper.addUser(user);
		;
	}
	
	@Test
	public void testGet() {
		User user = mapper.getUserById(1);
		System.err.println(user);
	}

}
