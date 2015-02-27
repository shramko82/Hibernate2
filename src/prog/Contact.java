package prog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
public class Contact {
	private long id;
	private String address;
	private String phone;
	private String email;
	
	public Contact() {}
	
	public Contact(String address, String phone, String email) {
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "[" + address + ", " + phone + ", " + email + "]";
	}

	@Id
	@GeneratedValue
	@Column(name = "Id")
	public long getId() {
		return id;
	}

	@Column(name = "Address")
	public String getAddress() {
		return address;
	}

	@Column(name = "Phone")
	public String getPhone() {
		return phone;
	}

	@Column(name = "Email")
	public String getEmail() {
		return email;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
