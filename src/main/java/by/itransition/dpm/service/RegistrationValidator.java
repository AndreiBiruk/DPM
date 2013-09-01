package by.itransition.dpm.service;

import java.util.ArrayList;
import java.util.List;

import by.itransition.dpm.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.itransition.dpm.dao.UserDao;
import by.itransition.dpm.entity.User;

@Service
public class RegistrationValidator {

    @Autowired
    private UserDao userDao;

    private User user;
    private String confirmPassword;

    public final static String EMPTY_LOGIN = "emptyLogin";
    public final static String EMPTY_PASSWORD = "emptyPassword";
    public final static String PASSWORD_IS_NOT_CONFIRMED = "confirmPassword";
    public final static String USER_EXIST = "userExist";
    public final static String INVALID_MAIL = "invalidMail";
    public final static String NOT_USER = "invalidUserObject";

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setConfirmPassword(String confirmPassword){
        this.confirmPassword = confirmPassword;
    }

    @Transactional
    public List<String> getErrorList(){
        List<String> errorList = new ArrayList<>();
        if (isInvalidUser()){
            errorList.add(NOT_USER);
            return errorList;
        }
        if (isLoginEmpty()){
            errorList.add(EMPTY_LOGIN);
        }
        if (isPasswordEmpty()){
            errorList.add(EMPTY_PASSWORD);
        }
        if (!isPasswordConfirmed()){
            errorList.add(PASSWORD_IS_NOT_CONFIRMED);
        }
        if (isUserExist()){
            errorList.add(USER_EXIST);
        }
        if (!isMailValid()){
            errorList.add(INVALID_MAIL);
        }
        return errorList;
    }

    public boolean isInvalidUser(){
        return !(user instanceof User)||user.getUsername()==null||user.getPassword()==null||user.getEmail()==null;
    }

    public boolean isLoginEmpty(){
        return user.getUsername().length() == 0;
    }

    public boolean isPasswordEmpty(){
        return user.getPassword().length() == 0;
    }

    public boolean isPasswordConfirmed(){
        return user.getPassword().equals(confirmPassword);
    }

    @Transactional
    public boolean isUserExist(){
        return userDao.getUserByLogin(user.getUsername()) != null;
    }

    public boolean isMailValid(){
        return (user.getEmail().indexOf('@') >= 0)
                && (user.getEmail().indexOf('@') == user.getEmail().lastIndexOf('@'))
                && (user.getEmail().indexOf('@') < user.getEmail().lastIndexOf('.'))
                && (user.getEmail().length() >= 5)
                ;

    }
}
