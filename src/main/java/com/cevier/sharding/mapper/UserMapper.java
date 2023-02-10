package com.cevier.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cevier.sharding.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author: cevier.wei
 * @date: 2023/2/10 11:32
 */
public interface UserMapper extends BaseMapper<User> {
    String getUserByName(@Param("name") String name);
}
