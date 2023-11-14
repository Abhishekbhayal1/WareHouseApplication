package in.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeControler {
	
	//1. Display Register page on enter/register
	@GetMapping("/r")
    public String showRegister() {
		return "ShipmentTypeControler";
	}
}
