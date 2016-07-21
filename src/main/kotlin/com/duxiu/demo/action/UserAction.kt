package com.duxiu.demo.action

import com.duxiu.demo.dao.users.Users
import com.duxiu.demo.dao.users.UsersDao
import org.beetl.sql.core.SQLManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@RequestMapping("/user")
@Controller
class UserAction {
	@Autowired
	lateinit var sqlManage: SQLManager
	@Suppress("SpringKotlinAutowiring")
	@Autowired
	lateinit var usersDao: UsersDao
	
	@RequestMapping("")
	@ResponseBody
	fun demo(): Users {
		return Users(18, 20, "test")
	}
	
	@RequestMapping("/page")
	fun page(): String {
		println(usersDao.fa(1))
		println("===============================")
		println( sqlManage.select("users.allUsers", Users::class.java, null).size)
		return "/index"
	}
}