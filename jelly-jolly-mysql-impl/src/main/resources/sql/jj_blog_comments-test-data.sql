/*
-- Query: SELECT * FROM jellyjolly_schema.jj_blog_comments
LIMIT 0, 1000

-- Date: 2012-09-05 09:35
*/
INSERT INTO `jj_blog_comments` (`comment_id`,`parent_comment_id`,`blog_post_id`,`comment_user_author_id`,`comment_author_name`,`comment_author_email`,`comment_author_home_page_url`,`comment_date`,`comment_content`) VALUES (1,0,1,1,'季文昊','predator.ray@gmail.com','http://predatorray.sinaapp.com/','2012-09-04 12:09:00','这是一个评论实例');
INSERT INTO `jj_blog_comments` (`comment_id`,`parent_comment_id`,`blog_post_id`,`comment_user_author_id`,`comment_author_name`,`comment_author_email`,`comment_author_home_page_url`,`comment_date`,`comment_content`) VALUES (2,1,1,NULL,'标哥','foo@bar',NULL,'2012-10-04 13:10:13','白痴一样的');
INSERT INTO `jj_blog_comments` (`comment_id`,`parent_comment_id`,`blog_post_id`,`comment_user_author_id`,`comment_author_name`,`comment_author_email`,`comment_author_home_page_url`,`comment_date`,`comment_content`) VALUES (3,0,2,2,'色色','someone@example.com','http://foo.bar/','2012-10-05 18:06:00','神经病');
