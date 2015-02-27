package prog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {
	private long id;
	private String name;
	
	public Project() {}
	
	public Project(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "Id")
	public long getId() {
		return id;
	}

	@Column(name = "Name")
	public String getName() {
		return name;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
