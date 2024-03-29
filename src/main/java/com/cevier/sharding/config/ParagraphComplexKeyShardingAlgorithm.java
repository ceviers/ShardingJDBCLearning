package com.cevier.sharding.config;

import com.cevier.sharding.pojo.Article;
import com.cevier.sharding.service.ArticleService;
import com.cevier.sharding.utils.SpringUtils;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 复合分片算法
 * 目前处理 = 和 in 操作，其余的操作，比如 >、< 等不支持。
 * @author: cevier.wei
 * @date: 2023/2/10 14:15
 */
@Component
public class ParagraphComplexKeyShardingAlgorithm implements ComplexKeysShardingAlgorithm<BigDecimal> {

    private static final String COLUMN_ARTICLE_ID = "article_id";

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<BigDecimal> complexKeysShardingValue) {
        if (!complexKeysShardingValue.getColumnNameAndRangeValuesMap().isEmpty()) {
            throw new RuntimeException("不支持除了=和in的操作");
        }

        // article_id
        var articleService = SpringUtils.getBean(ArticleService.class);
        Collection<BigDecimal> articleId = complexKeysShardingValue.getColumnNameAndShardingValuesMap().getOrDefault(COLUMN_ARTICLE_ID, new ArrayList<>(1));
        var articles = articleService.lambdaQuery().in(Article::getId, articleId).list();
        if (CollectionUtils.isEmpty(articles)) {
            return null;
        }

        LocalDateTime sixMonthBefore = LocalDateTime.now().minusMonths(6);

        return articles.stream()
                .filter(Objects::nonNull)
                .map(Article::getTime)
                .distinct()
                .map(time -> sixMonthBefore.compareTo(time) > 0 ? "0" : "1")
                .map(tableSuffix -> availableTargetNames.stream().filter(targetName -> targetName.endsWith(tableSuffix)).findFirst().orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
//
//    public Collection<String> doSharding2(Collection<String> availableTargetNames, ComplexKeysShardingValue<BigDecimal> shardingValue) {
//        if (!shardingValue.getColumnNameAndRangeValuesMap().isEmpty()) {
//            throw new RuntimeException("不支持除了=和in的操作");
//        }
//
//        // 获取订单id
//        Collection<BigDecimal> orderIds = shardingValue.getColumnNameAndShardingValuesMap().getOrDefault(COLUMN_ORDER_ID, new ArrayList<>(1));
//        // 获取客户id
//        Collection<BigDecimal> customerIds = shardingValue.getColumnNameAndShardingValuesMap().getOrDefault(COLUMN_CUSTOMER_ID, new ArrayList<>(1));
//
//        // 整合订单id和客户id
//        List<String> ids = new ArrayList<>(16);
//        ids.addAll(ids2String(orderIds));
//        ids.addAll(ids2String(customerIds));
//
//        return ids.stream()
//                // 截取 订单号或客户id的后2位
//                .map(id -> id.substring(id.length() - 2))
//                // 去重
//                .distinct()
//                // 转换成int
//                .map(Integer::new)
//                // 对可用的表名求余数，获取到真实的表的后缀
//                .map(idSuffix -> idSuffix % availableTargetNames.size())
//                // 转换成string
//                .map(String::valueOf)
//                // 获取到真实的表
//                .map(tableSuffix -> availableTargetNames.stream().filter(targetName -> targetName.endsWith(tableSuffix)).findFirst().orElse(null))
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//    }


}
