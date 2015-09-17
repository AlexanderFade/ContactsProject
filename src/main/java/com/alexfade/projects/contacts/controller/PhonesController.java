package com.alexfade.projects.contacts.controller;

import com.alexfade.projects.contacts.dao.PhoneDAO;
import com.alexfade.projects.contacts.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Alexander Kovalevsky on 09.09.15.
 * Project name: ContactsProject
 */

@Controller
public class PhonesController {

    @Autowired
    private PhoneDAO phoneDAO;

    @RequestMapping("/phones")
    public ModelAndView handleRequest() throws Exception {
        List<Phone> phones = phoneDAO.getAllPhones();
        ModelAndView model = new ModelAndView("PhoneList");
        model.addObject("phoneList", phones);
        return model;
    }

    @RequestMapping(value = "/phones/new", method = RequestMethod.GET)
    public ModelAndView newPhone() {
        ModelAndView model = new ModelAndView("PhoneForm");
        model.addObject("phone", new Phone());
        return model;
    }

    @RequestMapping(value = "/phones/edit", method = RequestMethod.GET)
    public ModelAndView editPhone(HttpServletRequest request) {
//        ModelAndView model = new ModelAndView("PhoneForm");
//        model.addObject("phone", new Phone());
//        return model;

        int phoneId = Integer.parseInt(request.getParameter("phoneId"));
        Phone phone = phoneDAO.getPhone(phoneId);
        ModelAndView model = new ModelAndView("PhoneForm");
        model.addObject("phone", phone);
        return model;
    }

    @RequestMapping(value = "/phones/delete", method = RequestMethod.GET)
    public ModelAndView deletePhone(HttpServletRequest request) {
        int phoneId = Integer.parseInt(request.getParameter("phoneId"));
        phoneDAO.deletePhone(phoneId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/phones/save", method = RequestMethod.POST)
    public ModelAndView savePhone(@RequestParam("userId") Integer userId, @ModelAttribute Phone phone) {
        phoneDAO.createPhone(userId, phone);
        return new ModelAndView("redirect:/");
    }

}
