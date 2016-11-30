package inno.controller;

import inno.model.Post;
import inno.model.Users;
import inno.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String addNewUserPage(ModelMap map) {
        map.addAttribute("users", new Users());
        return "posts/login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute Users users, BindingResult result) {
        if (result.hasErrors()) {
            return "posts/login";
        }
        userRepository.add(users);
        return "redirect:/posts";
    }

    //@RequestMapping(value = "/login", )
}