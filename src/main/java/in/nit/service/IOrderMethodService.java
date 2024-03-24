package in.nit.service;

import java.util.List;
import java.util.Optional;

import in.nit.model.OrderMethod;

public interface IOrderMethodService {
 
	Integer saveOrderMethod(OrderMethod st);
	void updateOrderMethod(OrderMethod st);
	
	void deleteOrderMethod(Integer id);
	Optional<OrderMethod> getOneOrderMethod(Integer id);
	
	List<OrderMethod> getAllOrderMethods();
	boolean isOrderMethodExist(Integer id);
}
