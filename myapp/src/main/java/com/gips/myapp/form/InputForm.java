package com.gips.myapp.form;

import lombok.Data;




//registuser.htmlで受け取った値処理用form
//このformの内容を元に値をDBに入力する
@Data
public class InputForm {
	private String id;
	private String name;
	private String password;
	private String password2;
}
