package com.cevier.sharding.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cevier.sharding.mapper.ArticleMapper;
import com.cevier.sharding.pojo.Article;
import org.springframework.stereotype.Service;

/**
 * @author: cevier.wei
 * @date: 2023/2/10 11:33
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}