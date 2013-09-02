package by.itransition.dpm.controller;

import by.itransition.dpm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import by.itransition.dpm.entity.User;
import by.itransition.dpm.service.Activation;
import by.itransition.dpm.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {
	private static final int USERS_ON_PAGE = 8;
	
	@Autowired
	private AdminService adminService;
	
	public void setAdminService(AdminService adminService){
		this.adminService = adminService;
	}
	
	@Autowired
	private Activation activation;
	
	public void setActivation(Activation activation){
		this.activation = activation;
	}
	
	@RequestMapping(value = "users/{page}/activate/{idUser}")
	public String activate(Model model, @PathVariable Integer idUser, @PathVariable Integer page, HttpServletRequest request){
		activation.activateUserById(idUser);
		return "redirect:/users/"+page;
	}
	
	@RequestMapping(value = "users/{page}/deactivate/{idUser}")
	public String deactivate(Model model, @PathVariable Integer idUser, @PathVariable Integer page, HttpServletRequest request){
		activation.deactivateUserById(idUser);
		return "redirect:/users/"+page;
	}
	
	@RequestMapping(value = "users/{page}")
	public String users(Model model, @PathVariable Integer page, HttpServletRequest request){
		model.addAttribute("path", request.getRequestURI());		    
		List<User> userList = adminService.getRoleUserList();
		addPageInfo(model, userList.size(), page);
		model.addAttribute("userList", getPartOfUsers(page, userList));
		model.addAttribute("headerUsers", true);
		return "users";
	}

    @Autowired
    UserDao userDao;

    @RequestMapping("users")
    public String allUsers (Model model){
        model.addAttribute("users", userDao.getAllUsers());
        return "users";
    }

	private void addPageInfo(Model model, Integer size, Integer page){
		model.addAttribute("pages",(size+USERS_ON_PAGE-1) / USERS_ON_PAGE);	
		model.addAttribute("page", page);
//		model.addAttribute("usersOnPage", USERS_ON_PAGE);
	}
	
	private List<User> getPartOfUsers(Integer page, List<User> userList){
		int first = (page-1)*USERS_ON_PAGE;
		int last = Math.min(page*USERS_ON_PAGE, userList.size());
		return userList.subList(first, last);
	}
	
}
