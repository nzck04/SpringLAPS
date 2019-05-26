package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.LeaveDetails;
import com.example.demo.repo.LeaveDetailRepository;
import com.example.demo.service.MailingService;

@Controller
public class LeaveController {
    
    private LeaveDetailRepository leaveRepository;
    
    @Autowired
	private MailingService mailservice;
    
    @Autowired
    public void setLeaveRepository(LeaveDetailRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @RequestMapping(path = "/leave/add", method = RequestMethod.GET)
    public String createLeave(Model model) {
    	model.addAttribute("leaves", new LeaveDetails()); 	
        return "leaveEdit";
    }
    
    @RequestMapping(path = "/leaves", method = RequestMethod.GET)
    public String getAllLeaves(Model model) {
        model.addAttribute("leaves", leaveRepository.findAll());
        return "leaves";
    }
    
    @RequestMapping(path = "leaves", method = RequestMethod.POST)
    public String saveLeave(LeaveDetails leave) {
        leaveRepository.save(leave);
        
        //Send NotiEmail to Related Manager
        String mailaddr=leave.getEmp().getManager().getEmail();
        mailservice.sendNotification(mailaddr);
        
        return "redirect:/";
    }

    @RequestMapping(path = "/leave/edit/{id}", method = RequestMethod.GET)
    public String editLeave(Model model, @PathVariable(value = "id") String id) {  
    	Integer lid=Integer.valueOf(id);
    	LeaveDetails l = leaveRepository.findById(lid).orElse(null);
    	System.out.println(l);
        model.addAttribute("leaves", l);
        return "leaveEdit";
    }    

    @RequestMapping(path = "/leave/delete/{id}", method = RequestMethod.GET)
    public String deleteLeave(@PathVariable(name = "id") String id) {
    	Integer lid=Integer.valueOf(id);
    	leaveRepository.delete(leaveRepository.findById(lid).orElse(null));
        return "redirect:/leaves";
    }

}
