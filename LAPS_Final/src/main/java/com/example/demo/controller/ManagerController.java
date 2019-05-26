package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.LeaveDetails;
import com.example.demo.repo.LeaveDetailRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@Controller
public class ManagerController {
	
	private LeaveDetailRepository leaveRepository;
	
    // Finding Employee on leave on given period
    @RequestMapping(path = "/leave/findleave", method = RequestMethod.GET)
    public String findEmpOnLeave(Model model) {
    	model.addAttribute("leaves", new LeaveDetails());
        return "findleave";
    }
    
	
    @RequestMapping(path = "/EmpOnLeave", method = RequestMethod.GET)
    public String FindEmpOnLeave(Model model,LeaveDetails leave) {
    	List<LeaveDetails> lea = leaveRepository.findAllByStartdateGreaterThanEqualAndEnddateLessThanEqual(leave.getStartdate(),leave.getEnddate());
    	for(LeaveDetails l:lea) 
	  	  { 
	  		  System.out.println(l); 
  		  } 
    	model.addAttribute("leaves", leaveRepository.findAllByStartdateGreaterThanEqualAndEnddateLessThanEqual(leave.getStartdate(),leave.getEnddate()));
  	  	return  "leaves"; 
    }
  
	//Export Products to CSV file
    @GetMapping("/leave/export")
    public void exportCSV(HttpServletResponse response) throws Exception {

        //set file name and content type
        String filename = "LeaveList.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

        //create a csv writer
        StatefulBeanToCsv<LeaveDetails> writer = new StatefulBeanToCsvBuilder<LeaveDetails>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        leaveRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
               
        //write all leavelist to csv file
        writer.write(leaveRepository.findAll());
    }

}
