package com.gmtommasini.course.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_payments")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	// *** Attributes ***
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant paymentDate;
	private Integer someRandomTest;
	
	// *** Associations *** 
	@OneToOne
	@MapsId
	private Order order;

	
	// *** Constructors ***
	public Payment() {}
	
	public Payment(Long id, Instant paymentDate, Order order) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.order = order;
		this.someRandomTest = 123;
	}


	// *** Getters and Setters ***
	public Long getId() {
		return id;
	}

	public Instant getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Instant paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	// *** Standard Methods ***
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
 