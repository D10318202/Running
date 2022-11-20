package com.springboot.running;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
//@Builder
//@AllArgsConstructor
@Table(name = "car")
@XmlRootElement
//@EqualsAndHashCode(callSuper = true)
@NamedQuery(name = "car.finall", query = "SELECT c FROM Car c")
public class Car extends AbstractExpandEntity {
	
	private static final long serialVersionUID = -4865512532633080146L;

	@Column(name="car_type", length=20)
	private String carType;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person owner;
	
	public String getCarType() {
		return carType;
	}
	
	public Person getOwner() {
		return owner;
	}
	
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public void setOwner(Person person) {
		this.owner = person;
	}
	
	

}
