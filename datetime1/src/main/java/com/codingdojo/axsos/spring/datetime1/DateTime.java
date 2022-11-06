package com.codingdojo.axsos.spring.datetime1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Date;
import java.text.SimpleDateFormat;
@Controller
public class DateTime {

    @RequestMapping("/")
    public String index() {
       
        return "demo.jsp";
    }
    
    @RequestMapping("/date")
	public String datee(Model model) {
		String datePattern = "EEEEE, dd MMMMM, yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		String date = dateFormat.format(new Date());	
		model.addAttribute("date", date);
		return "date.jsp";
	}
    	
    
    @RequestMapping("/time")
    public String timee(Model model) {
    	String timePattern ="HH:mm:ss";
    	SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
    	String time = timeFormat.format(new Date());
    	
    	model.addAttribute("time", time);
    	return "time.jsp";
    	
    }
    	
    }
    
   


