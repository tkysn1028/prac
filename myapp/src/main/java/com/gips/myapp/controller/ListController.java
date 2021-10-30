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
import com.gips.myapp.form.OutputForm;
import com.gips.myapp.form.UpdateForm;
import com.gips.myapp.service.CharacterCheck;
import com.gips.myapp.service.MyappService;

//リスト処理のみまとめたコントローラ
@Controller
public class ListController {

//リストの内容をアップデートするための仲介用フィールド
//アップデート前の内容を受けてupdate文を実行する

	UserEntity updateentity = new UserEntity();




	@Autowired
	private MyappService service;


//localhost:8080/listから飛んだ処理
//registuser.htmlの「ユーザー一覧」リンクからも飛ぶ。


//サービスクラスを介してDBからuserentityにDBから取ってきた値がセットされているlistが返る
//出力用formクラスのoutputformのインスタンスにid,name,passを全てセット
//list化してモデルにそのリストを追加


	@RequestMapping("/list")
	public String getUserlist(Model model) {
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

			return "userList";


	}



//localhost:8080/listから飛んだ処理
//registuser.htmlの「ユーザー一覧」リンクからも飛ぶ。
//outputformクラスのリストのインスタンス生成、update.htmlに遷移して渡す
//アップデート用のformクラスのインスタンス作成、update.html(アップデートするデータを選択するhtml)に遷移


	@RequestMapping("/update")
	public String update(Model model) {
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



		UpdateForm updateform = new UpdateForm();
		model.addAttribute("updateform",updateform);

		return "update";
	}

//事前に生成しておいた仲介役updateformのインすんタンスに値をセット。
//update.htmlで選択されて取得されたデータ(outputform)を処理せずそのままモデルに追加
//updateformとoutputformをupdateuser.htmlに渡す
//
	@PostMapping("/updateuser")
	public String updateuser(@ModelAttribute OutputForm form ,Model model) {
		updateentity.setId(form.getId());
		updateentity.setName(form.getName());
		updateentity.setPassword(form.getPassword());

		model.addAttribute("outputform", form);
		UpdateForm updateform = new UpdateForm();
		model.addAttribute("updateform", updateform);

		return "updateUser";
	}


//事前にregistuserと同様の値チェック＋id重複時のプライマリーキー違反防止のための条件追加
//前の処理で受け取った値を全てupdate文実行のserviceクラスに放り込んでupdate実行

	@PostMapping("/sendupdate")
	public String sendupdate(@ModelAttribute("updateform") UpdateForm updateform,Model model) {
		boolean isProperId = CharacterCheck.idCheck(updateform.getId());
		boolean isProperName = CharacterCheck.nameCheck(updateform.getName());
		boolean isProperPass = CharacterCheck.passCheck(updateform.getPassword());
		boolean idExists = service.existsById(updateform.getId());

		if(isProperId && isProperName && isProperPass && !(idExists)) {

		service.updateUser(updateform.getId(), updateform.getName(), updateform.getPassword()
				, updateentity.getId(),updateentity.getName() ,updateentity.getPassword());


		return "successregister";
		}
		return "failregister";



	}





}
