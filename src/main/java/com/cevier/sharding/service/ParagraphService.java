package com.cevier.sharding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cevier.sharding.pojo.Paragraph;

import java.util.Collection;

/**
 * @author: cevier.wei
 * @date: 2023/2/10 11:33
 */
public interface ParagraphService extends IService<Paragraph> {
    Collection<Paragraph> getByArticleId(long articleId);
}
