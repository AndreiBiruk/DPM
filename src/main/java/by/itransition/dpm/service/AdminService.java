package by.itransition.dpm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.itransition.dpm.dao.UserDao;
import by.itransition.dpm.entity.User;

import java.util.List;

@Service
public class AdminService {
	
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	@Transactional
	public List<User> getRoleUserList(){
		return userDao.getAllUsers();
	}
}

