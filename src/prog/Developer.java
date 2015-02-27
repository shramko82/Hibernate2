package prog;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Developer")
public class Developer {
	private long id;
	private String name;
	private Contact contact;
	private Set<Project> projects = new HashSet<Project>(0);
	
	public Developer() {}
	
	public Developer(String name, Contact contact) {
		this.name = name;
		this.contact = contact;
	}
	
	@Override
	public String toString() {
		return name + " " + contact.toString() + " " + projects.toString();
	}
	
	public void add(Project project) {
		projects.add(project);
	}

	@Id
	@GeneratedValue
	@Column(name = "Id")
	public long getId() {
		return id;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return name;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Contact getContact() {
		return contact;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Work", joinColumns = { @JoinColumn(name = "Dev_id") }, inverseJoinColumns = { @JoinColumn(name = "Project_id") })
	public Set<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
