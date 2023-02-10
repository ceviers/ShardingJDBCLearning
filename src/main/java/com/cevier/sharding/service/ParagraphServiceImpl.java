package com.cevier.sharding.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cevier.sharding.mapper.ParagraphMapper;
import com.cevier.sharding.pojo.Paragraph;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author: cevier.wei
 * @date: 2023/2/10 11:33
 */
@Service
public class ParagraphServiceImpl extends ServiceImpl<ParagraphMapper, Paragraph> implements ParagraphService {
    @Override
    public Collection<Paragraph> getByArticleId(long articleId) {
        return this.baseMapper.getByArticleId(articleId);
    }
}