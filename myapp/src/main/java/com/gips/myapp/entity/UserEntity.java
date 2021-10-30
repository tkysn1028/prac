package com.gips.myapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


//DBの内容と同じカラムを全て用意
//id,name,password
//tablenameはlogintable

@Entity
@Table(name="logintable")
@Data
public class UserEntity {
	@Id
	@Column(name="id")
	private String id;

	@Column(name="name")
	private String name;

	@Column(name="password")
	private String password;



}
