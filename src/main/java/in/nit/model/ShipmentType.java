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
	@Column(name="ship_id_col")
	private Integer id;
	
	@Column(name="ship_mode_col")
	private String shipmentMode;
	
	@Column(name="ship_code_col")
	private String shipmentCode;
	
	@Column(name="enab_ship_col")
	private String enableShipment;
	
	@Column(name="ship_grade_col")
	private String shipmentGrade;
	
	@Column(name="ship_desc_col")
	private String description;
	

}
