///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.edu.seu.cose.jellyjolly.model.dao.jdbc;
//
//import cn.edu.seu.cose.jellyjolly.model.bean.BlogPage;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import junit.framework.TestCase;
//
///**
// *
// * @author zc
// */
//public class BlogPageDataAccessImplTest extends TestCase {
//
//    private ConnectionFactory factory;
//
//    public BlogPageDataAccessImplTest(String testName) {
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
//     * Test of getPageTitleList method, of class BlogPageDataAccessImpl.
//     */
//    public void testGetPageTitleList() throws Exception {
//        System.out.println("getPageTitleList");
//        BlogPageDataAccessImpl instance = new BlogPageDataAccessImpl(factory);
//        List<String> expResult = new LinkedList();
//        expResult.add("关于");
//        List<String> result = instance.getPageTitleList();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getPageTitleMap method, of class BlogPageDataAccessImpl.
//     */
////    public void testGetPageTitleMap() throws Exception {
////        System.out.println("getPageTitleMap");
////        BlogPageDataAccessImpl instance = null;
////        Map expResult = null;
////        Map result = instance.getPageTitleMap();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of getAllPages method, of class BlogPageDataAccessImpl.
//     */
//    public void testGetAllPages() throws Exception {
//        System.out.println("getAllPages");
//        BlogPageDataAccessImpl instance = new BlogPageDataAccessImpl(factory);
//        List<BlogPage> expResult = new LinkedList();
//        BlogPage page = new BlogPage();
//        page.setPageTitle("关于");
//        expResult.add(page);
//        List<BlogPage> result = instance.getAllPages();
//        assertEquals(expResult.get(0).getPageTitle(), result.get(0).getPageTitle());
//    }
//
//    /**
//     * Test of getPage method, of class BlogPageDataAccessImpl.
//     */
//    public void testGetPage() throws Exception {
//        System.out.println("getPage");
//        int pageId = 1;
//        BlogPageDataAccessImpl instance = new BlogPageDataAccessImpl(factory);
//        BlogPage expResult = new BlogPage();
//        expResult.setPageTitle("关于");
//        String exp = expResult.getPageTitle();
//        BlogPage result = instance.getPage(pageId);
//        assertEquals(exp, result.getPageTitle());
//    }
//
//    /**
//     * Test of addNewPage method, of class BlogPageDataAccessImpl.
//     */
//    public void testAddNewPage_BlogPage() throws Exception {
//        System.out.println("addNewPage");
//        BlogPage page = new BlogPage();
//        page.setPageTitle("SB");
//        BlogPageDataAccessImpl instance = new BlogPageDataAccessImpl(factory);
//        instance.addNewPage(page);
//        assertEquals("SB",instance.getPage(2).getPageTitle());
//        instance.deletePage(2);
//    }
//
//    /**
//     * Test of addNewPage method, of class BlogPageDataAccessImpl.
//     */
//    public void testAddNewPage_String_String() throws Exception {
//        System.out.println("addNewPage");
//        String title = "sb";
//        String content = "you r sb";
//        BlogPageDataAccessImpl instance = new BlogPageDataAccessImpl(factory);
//        instance.addNewPage(title, content);
//        assertEquals("sb",instance.getPage(2).getPageTitle());
//        assertEquals("you r sb",instance.getPage(2).getPageContent());
//        instance.deletePage(2);
//    }
//
//    /**
//     * Test of changeTitle method, of class BlogPageDataAccessImpl.
//     */
//    public void testChangeTitle() throws Exception {
//        System.out.println("changeTitle");
//        int pageId = 1;
//        String title = "About";
//        BlogPageDataAccessImpl instance = new BlogPageDataAccessImpl(factory);
//        instance.changeTitle(pageId, title);
//        assertEquals("about",instance.getPage(1).getPageTitle());
//        instance.changeTitle(pageId,"关于");
//    }
//
//    /**
//     * Test of changeContent method, of class BlogPageDataAccessImpl.
//     */
//    public void testChangeContent() throws Exception {
//        System.out.println("changeContent");
//        int pageId = 1;
//        String content = "日天是个sb！";
//        BlogPageDataAccessImpl instance = new BlogPageDataAccessImpl(factory);
//        instance.changeContent(pageId, content);
//        assertEquals("日天是个sb！",instance.getPage(1).getPageContent());
//        instance.changeContent(pageId, "日天是个sb！");
//        instance.changeContent(pageId, "rt sb");
//    }
//
//    /**
//     * Test of editPage method, of class BlogPageDataAccessImpl.
//     */
////    public void testEditPage() throws Exception {
////        System.out.println("editPage");
////        BlogPage page = null;
////        BlogPageDataAccessImpl instance = null;
////        instance.editPage(page);
////    }
////
////    /**
////     * Test of deletePage method, of class BlogPageDataAccessImpl.
////     */
////    public void testDeletePage() throws Exception {
////        System.out.println("deletePage");
////        int pageId = 0;
////        BlogPageDataAccessImpl instance = null;
////        instance.deletePage(pageId);
////    }
////
////    /**
////     * Test of getPageNumber method, of class BlogPageDataAccessImpl.
////     */
////    public void testGetPageNumber() throws Exception {
////        System.out.println("getPageNumber");
////        BlogPageDataAccessImpl instance = null;
////        int expResult = 0;
////        int result = instance.getPageCount();
////        assertEquals(expResult, result);
////    }
//}
