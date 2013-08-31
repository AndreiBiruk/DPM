package by.itransition.dpm.service;

import by.itransition.dpm.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.itransition.dpm.dao.UserDao;
import by.itransition.dpm.entity.User;

@Service
public class Activation {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public static String generateActivationCode(User user){
        StringBuffer code = new StringBuffer();
        for(char c : user.getLogin().toLowerCase().toCharArray() ){
            code.append((int)c - 87);
        }
        return new String(code);
    }

    /**
     * Decodes activation code and returns username of proper user.
     * @param code
     * @return username
     */
    public static String decodeActivationCode(String code){
        StringBuffer username = new StringBuffer();
        for(int i=0; i < code.length(); i+=2){
            username.append((char)(Integer.valueOf(code.substring(i, i+2)).intValue()+87));
        }
        return new String(username);
    }

    @Transactional
    public boolean activateUserByCode(String code){
        return activateUserByLogin(decodeActivationCode(code));
    }

    @Transactional
    public boolean activateUserByLogin(String login){
        return activateUser(userDao.getUserByLogin(login));
    }

    @Transactional
    public boolean activateUserById(Integer id){
        return activateUser(userDao.getUserById(id));
    }

    @Transactional
    public boolean deactivateUserById(Integer id){
        return deactivateUser(userDao.getUserById(id));
    }

    @Transactional
    private boolean activateUser(User user){
        if (user == null){
            return false;
        }
        user.setEnabled(true);
        userDao.updateUser(user);
        return true;
    }

    @Transactional
    private boolean deactivateUser(User user){
        if (user == null){
            return false;
        }
        user.setEnabled(false);
        userDao.updateUser(user);
        return true;
    }

}
