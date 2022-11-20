package com.springboot.running;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//@Data
@Entity
//@Builder
//@AllArgsConstructor
@Table(name = "person")
@NamedQuery(name = "Person.finall", query = "SELECT i FROM Person i")
public class Person extends AbstractExpandEntity {
	
	private static final long serialVersionUID = 1L;


	// 01. Serial_No
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
	
	// 02. firstName 名字
	@Column(name="first_name", length=20)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
//	public Long getId() {
//		return id;
//	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

}
