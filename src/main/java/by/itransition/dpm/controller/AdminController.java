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
	
	@RequestMapping(value = "users/activate/{idUser}")
	public String activate(Model model, @PathVariable Integer idUser, HttpServletRequest request){
		activation.activateUserById(idUser);
		return "redirect:/users/";
	}
	
	@RequestMapping(value = "users/deactivate/{idUser}")
	public String deactivate(Model model, @PathVariable Integer idUser, HttpServletRequest request){
		activation.deactivateUserById(idUser);
		return "redirect:/users/";
	}

    @RequestMapping("users")
    public String allUsers (Model model){
        model.addAttribute("users", adminService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "users/delete/{idUser}")
    public String deleteUser(Model model, @PathVariable Integer idUser, HttpServletRequest request){
        adminService.deleteUserById(idUser);
        return "redirect:/users/";
    }


    @RequestMapping("denied")
    public String accessDenied(){
        return "denied";
    }
}
