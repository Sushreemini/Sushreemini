package com.example.RMGX.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.example.RMGX.others.AssignmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Asset")
/*@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "assetId")
	private Long assetId;
	
	
	@Column(name = "name")
	@JsonProperty("name")
	private String name;
	
	@Column(name = "description")
	@JsonProperty("description")
	private String description;
	

	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "IST")
	@Column(name = "purchase_date")
	@JsonProperty("purchase_date")
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	

	@Column(name = "condition_notes")
	@JsonProperty("condition_notes")
	private String conditionNotes;
	
	@Column(name = "category_Id")
	@JsonProperty("category_Id")
	String categoryId;
	
	@Column(name = "employee_Id")
	@JsonProperty("employee_Id")
	String employeeId;
	
	
	AssignmentStatus assignmentStatus;


	public Long getAssetId() {
		return assetId;
	}


	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public String getConditionNotes() {
		return conditionNotes;
	}


	public void setConditionNotes(String conditionNotes) {
		this.conditionNotes = conditionNotes;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public AssignmentStatus getAssignmentStatus() {
		return assignmentStatus;
	}


	public void setAssignmentStatus(AssignmentStatus assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result + ((assignmentStatus == null) ? 0 : assignmentStatus.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((conditionNotes == null) ? 0 : conditionNotes.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
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
		Asset other = (Asset) obj;
		if (assetId == null) {
			if (other.assetId != null)
				return false;
		} else if (!assetId.equals(other.assetId))
			return false;
		if (assignmentStatus != other.assignmentStatus)
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (conditionNotes == null) {
			if (other.conditionNotes != null)
				return false;
		} else if (!conditionNotes.equals(other.conditionNotes))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", name=" + name + ", description=" + description + ", purchaseDate="
				+ purchaseDate + ", conditionNotes=" + conditionNotes + ", categoryId=" + categoryId + ", employeeId="
				+ employeeId + ", assignmentStatus=" + assignmentStatus + "]";
	}
	
	
}
