package com.gips.myapp.form;

import lombok.Data;


//localhost:8080接続後にインスタンス化、login.htmlに渡す。

@Data
public class LoginForm {
	private String id;
	private String password;



}
