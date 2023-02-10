CREATE TABLE `article` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文章标题',
  `author` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作者',
  `type` int DEFAULT NULL COMMENT '文章类型：1技术，2文学，3其它',
  `time` datetime DEFAULT NULL COMMENT '发表时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `paragraph` (
  `id` bigint NOT NULL COMMENT '主键',
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '段落内容',
  `article_id` bigint DEFAULT NULL COMMENT '所属文章ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `paragraph_0` (
  `id` bigint NOT NULL COMMENT '主键',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '段落内容',
  `article_id` bigint DEFAULT NULL COMMENT '所属文章ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `paragraph_1` (
  `id` bigint NOT NULL COMMENT '主键',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '段落内容',
  `article_id` bigint DEFAULT NULL COMMENT '所属文章ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `paragraph` (
  `id` bigint NOT NULL COMMENT '主键',
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '段落内容',
  `article_id` bigint DEFAULT NULL COMMENT '所属文章ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;