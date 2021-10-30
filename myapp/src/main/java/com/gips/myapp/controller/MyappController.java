package com.gips.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gips.myapp.entity.UserEntity;
import com.gips.myapp.form.InputForm;
import com.gips.myapp.form.LoginForm;
import com.gips.myapp.form.OutputForm;
import com.gips.myapp.service.CharacterCheck;
import com.gips.myapp.service.MyappService;

//login処理のみまとめたコントローラ

@Controller
public class MyappController {


//サービスクラスのインスタンス結び付け
	@Autowired
	private MyappService service;




//localhost8080/registにアクセスした際の挙動
//formクラスのインスタンス化とモデルに追加

	@RequestMapping("/regist")
	String home(Model model) {
		InputForm inputform = new InputForm();

		model.addAttribute("inputform", inputform);

		return "registUser";

	}




//registeruser.htmlからpost要求を受け取った処理
//registuser.htmlでid,name,passで入力された値を受け取る。
//エンティティをインスタンス化、エンティティに入力された値をセットする。
//モデルに追加
//サービスクラスにエンティティを引数に渡す。サービスクラス内処理でDB操作を実行

	@PostMapping("/send")
	public String send(@ModelAttribute InputForm inputform,Model model) {
//idcheck,namecheck,passcheck,allsame、１番目と２番目のパスが同じか？を全てbooleanで受ける
//OKであれば登録処理 NGであればfailregisterを返してログイン失敗と表示


		boolean isProperId = CharacterCheck.idCheck(inputform.getId());
		boolean isProperName = CharacterCheck.nameCheck(inputform.getName());
		boolean isProperPass = CharacterCheck.passCheck(inputform.getPassword());
		boolean isSamePass = inputform.getPassword().equals(inputform.getPassword2());
			if(isProperId && isProperName && isProperPass && isSamePass) {

				UserEntity userentity = new UserEntity();
				userentity.setId(inputform.getId());
				userentity.setName(inputform.getName());
				userentity.setPassword(inputform.getPassword());

		service.registUser(userentity);
		model.addAttribute("inputform", inputform);
		return "successregister";

			}else {

		model.addAttribute("inputform", inputform);
		return "failregister";

}


	}



//localhost:8080にアクセスしたときの挙動
//loginformクラスのインスタンス化

	@RequestMapping("/")
	public String access(Model model) {
		LoginForm loginform = new LoginForm();
		model.addAttribute("loginform", loginform);

		return "login";
	}




//localhost:8080で受け取ったpost要求処理
//DBからデータを引っ張ってきてリスト作成
//outputformを用意、DBから引っ張ったデータでoutputform用リスト作成する
//outputformの内容一つ一つをログインフォームのid,passと照らし合わせ、どっちも正しい時にflagをtrueに
//flagがtrueならログイン成功、失敗ならfail.htmlへ fail.htmlにはlocalhost:8080のget要求を飛ばすリンクあり


	@PostMapping("/login")
	public String login(@ModelAttribute LoginForm loginform,Model model) {
		List<UserEntity> userInfos = service.findAllUser();
		List<OutputForm> outPutFormList = new ArrayList<>();
			for(UserEntity userInfo : userInfos) {
				OutputForm outputForm = new OutputForm();
				outputForm.setId(userInfo.getId());
				outputForm.setName(userInfo.getName());
				outputForm.setPassword(userInfo.getPassword());
				outPutFormList.add(outputForm);
			}

			model.addAttribute("outputForms", outPutFormList);

			boolean flag = service.existsByIdAndPassword(loginform.getId(), loginform.getPassword());
			if(flag) {
				return "userList";

				}else {
					return "fail";
				}



	}


}
