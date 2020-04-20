package crud.controller;

import crud.model.User;
import crud.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UpdateController {

    @Autowired
    private Service service;

    @GetMapping("/update")
    public String getUpdate(HttpServletRequest request, ModelMap map) {
        User user = service.getUserById(request.getParameter("userId"));
        map.addAttribute("userUpdated", user);

        return "update";
    }

    @PostMapping("/update")
    public String postUpdate(HttpServletRequest request, ModelMap map) {
        String name = request.getParameter("nameToUpdate");
        String age = request.getParameter("ageToUpdate");
        String passport = request.getParameter("passportToUpdate");
        String id = request.getParameter("userId");
        service.update(id, name, age, passport);
        map.addAttribute("users", service.getUsers());

        return "user";
    }
}
