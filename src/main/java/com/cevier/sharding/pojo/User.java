package com.cevier.sharding.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: cevier.wei
 * @date: 2023/2/10 11:28
 */
@Data
@TableName("user")
public class User {
    @TableId
    private Long id;
    private String name;
    private String email;
}
