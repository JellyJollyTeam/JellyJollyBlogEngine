//package cn.edu.seu.cose.jellyjolly.model.dao.jdbc;
//
//import cn.edu.seu.cose.jellyjolly.model.bean.AdminUser;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.LinkedList;
//import java.util.List;
//import junit.framework.TestCase;
//
///**
// *
// * @author fanTasy
// */
//public class AdminUserDataAccessImplTest extends TestCase {
//
//    private ConnectionFactory factory;
//
//    public AdminUserDataAccessImplTest(String testName) {
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
//     * Test of confirm method, of class AdminUserDataAccessImpl.
//     */
//    public void testConfirm() throws Exception {
//        System.out.println("confirm");
//        {
//            String username = "one";
//            String password = "123";
//            AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//            boolean expResult = true;
//            boolean result = instance.confirm(username, password);
//            assertEquals(expResult, result);
//        }
//        {
//            String username = "two";
//            String password = "123";
//            AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//            boolean expResult = false;
//            boolean result = instance.confirm(username, password);
//            assertEquals(expResult, result);
//        }
//        {
//            String username = "one";
//            String password = "321";
//            AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//            boolean expResult = false;
//            boolean result = instance.confirm(username, password);
//            assertEquals(expResult, result);
//        }
//        {
//            String username = "two";
//            String password = "321";
//            AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//            boolean expResult = false;
//            boolean result = instance.confirm(username, password);
//            assertEquals(expResult, result);
//        }
//    }
//
//    /**
//     * Test of getUserIfConfirmed method, of class AdminUserDataAccessImpl.
//     */
//    public void testGetUserIfConfirmed() throws Exception {
//        System.out.println("getUserIfConfirmed");
//        AdminUser expResult = new AdminUser();
//        /*
//         * Define a instance of AdminUser
//         */
//        expResult.setUserId(2);
//        expResult.setUsername("one");
//        expResult.setPassword("123");
//        expResult.setDisplayName("标哥");
//        expResult.setEmail("123@321.com");
//        expResult.setHomePageUrl(null);
//        DateFormat format = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
//        String time1 = "2012-9-5 09:15:30";
//        String time2 = "2012-9-5 09:30:30";
//        Date date1 = format.parse(time1);
//        Date date2 = format.parse(time2);
//        expResult.setRegisterTime(date1);
//        expResult.setLastLoginTime(date2);
//        //test
//        {
//            String username = "one";
//            String password = "123";
//            AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//            AdminUser result = instance.getUserIfConfirmed(username, password);
//            assertEquals(expResult.getUserId(), result.getUserId());
//        }
//        {
//            String username = "one";
//            String password = "321";
//            AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//            AdminUser result = instance.getUserIfConfirmed(username, password);
//            assertEquals(null, result);
//        }
//        {
//            String username = "two";
//            String password = "123";
//            AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//            AdminUser result = instance.getUserIfConfirmed(username, password);
//            assertEquals(null, result);
//        }
//        {
//            String username = "two";
//            String password = "321";
//            AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//            AdminUser result = instance.getUserIfConfirmed(username, password);
//            assertEquals(null, result);
//        }
//    }
//
//    /**
//     * Test of getUser method, of class AdminUserDataAccessImpl.
//     */
//    public void testGetUser() throws Exception {
//        System.out.println("getUser");
//        AdminUser expResult = new AdminUser();
//        expResult.setUsername("admin");
//        {
//            long userId = 1;
//            AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//            AdminUser result = instance.getUser(userId);
//            assertEquals(expResult.getUsername(), result.getUsername());
//        }
//        {
//            long userId = 2;
//            AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//            AdminUser result = instance.getUser(userId);
//            assertEquals("one", result.getUsername());
//        }
//    }
//
//    /**
//     * Test of getAllUsers method, of class AdminUserDataAccessImpl.
//     */
//    public void testGetAllUsers() throws Exception {
//        System.out.println("getAllUsers");
//        List<AdminUser> expResult = new LinkedList<AdminUser>();
//        AdminUser user1 = new AdminUser();
//        AdminUser user2 = new AdminUser();
//        AdminUser user3 = new AdminUser();
//        user1.setUserId(1);
//        user2.setUserId(2);
//        user3.setUserId(3);
//        expResult.add(user1);
//        expResult.add(user2);
//        expResult.add(user3);
//        AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//        List<AdminUser> result = instance.getAllUsers();
//        for(int i = 0; i <= 2; i++){
//            assertEquals(expResult.get(i).getUserId(),result.get(i).getUserId());
//        }
//    }
//
//    /**
//     * Test of addNewUser method, of class AdminUserDataAccessImpl.
//     */
//    public void testAddNewUser_AdminUser() throws Exception {
//        System.out.println("addNewUser");
//        AdminUser expResult = new AdminUser();
//        expResult.setUsername("sb");
//        expResult.setPassword("woshisb");
//        expResult.setEmail("coldchar@123.com");
//        expResult.setHomePageUrl("http://coldchar.sb.com");
//        expResult.setDisplayName("coldChar");
//        expResult.setLastLoginTime(new Date());
//        expResult.setRegisterTime(new Date());
//        AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//        AdminUser result = instance.addNewUser(expResult);
//        assertEquals(expResult.getUsername(), result.getUsername());
//        instance.deleteUser(result.getUserId());
//    }
//
//    /**
//     * Test of addNewUser method, of class AdminUserDataAccessImpl.
//     */
//    public void testAddNewUser_5args() throws Exception {
//        System.out.println("addNewUser");
//        String username = "coldx";
//        String password = "1";
//        String email = "coldx@123.com";
//        String displayName = "coldx2";
//        Date registerTime = new Date();
//        AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//        AdminUser expResult = new AdminUser();
//        expResult.setUsername(username);
//        expResult.setPassword(password);
//        expResult.setDisplayName(displayName);
//        expResult.setEmail(email);
//        expResult.setRegisterTime(registerTime);
//        AdminUser result = instance.addNewUser(username, password, email, displayName, registerTime);
//        assertEquals(expResult.getUsername(), result.getUsername());
//        instance.deleteUser(result.getUserId());
//    }
//
//    /**
//     * Test of addNewUser method, of class AdminUserDataAccessImpl.
//     */
//    public void testAddNewUser_6args() throws Exception {
//        System.out.println("addNewUser");
//        String username = "coldx";
//        String password = "1";
//        String email = "coldx@123.com";
//        String homePageUrl = "http://coldx2.123.com";
//        String displayName = "coldx2";
//        Date registerTime = new Date();
//        AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//        AdminUser expResult = new AdminUser();
//        expResult.setUsername(username);
//        expResult.setPassword(password);
//        expResult.setHomePageUrl(homePageUrl);
//        expResult.setDisplayName(displayName);
//        expResult.setEmail(email);
//        expResult.setRegisterTime(registerTime);
//        AdminUser result = instance.addNewUser(username, password, email, homePageUrl, displayName, registerTime);
//        assertEquals(expResult.getUsername(), result.getUsername());
//        instance.deleteUser(result.getUserId());
//    }
//
//    /**
//     * Test of updateUser method, of class AdminUserDataAccessImpl.
//     */
//    public void testUpdateUser() throws Exception {
//        System.out.println("updateUser");
//        String username = "coldx";
//        String password = "1";
//        String email = "coldx@123.com";
//        String homePageUrl = "http://coldx2.123.com";
//        String displayName = "coldx2";
//        AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//        AdminUser pUser = instance.getUser(1);
//        String pDisplayName = pUser.getDisplayName();
//        pUser.setDisplayName("艾斯比");
//        instance.updateUser(pUser);
////        AdminUser cUser = instance.getUser(1);
////        assertEquals(cUser.getDisplayName(), "艾斯比");
////        assertNotSame(cUser.getDisplayName(), pDisplayName);
//        pUser.setDisplayName("admin");
//        instance.updateUser(pUser);
//    }
//
//    /**
//     * Test of changeUserName method, of class AdminUserDataAccessImpl.
//     */
//    public void testChangeUserName() throws Exception {
//        System.out.println("changeUserName");
//        long userId = 1;
//        String username = "rtsb";
//        AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
//        boolean expResult = true;
//        boolean result = instance.changeUserName(userId, username);
//        assertEquals(expResult, result);
//        assertNotSame(username,instance.getUser(userId).getUsername());
//        instance.changeUserName(userId, "admin");
//    }
//
//    /**
//     * Test of changePassword method, of class AdminUserDataAccessImpl.
//     */
//    public void testChangePassword() throws Exception {
////        System.out.println("changePassword");
////        long userId = 1;
////        String password = "111";
////        AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
////        instance.changePassword(userId, password);
////        assertEquals(password,instance.getUser(userId).getPassword());
////        instance.changePassword(userId,"admin");
//    }
//
//    /**
//     * Test of setLastLoginTime method, of class AdminUserDataAccessImpl.
//     */
//    public void testSetLastLoginTime() throws Exception {
////        System.out.println("setLastLoginTime");
////        long userId = 0L;
////        Date date = null;
////        AdminUserDataAccessImpl instance = null;
////        instance.setLastLoginTime(userId, date);
//    }
//
//    /**
//     * Test of deleteUser method, of class AdminUserDataAccessImpl.
//     */
//    public void testDeleteUser() throws Exception {
////        System.out.println("deleteUser");
////        long userId = 1;
////        AdminUserDataAccessImpl instance = new AdminUserDataAccessImpl(factory,new AdminUserMetaDataAccess(factory));
////        instance.deleteUser(userId);
////        assertNull(instance.getUser(userId));
//////        AdminUser pUser = new AdminUser();
//////        pUser.setUserId(1);
//////        pUser.setDisplayName("季文昊");
//////        pUser.setUsername("admin");
//////        pUser.setEmail("111@222.com");
//////        pUser.setRegisterTime(new Date());
//////        pUser.setLastLoginTime(new Date());
//////        pUser.setPassword("admin");
//////        instance.addNewUser(pUser);
//    }
//
//    /**
//     * Test of getUserProperties method, of class AdminUserDataAccessImpl.
//     */
//    public void testGetUserProperties() throws Exception {
////        System.out.println("getUserProperties");
////        long userId = 0L;
////        AdminUserDataAccessImpl instance = null;
////        Map expResult = null;
////        Map result = instance.getUserProperties(userId);
////        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of addUserProperty method, of class AdminUserDataAccessImpl.
//     */
//    public void testAddUserProperty() throws Exception {
////        System.out.println("addUserProperty");
////        long userId = 0L;
////        String key = "";
////        String[] values = null;
////        AdminUserDataAccessImpl instance = null;
////        instance.addUserProperty(userId, key, values);
//    }
//
//    /**
//     * Test of deleteUserProperty method, of class AdminUserDataAccessImpl.
//     */
//    public void testDeleteUserProperty() throws Exception {
////        System.out.println("deleteUserProperty");
////        long userId = 0L;
////        String key = "";
////        AdminUserDataAccessImpl instance = null;
////        instance.deleteUserProperty(userId, key);
//    }
//
//    /**
//     * Test of clearUserProperty method, of class AdminUserDataAccessImpl.
//     */
//    public void testClearUserProperty() throws Exception {
////        System.out.println("clearUserProperty");
////        long userId = 0L;
////        AdminUserDataAccessImpl instance = null;
////        instance.clearUserProperty(userId);
//    }
//}
