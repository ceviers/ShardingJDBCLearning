package com.cevier.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cevier.sharding.pojo.Paragraph;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * @author: cevier.wei
 * @date: 2023/2/10 13:41
 */
public interface ParagraphMapper extends BaseMapper<Paragraph> {
    Collection<Paragraph> getByArticleId(@Param("articleId") long articleId);
}
