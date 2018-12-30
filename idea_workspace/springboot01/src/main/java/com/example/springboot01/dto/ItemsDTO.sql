-- auto Generated on 2018-12-08 00:16:09 
-- DROP TABLE IF EXISTS `items_d_t_o`; 
CREATE TABLE items_d_t_o(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `todo_item_id` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'todoItemId',
    `user_id` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'userId',
    `todo_item_title` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'todoItemTitle',
    `todo_item_content` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'todoItemContent',
    `priority` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'priority',
    `creation_date` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'creationDate',
    `last_update_date` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'lastUpdateDate',
    `comments` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'comments',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'items_d_t_o';
