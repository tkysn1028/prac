package com.gips.myapp.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class CharacterCheck {

//idの値チェック
//idの桁数は４桁か？
//中身は数値か？（commonslangのisnumericを使用


	public static boolean idCheck(String id) {
		boolean a = id.length() == 4;
		boolean b = StringUtils.isNumeric(id);

	if(a && b) {
		return true;
	}

		return false;

	}
//名前の値チェック
//空欄でないか？

	public static boolean nameCheck(String name) {
		if(StringUtils.isBlank(name)) {
			return false;
		}else {

		return true;
		}

	}
//password値チェック
//passの桁数は8以上か？
//パスワードは半角英字と数字を含むか？正規表現で確認



	public static boolean passCheck(String pass) {
		String regex = "^[A-Za-z0-9]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(pass);


		boolean a = pass.length() > 7;
		boolean b = m.matches();

		if(a && b) {
			return true;
		}
		return false;


	}




}
