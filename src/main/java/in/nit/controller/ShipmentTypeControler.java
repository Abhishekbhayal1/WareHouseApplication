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

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeControler {
	@Autowired
	IShipmentTypeService service;

	// 1. Display Register page on enter/register
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	// 2.On click submit button read form data and save
	@PostMapping("/save")
	public String save(@ModelAttribute ShipmentType shipmentType, Model model) {
		Integer id = service.saveShipmentType(shipmentType);
		String msg = "ShipmentType" + id + "saved";
		model.addAttribute("message", msg);
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";

	}

	// 3.Display all records at UI
	@GetMapping("/all")
	public String showAll(Model model) {
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */

	// 4.Remove one by Id
	@GetMapping("/delete/{id}")
	public String removeById(@PathVariable Integer id, Model model) {

		String msg = null;
		if (service.isShipmentTypeExist(id)) {
			service.deleteShipmentType(id);
			msg = "ShipmentType  " + id + "   Deleted";
			model.addAttribute("message", msg);

		} else {
			msg = "ShipmentType " + id + "Not Exist";
			model.addAttribute("message", "ShipmentType " + id + "not exist");
		}

		// fetch other rows and display
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);

		return "ShipmentTypeData";
	}

	// 5. Show edit page with data
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable Integer id, Model model) {
		String page = null;
		Optional<ShipmentType> opt = Optional.ofNullable(service.getOneShipmentType(id));

		if (opt.isPresent()) {
			ShipmentType st = opt.get();
			model.addAttribute("shipmentType", st);
			page = "ShipmentTypeEdit";
		} else {
			page = "redirect:../all";
		}

		return page;
	}
	// Onclick update button ,read form data and perform update operation send back
	// to data page with success message

	// 6.Update :on click updata
	@PostMapping("/update")
	public String update(@ModelAttribute ShipmentType shipmentType, Model model) {

		service.updateShipmentType(shipmentType);
		String msg = "shipmentType" + shipmentType.getId() + " Updated";
		model.addAttribute("message", msg);

		// new data from Database
		// show other rows
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);

		return "ShipmentTypeData";
	}

}
