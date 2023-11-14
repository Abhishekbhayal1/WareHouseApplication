package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeService {
	
	Integer saveShipmentType(ShipmentType st);
	void updateShipmentType(ShipmentType st);
	void deleteShipmentType(Integer id);
	
	
	ShipmentType getOneShipmentType(Integer id);
	List<ShipmentType> getAllShipmentType();

	
	boolean isShipmentTypeExist(Integer id);
}
