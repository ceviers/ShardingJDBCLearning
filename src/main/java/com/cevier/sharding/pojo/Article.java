package com.cevier.sharding.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: cevier.wei
 * @date: 2023/2/10 11:28
 */
@Data
@TableName("article")
public class Article {
    @TableId
    private Long id;
    private String title;
    private String author;
    private Integer type;
    private LocalDateTime time;
}
