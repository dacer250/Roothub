package priv.sen.root.serviceImpl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.roothub.dto.UserExecution;
import cn.roothub.entity.User;
import cn.roothub.entity.Top100;
import cn.roothub.service.UserService;
import priv.sen.root.dao.test.BaseTest;

public class UserServiceImplTest extends BaseTest{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService rootUserService;
	
	/**
	 * 测试注册用户
	 * @throws Exception
	 */
	@Test
	public void userSaveTest() throws Exception{
		User rootUser = new User();
		rootUser.setUserName("ruqin");
		rootUser.setPassword("123456");
		rootUser.setUserSex("男");
		rootUser.setUserAddr("长沙");
		rootUser.setScore(100);
		rootUser.setAvatar("无");
		rootUser.setEmail("123456@qq.com");
		rootUser.setUrl("www.baidu.com");
		rootUser.setSignature("哈哈");
		rootUser.setThirdId("1158827539");
		rootUser.setReceiveMsg(false);
		rootUser.setCreateDate(new Date());
		rootUser.setUpdateDate(new Date());
		rootUser.setIsBlock(false);
		rootUser.setStatusCd("1000");
		rootUser.setLoginIp("127.0.1");
		rootUser.setLastLoginIp("127.0.1");
		rootUser.setUserType("0");
		UserExecution save = rootUserService.save(rootUser);
		logger.debug(save.toString());
	}
	
	/**
	 * 测试更新用户
	 */
	@Test
	public void updateUserTest() throws Exception{
		User rootUser = new User();
		rootUser.setUserId(8);
		rootUser.setUserName("ruqin");
		rootUser.setPassword("000000");
		rootUser.setUserSex("女");
		rootUser.setUserAddr("武汉");
		rootUser.setScore(10);
		rootUser.setAvatar("无");
		rootUser.setEmail("12233444");
		rootUser.setUrl("33333");
		rootUser.setSignature("哈哈哈哈");
		rootUser.setThirdId("789");
		rootUser.setReceiveMsg(true);
		rootUser.setUpdateDate(new Date());
		rootUser.setStatusCd("1000");
		UserExecution updateUser = rootUserService.updateUser(rootUser);
		logger.debug(updateUser.toString());
	}
	
	/**
	 * 积分榜用户
	 * @throws Exception
	 */
	@Test
	public void scores() throws Exception{
		List<Top100> scores = rootUserService.scores(100);
		logger.debug(scores.toString());
	}
	
	/**
	 * 更新积分
	 * @throws Exception
	 */
	@Test
	public void updateScore() throws Exception{
		rootUserService.updateScore(2, 1);
	}
	
	@Test
	public void test01() throws Exception{
		List list = new ArrayList<>();
		list.add("aa");
		list.add("bbb");
		String object = (String) list.get(0);
		logger.debug(object);
		logger.debug(list.toString());
	}
	
	@Test
	public void countScoreTest() throws Exception{
		int countScore = rootUserService.countScore(1);
		System.out.println(countScore);
	}
}
