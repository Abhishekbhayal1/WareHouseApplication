package in.nit.model;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ShipmentType_tab")
public class ShipmentType {
	@Id
	@GeneratedValue
	@Column(name="ship_id_col" ,length=5)
	private Integer id;
	
	@Column(name="ship_mode_col",length=20)
	private String shipmentMode;
	
	@Column(name="ship_code_col",length=5)
	private String shipmentCode;
	
	@Column(name="enab_ship_col",length=5)
	private String enableShipment;
	
	@Column(name="ship_grade_col",length=3)
	private String shipmentGrade;
	
	@Column(name="ship_desc_col",length=50)
	private String description;
	

}
