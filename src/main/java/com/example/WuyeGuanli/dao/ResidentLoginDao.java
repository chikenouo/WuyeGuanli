package com.example.WuyeGuanli.dao;

import com.example.WuyeGuanli.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ResidentLoginDao {
    @Select("select id, identity_number, password, name, role, is_currently_residing from users where identity_number = #{identityNumber} and password = #{password}")
    User selectByUsernameAndPassword(User user);

    @Select("select id, identity_number, password, name, role, is_currently_residing from users where identity_number = #{identityNumber}")
    User selectByIdentityNumber(String identityNumber);
}
