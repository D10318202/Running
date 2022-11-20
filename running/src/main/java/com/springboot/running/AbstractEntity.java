package com.springboot.running;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity implements Serializable{

	private static final long serialVersionUID = -2492654838434590989L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true)
	private String id;

	
	//@Basic(optional = false)
	//@NotNull
	@Column(name="EDIT_LOCK_FLAG")
	private Boolean editLockFlag;
	
	//@Basic(optional = false)
	//@NotNull
	@Column(name="CREATE_DATETIME")
	private LocalDateTime createDatetime;
	
	@Column(name="UPDATE_DATETIME")
	private LocalDateTime updateDatetime;

	@Column(name="DELETE_DATETIME")
	private LocalDateTime deleteDatetime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getEditLockFlag() {
		return editLockFlag;
	}

	public void setEditLockFlag(Boolean editLockFlag) {
		this.editLockFlag = editLockFlag;
	}

	public LocalDateTime getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(LocalDateTime createDatetime) {
		this.createDatetime = createDatetime;
	}

}
