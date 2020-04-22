package crud.controller;

import crud.model.User;
import crud.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Service service;


    @GetMapping()
    public String getUser(ModelMap map) {
        List<User> users = service.getUsers();
        map.addAttribute("users", users);

        return "user";
    }

    @PostMapping()
    public String postUser(HttpServletRequest request, ModelMap map) {
        Set<String> roleSet = new HashSet<>();
        roleSet.add(request.getParameter("role_admin"));
        roleSet.add(request.getParameter("role_user"));
        service.add(request.getParameter("name"),
                request.getParameter("age"),
                request.getParameter("password"),
                roleSet
        );
        List<User> users = service.getUsers();
        map.addAttribute("users", users);

        return "user";
    }
}
