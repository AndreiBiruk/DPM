package by.itransition.dpm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.itransition.dpm.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import by.itransition.dpm.entity.User;
import by.itransition.dpm.helper.AddressBuilder;
import by.itransition.dpm.service.Activation;
import by.itransition.dpm.service.RegistrationValidator;
import by.itransition.dpm.service.UserRegistration;


@Controller
public class RegistrationController {

    @Autowired
    private RegistrationValidator validator;
    @Autowired
    private UserRegistration registration;
    @Autowired
    private Activation activation;

    public void setValidator(RegistrationValidator validator){
        this.validator = validator;
    }

    public void setRegistration(UserRegistration registration){
        this.registration = registration;
    }

    public void setActivation(Activation activation){
        this.activation = activation;
    }

    @RequestMapping(value = "addUser")
    public String registration(@ModelAttribute("user")User user, String confirmPassword, Model model, HttpServletRequest request){
        model.addAttribute("path", request.getRequestURI());

        validator.setUser(user);
        validator.setConfirmPassword(confirmPassword);

        List<String> errorList = validator.getErrorList();

        if (errorList.isEmpty()){
        //    by.itransition.dpm.dao.UserDao dao = new UserDaoImpl();
        //    user.setIdUser(10);
        //    dao.addUser(user);

            registration.setUser(user);
            registration.registrate();
        }
        return parseErrors(errorList);
    }

    private String parseErrors(List<String> errorList){
        if (errorList.isEmpty()){
            return "register";
        }
        AddressBuilder address = new AddressBuilder("redirect:/registration");
        for(String s : errorList){
            address.addArgument(s+"=true");
        }
        address.addArgument("error=true");
        return address.getAddress();
    }

    @RequestMapping(value = "activate/{code}")
    public String activate(@PathVariable String code, Model model, HttpServletRequest request){
        model.addAttribute("path", request.getRequestURI());
        if (activation.activateUserByCode(code)){
            return "redirect:/login?activated=true";
        }
        return "regidrect:/login";
    }

}
