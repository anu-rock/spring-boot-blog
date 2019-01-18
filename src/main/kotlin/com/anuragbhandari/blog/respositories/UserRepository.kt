package com.anuragbhandari.blog.respositories

import com.anuragbhandari.blog.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String>