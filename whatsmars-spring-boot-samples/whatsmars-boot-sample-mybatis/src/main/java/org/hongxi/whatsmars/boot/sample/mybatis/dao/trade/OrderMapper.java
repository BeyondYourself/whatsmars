package org.hongxi.whatsmars.boot.sample.mybatis.dao.trade;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.hongxi.whatsmars.boot.sample.mybatis.domain.User;

import java.util.List;

/**
 * Created by shenhongxi on 2017/6/26.
 */
public interface OrderMapper {

    void createIfNotExistsTable();

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    void insert(User user);

    void insertBatch(List<User> users);

    List<User> query();

    void update(User user);

    void delete(Long id);

    List<User> findByNicknameAndGender(@Param("nickname") String nickname, @Param("gender") Integer gender);

}
