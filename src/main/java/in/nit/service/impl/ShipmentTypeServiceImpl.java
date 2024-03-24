package in.nit.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.model.ShipmentType;
import in.nit.repo.ShipmentTypeRepository;
import in.nit.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private ShipmentTypeRepository repo;//has-a
	
	@Transactional
	public Integer saveShipmentType(ShipmentType st) {
		return repo.save(st).getId();
	}

	@Transactional
	public void updateShipmentType(ShipmentType st) {
		// TODO Auto-generated method stub
		repo.save(st);
		
	}


	@Transactional
	public void deleteShipmentType(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Transactional(readOnly=true)
	public ShipmentType getOneShipmentType(Integer id) {

      Optional<ShipmentType> obj= repo.findById(id);
      
      if(obj.isPresent()) {
    	  return obj.get();
      }
		
		return null;
	}

	@Transactional(readOnly=true) 
	public List<ShipmentType> getAllShipmentType() {
		List<ShipmentType> list = repo.findAll();
		return list;
	}

	@Transactional(readOnly=true)
	public boolean isShipmentTypeExist(Integer id) {
	  boolean flage =	repo.existsById(id);
		return flage;
	}






}
