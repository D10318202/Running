package com.springboot.running;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractExpandEntity extends AbstractEntity {

	private static final long serialVersionUID = -7050663984626517331L;
	@Size(max = 255)
	@Column(name="EXPAND_MEMO1")
	private String expandMemo1;

	@Size(max = 255)
	@Column(name="EXPAND_MEMO2")
	private String expandMemo2;
	
	@Size(max = 255)
	@Column(name="EXPAND_MEMO3")
	private String expandMemo3;
	
	@Size(max = 255)
	@Column(name="EXPAND_MEMO4")
	private String expandMemo4;
	
	@Size(max = 255)
	@Column(name="EXPAND_MEMO5")
	private String expandMemo5;
	
	@Size(max = 255)
	@Column(name="EXPAND_MEMO6")
	private String expandMemo6;
	
	@Size(max = 255)
	@Column(name="EXPAND_MEMO7")
	private String expandMemo7;
	
	@Size(max = 255)
	@Column(name="EXPAND_MEMO8")
	private String expandMemo8;
	
	@Size(max = 255)
	@Column(name="EXPAND_MEMO9")
	private String expandMemo9;
	
	@Size(max = 255)
	@Column(name="EXPAND_MEMO10")
	private String expandMemo10;
	
}
