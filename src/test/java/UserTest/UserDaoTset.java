package UserTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.project.ssh.dao.UserDao;
import com.project.ssh.dao.Impl.UserDaoImpl;
import com.project.ssh.domain.Device;
import com.project.ssh.domain.ElectronData;
import com.project.ssh.service.ElectronDataService;
import com.project.ssh.service.Impl.ElectronDataServiceImpl;

public class UserDaoTset {
	ElectronDataService electronDataService = null;
	
	UserDao userdao = null;
	
	@Before
	public void setup(){
		userdao = new UserDaoImpl();
		electronDataService = new ElectronDataServiceImpl();
	}
	

//	@Test
//	public void testCreateUser() {
//		User user = new User();
//		
//		user.setUserId("aaaa");
//		user.setUserName("ffff");
//		user.setPassword("1234");
//		user.setEmail("fffff@fffff.com");
//		user.setPhone("01012349123");
//		user.setAddress("ㄷㄹㄷㄹㄷ");
//		
//		System.out.println(userdao.createUser(user));
//	}

//	@Test
//	public void testUpdateUser() {
//			User user = new User();
//			
//			user.setUserId("aaaa");
//			user.setPassword("4312");
//			user.setEmail("aaaaa@fffff.com");
//			user.setPhone("01012349123");
//			user.setAddress("ㄷㄹㄷㄹㄷ");
//			
//			System.out.println(userdao.updateUser(user));
//	}

//	@Test
//	public void testRetrieveUser() {
//		User user = userdao.retrieveUser("aaaa");
//		
//		System.out.println(user.getUserName());
//	}

//	@Test
//	public void testDeleteUser() {
//		System.out.println(userdao.deleteUser("ffff"));
//	}

//	@Test
//	public void testRetrieveUserByName() {
//		List<User> userlist = userdao.retrieveUserByName("니", "N");
//
//		for(User user : userlist){
//			System.out.println(user.getUserId());
//		}
//		
//	}

//	@Test
//	public void testRetrieveUserById() {
//		List<User> userlist = userdao.retrieveUserById("do","N");
//
//		for(User user : userlist){
//			System.out.println(user.getUserName());
//		}
//	}

//	@Test
//	public void testRetrieveUserByBlack() {
//		List<User> userlist = userdao.retrieveUserByBlack("Y");
//
//		for(User user : userlist){
//			System.out.println(user.getUserName());
//		}
//	}

//	@Test
//	public void testWarnUser() {
//		User user = userdao.retrieveUser("hyunwoo");
//		System.out.println("증가 전 : " + user.getWarnCnt());
//		
//		
//		userdao.warnUser("hyunwoo");
//		User user2 = userdao.retrieveUser("hyunwoo");
//		System.out.println("증가 후 : " + user2.getWarnCnt());
//	}

//	@Test
//	public void testUserLock() {
//		User user = userdao.retrieveUser("aaaa");
//		System.out.println(user.getBlacklist());
//		userdao.userLock("aaaa");
//		
//		User user2 = userdao.retrieveUser("aaaa");
//		System.out.println(user2.getBlacklist());
//	}

	/*@Test
	public void testUserUnlock() {
		User user = userdao.retrieveUser("aaaa");
		System.out.println(user.getBlacklist());
		userdao.userUnlock("aaaa");
		
		User user2 = userdao.retrieveUser("aaaa");
		System.out.println(user2.getBlacklist());
	}*/
	
	@Test
	public void testUncheckedData(){
		List<ElectronData> datas = new ArrayList<ElectronData>();
		datas.addAll(electronDataService.retrieveUncheckedData("49004c000351353337353037"));
		System.out.println(datas.size());
	}

}
