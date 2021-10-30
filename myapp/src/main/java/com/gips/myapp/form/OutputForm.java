package com.gips.myapp.form;

import lombok.Data;

//DBから出力されたデータの受け取り用Form
//id,name,passwordを受け取る
//この値をuserlist.htmlに出力する


@Data
public class OutputForm {
		private String id;
		private String name;
		private String password;


}
