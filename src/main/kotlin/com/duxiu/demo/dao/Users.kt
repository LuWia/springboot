package com.duxiu.demo.dao.users

import org.beetl.sql.core.annotatoin.Param
import org.beetl.sql.core.mapper.BaseMapper

data class Users(var uid: Long? = null, var deptid: Int? = null, var uname: String? = null)

interface UsersDao : BaseMapper<Users> {
	
	fun fa(@Param("id") id: Int): Users
}
