package UserTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.project.ssh.domain.User;
import com.project.ssh.service.UserService;
import com.project.ssh.service.Impl.UserServiceImpl;

public class UserServiceTest {

	UserService userservice = null;
	
	@Before
	public void setUp(){
		userservice = new UserServiceImpl();
	}
	
//	@Test
//	public void testRegistUser() {
//		
//		User user = new User();
//		
//		user.setUserId("aaaa");
//		user.setUserName("ffff");
//		user.setPassword("1234");
//		user.setEmail("fffff@fffff.com");
//		user.setPhone("01012349123");
//		user.setAddress("ㄷㄹㄷㄹㄷ");
//		
//		userservice.registUser(user);
//	}
//
//	@Test
//	public void testModifyUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindUser() {
//		User user = userservice.findUser("taein");
//		System.out.println(user.getUserName());
//	}
//
//	@Test
//	public void testRemoveUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindUserByName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindUserById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindUserByBlack() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testWarnUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUserLock() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUserUnlock() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testLogin() {
		
		System.out.println(userservice.login("taein", "4321"));
	}

//	@Test
//	public void testMail() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testPush() {
//		fail("Not yet implemented");
//	}

}
