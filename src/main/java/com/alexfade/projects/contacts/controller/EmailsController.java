package com.alexfade.projects.contacts.controller;

import com.alexfade.projects.contacts.dao.EmailDAO;
import com.alexfade.projects.contacts.domain.Email;
import com.alexfade.projects.contacts.domain.User;
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
public class EmailsController {

    @Autowired
    private EmailDAO emailDAO;

    @RequestMapping("/emails")
    public ModelAndView handleRequest() throws Exception {
        List<Email> emails = emailDAO.getAllEmails();
        ModelAndView model = new ModelAndView("EmailList");
        model.addObject("emailList", emails);
        return model;
    }

    @RequestMapping(value = "/emails/new", method = RequestMethod.GET)
    public ModelAndView newEmail() {
        ModelAndView model = new ModelAndView("EmailForm");
        model.addObject("email", new Email());
        return model;
    }

    @RequestMapping(value = "/emails/edit", method = RequestMethod.GET)
    public ModelAndView editEmail(HttpServletRequest request) {
//        ModelAndView model = new ModelAndView("EmailForm");
//        model.addObject("email", new Email());
//        return model;

        int emailId = Integer.parseInt(request.getParameter("emailId"));
        Email email = emailDAO.getEmail(emailId);
        ModelAndView model = new ModelAndView("EmailForm");
        model.addObject("email", email);
        return model;
    }

    @RequestMapping(value = "/emails/delete", method = RequestMethod.GET)
    public ModelAndView deleteEmail(HttpServletRequest request) {
        int emailId= Integer.parseInt(request.getParameter("emailId"));
        emailDAO.deleteEmail(emailId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/emails/save", method = RequestMethod.POST)
    public ModelAndView saveEmail(@RequestParam("userId") Integer userId, @ModelAttribute Email email) {
        emailDAO.createEmail(userId, email);
        return new ModelAndView("redirect:/");
    }
}
