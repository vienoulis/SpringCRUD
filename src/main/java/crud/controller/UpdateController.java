package crud.controller;

import crud.model.User;
import crud.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UpdateController {

    @Autowired
    private Service service;

    @GetMapping("/admin/update")
    public String getUpdate(HttpServletRequest request, ModelMap map) {
        User user = service.getUserById(request.getParameter("userId"));
        map.addAttribute("userUpdated", user);

        return "update";
    }

    @PostMapping("/admin/update")
    public String postUpdate(HttpServletRequest request, ModelMap map) {
        String name = request.getParameter("nameToUpdate");
        String age = request.getParameter("ageToUpdate");
        String password = request.getParameter("passwordToUpdate");
        String id = request.getParameter("userId");
        Set<String> roleSet = new HashSet<>();
        roleSet.add(request.getParameter("role_admin_update"));
        roleSet.add(request.getParameter("role_user_update"));
        service.update(id, name, age, password, roleSet);
        map.addAttribute("users", service.getUsers());

        return "admin";
    }
}
