package com.cevier.sharding.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: cevier.wei
 * @date: 2023/2/10 11:28
 */
@Data
@TableName("paragraph")
@AllArgsConstructor
@NoArgsConstructor
public class Paragraph {
    @TableId
    private Long id;
    private String content;
    private Long articleId;
}
