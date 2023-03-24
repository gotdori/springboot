package Address;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(
		name="address_seq_generator",
		sequenceName="seq_address",
		initialValue = 1,
		allocationSize = 10
		)
@Entity
@Table(name="Address")
public class AddressDto {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator ="seq_address")
	private int seq;
	private String name;
	private String phone;
	private String email;
	private String wdate;
	
	public AddressDto() {

	}
	
	public AddressDto(int seq, String name, String phone, String email, String wdate) {
		super();
		this.seq = seq;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.wdate = wdate;
	}


	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "AddressDto [seq=" + seq + ", name=" + name + ", phone=" + phone + ", email=" + email + ", wdate="
				+ wdate + "]";
	}

	
}
