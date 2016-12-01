package inno.controller;

import inno.model.Users;
import inno.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/posts")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addNewUserPage(ModelMap map) {
        map.addAttribute("users", new Users());
        return "posts/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute Users users, BindingResult result) {
        if (result.hasErrors()) {
            return "posts/register";
        }

        Users userAuto = users;
        if (!userRepository.isExistForAuto(userAuto)) {
            userRepository.add(users); //вступил в наш клуб
            return "redirect:/posts";
        } else {
            return "posts/register"; //провалил экзамен
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLoginPage(ModelMap map) {
        map.addAttribute("users", new Users());
        return "posts/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@ModelAttribute Users users, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "posts/login";
        }

        Users userLogin = users;
        if (userRepository.isExist(userLogin)) {
            //открыть сессию, разбираться с правами
            userAutoSession(users, request);
        } else {
            //сказать, что юзер слишком дерзок и надо бы повторить ввод логина/пароля
            return "posts/login";
        }
        return "redirect:/posts";
    }

    public void userAutoSession(Users users, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("Id", users.getId());
        session.setAttribute("userName", users.getUserName());
    }

}