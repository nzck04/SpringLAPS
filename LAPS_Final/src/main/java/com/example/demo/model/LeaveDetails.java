package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="leavedetails")
public class LeaveDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startdate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enddate;
	
	@OneToOne
	@JoinColumn(name="emp_id")
	private Employee emp;
	
	private String leavecategory;
	private String leavereason;
	private String contact;
	private String status;
	
	public LeaveDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeaveDetails(int id, Date startdate, Date enddate, Employee emp, String leavecategory, String leavereason,
			String contact, String status) {
		super();
		this.id = id;
		this.startdate = startdate;
		this.enddate = enddate;
		this.emp = emp;
		this.leavecategory = leavecategory;
		this.leavereason = leavereason;
		this.contact = contact;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public String getLeavecategory() {
		return leavecategory;
	}
	public void setLeavecategory(String leavecategory) {
		this.leavecategory = leavecategory;
	}
	public String getLeavereason() {
		return leavereason;
	}
	public void setLeavereason(String leavereason) {
		this.leavereason = leavereason;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "LeaveDetails [id=" + id + ", startdate=" + startdate + ", enddate=" + enddate + ", emp=" + emp
				+ ", leavecategory=" + leavecategory + ", leavereason=" + leavereason + ", contact=" + contact
				+ ", status=" + status + "]";
	}
	
	
	

	
}