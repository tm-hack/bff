package com.example.bff.app.web;

import com.example.bff.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestOperations;

@Controller
public class BackendForFrontendController {

    @Autowired
    RestOperations restOperations;

    @RequestMapping(method = RequestMethod.GET, value = "users")
    public String getUsers(Model model) {
        String service = "/backend/api/v1/users";
        model.addAttribute("users",
                restOperations.getForObject(service, User[].class));
        return "users";
    }
}
