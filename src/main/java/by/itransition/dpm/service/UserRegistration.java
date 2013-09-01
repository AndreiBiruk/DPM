package by.itransition.dpm.service;

import by.itransition.dpm.Main;
import by.itransition.dpm.dao.RoleDao;
import by.itransition.dpm.dao.RoleDaoImpl;
import by.itransition.dpm.dao.UserDao;
import by.itransition.dpm.dao.UserDaoImpl;
import by.itransition.dpm.entity.Role;
import by.itransition.dpm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegistration {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage message;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    private User user;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setMessage(SimpleMailMessage message) {
        this.message = message;
    }

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao){
        this.roleDao = roleDao;
    }

    public void setUser(User user){
        this.user = user;
    }

    @Transactional
    public void registrate(){
        addUser();
        addRole();
        sendMessage(generateLink());
    }

    public void sendMessage(String link) {
        message.setFrom("MusicUploader");
        message.setTo(user.getEmail());
        message.setSubject("Activation on MusicUploader");
        message.setText(Main.ACTIVATION_MESSAGE_1 + user.getUsername() + Main.ACTIVATION_MESSAGE_2 + user.getPassword() + Main.ACTIVATION_MESSAGE_3 + link + Main.ACTIVATION_MESSAGE_4);
        mailSender.send(message);
    }

    @Transactional
    public void addUser() {
        userDao.addUser(user);
    }

    @Transactional
    public void addRole() {
        User user = userDao.getUserByLogin(this.user.getUsername());
        Role role = new Role();
        role.setRole(Role.ROLE_USER);
        role.setIdUser(user.getIdUser());
        roleDao.addRole(role);
    }

    private String generateLink(){
        StringBuffer link = new StringBuffer(Main.DOMAIN_NAME);
        link.append("/mup/activate/");
        link.append(Activation.generateActivationCode(user));
        return new String(link);
    }
}
