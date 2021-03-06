package com.pizssn.sl.dao;

import com.pizssn.sl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//由于使用了 JPA，无需手动构建 SQL 语句，而只需要按照规范提供方法的名字即可实现对数据库的增删改查。
public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);
}
