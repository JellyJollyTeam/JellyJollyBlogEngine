///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package cn.edu.seu.cose.jellyjolly.model.dao.jdbc;
//
//import cn.edu.seu.cose.jellyjolly.model.bean.BlogInfo;
//import junit.framework.TestCase;
//
///**
// *
// * @author fanTasy
// */
//public class BlogInfoDataAccessImplTest extends TestCase {
//
//    private ConnectionFactory factory;
//
//    public BlogInfoDataAccessImplTest(String testName) {
//        super(testName);
//    }
//
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//        factory = new ConnectionFactoryTestImpl();
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//    }
//
//    /**
//     * Test of getBlogInfoInstance method, of class BlogInfoDataAccessImpl.
//     */
//    public void testGetBlogInfoInstance() throws Exception {
//        System.out.println("getBlogInfoInstance");
//        BlogInfoDataAccessImpl instance = new BlogInfoDataAccessImpl(factory);
//        BlogInfo expResult = new BlogInfo();
//        expResult.setBlogId(1);
//        expResult.setBlogTitle("我的博客");
//        expResult.setBlogSubTitle("JellyJolly博客");
//        expResult.setBlogUrl("http://localhost:8084/");
//        BlogInfo result = instance.getBlogInfoInstance();
////        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setBlogTitle method, of class BlogInfoDataAccessImpl.
//     */
//    public void testSetBlogTitle() throws Exception {
//        System.out.println("setBlogTitle");
//        String title = new String("你的博客".getBytes(),"UTF-8");
//        System.out.println(title);
//        BlogInfoDataAccessImpl instance = new BlogInfoDataAccessImpl(factory);
//        instance.setBlogTitle(title);
//        assertEquals(title,instance.getBlogInfoInstance().getBlogTitle());
//        instance.setBlogTitle("我的博客");
//        //instance.setBlogTitle(new String("我的博客".getBytes(),"UTF-8"));
//    }
////
////    /**
////     * Test of setBlogSubTitle method, of class BlogInfoDataAccessImpl.
////     */
//    public void testSetBlogSubTitle() throws Exception {
//        System.out.println("setBlogSubTitle");
//        String subTitle = "this is my blog";
//        BlogInfoDataAccessImpl instance = new BlogInfoDataAccessImpl(factory);
//        instance.setBlogSubTitle(subTitle);
//        assertEquals(subTitle,instance.getBlogInfoInstance().getBlogSubTitle());
//        instance.setBlogSubTitle("JJ博客");
//    }
//    public void testSetBlogUrl() throws Exception {
//        System.out.println("setBlogUrl");
//        String blogUrl = "www.matrix.com";
//        BlogInfoDataAccessImpl instance = new BlogInfoDataAccessImpl(factory);
//        instance.setBlogUrl(blogUrl);
//        assertEquals(blogUrl,instance.getBlogInfoInstance().getBlogUrl());
//        instance.setBlogUrl("http://localhost:8084/");
//    }
////    public void testAddBlogInfoMeta() throws Exception {
////        System.out.println("addBlogInfoMeta");
////        String key = "";
////        String value = "";
////        BlogInfoDataAccessImpl instance = new BlogInfoDataAccessImpl(factory);
////        instance.addBlogInfoMeta(key, value);
////    }
//
////    /**
////     * Test of deleteBlogInfoMeta method, of class BlogInfoDataAccessImpl.
////     */
////    public void testDeleteBlogInfoMeta() throws Exception {
////        System.out.println("deleteBlogInfoMeta");
////        String key = "";
////        BlogInfoDataAccessImpl instance = new BlogInfoDataAccessImpl(factory);
////        instance.deleteBlogInfoMeta(key);
////    }
////
////    /**
////     * Test of getBlogInfoMeta method, of class BlogInfoDataAccessImpl.
////     */
////    public void testGetBlogInfoMeta() throws Exception {
//////        System.out.println("getBlogInfoMeta");
//////        String key = "";
//////        BlogInfoDataAccessImpl instance = new BlogInfoDataAccessImpl(factory);
//////        String[] expResult = null;
//////        String[] result = instance.getBlogInfoMeta(key);
//////        assertEquals(expResult, result);
////    }
////
////    /**
////     * Test of setBlogInfoMeta method, of class BlogInfoDataAccessImpl.
////     */
////    public void testSetBlogInfoMeta() throws Exception {
////        System.out.println("setBlogInfoMeta");
////        String key = "";
////        String previousValue = "";
////        String currentValue = "";
////        BlogInfoDataAccessImpl instance = new BlogInfoDataAccessImpl(factory);
////        instance.setBlogInfoMeta(key, previousValue, currentValue);
////    }
//
//}
