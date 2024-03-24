package in.nit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;
	
	// 1. show Register page
	@GetMapping("/register")
	public String showReg(Model model) {
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	// 2. save data
	@PostMapping("/save")
	public String save(@ModelAttribute OrderMethod orderMethod, Model model) {

		Integer id = service.saveOrderMethod(orderMethod);
		String message = "OrderMethod with " + id + " saved";
		model.addAttribute("message", message);

		// Redirect to the registration page to show the message
		return "OrderMethodRegister.html";
	}

	// 3. show all
    @GetMapping("/all")
    public String getAll(Model model) {
    	List<OrderMethod> list= service.getAllOrderMethods();
    	model.addAttribute("list",list);
    	return "OrderMethodData";
    	
    }
	
	
	// 4. edit page
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Integer id,Model model) {
    	String page = null;
    	Optional<OrderMethod> opt= service.getOneOrderMethod(id);
    	model.addAttribute("orderMethod",opt);
    	if(opt.isPresent()) {
    		
    		model.addAttribute("orderMethod",opt.get());
    		page="OrderMethodEdit";
    		
    	}
    	else {
    		page="redirect:../all";
    	}
    	return page;
    }

	// 5. do update
    @PostMapping("/update")
    public String update(@ModelAttribute OrderMethod orderMethod,Model model) {
    	
    	service.updateOrderMethod(orderMethod);
    	model.addAttribute("message","Order Method" +orderMethod.getId()+"Updated");
    	model.addAttribute("list",service.getAllOrderMethods());
    	
    	return "OrderMethodData";
    }
    //6. Delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
    	
    	String message = null;
    	if(service.isOrderMethodExist(id)){
    		service.deleteOrderMethod(id);
    		message="Order Method "+id+" Deleted";
    	}
    	else {
    		message="Order Method "+id+"Not Exist";
    	}
    	model.addAttribute("message" ,message);
    	model.addAttribute("list",service.getAllOrderMethods());
    	return "OrderMethodData";
    }

	// 6. show one
    @GetMapping("/view/{id}")
    public String showView(@PathVariable Integer id, Model model) {
    	String page = null;
    	Optional<OrderMethod>opt = service.getOneOrderMethod(id);
    	if(opt.isPresent()) {
    		OrderMethod om = opt.get();
    		model.addAttribute("ob",om);
    		page="OrderMethodView";
    	}
    	else {
    		page="redirect:../all";
    	}
    	
    	return page;
    }
}
