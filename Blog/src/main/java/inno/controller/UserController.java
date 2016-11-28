package inno.controller;

import inno.model.Post;
import inno.model.User;
import inno.repository.PostRepository;
import inno.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

/*    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewPostPage(ModelMap map) {
        map.addAttribute("post", new Post());
        return "posts/add";
    }*/

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public String addNewPost(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/add";
        }
        userRepository.create(user);
        return "redirect:/users/add";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable("id") Long id, ModelMap map) {
        Post post = postRepository.find(id);

        map.addAttribute("post", post);
        return "/posts/show";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") Long id, ModelMap map) {
        postRepository.remove(id);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") Long id, ModelMap map) {
        Post post = postRepository.find(id);
        map.addAttribute("post", post);
        return "posts/edit";
    }

    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
    public String savePost(@ModelAttribute @Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "posts/edit";
        }
        postRepository.update(post);
        return "redirect:/posts";
    }
}