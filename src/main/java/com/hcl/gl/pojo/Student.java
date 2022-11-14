package com.hcl.gl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {

	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String name;
	private String password;
	private int m1;
	private int m2;
	private int m3;
	
}
