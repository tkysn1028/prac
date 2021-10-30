package com.gips.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gips.myapp.entity.UserEntity;
import com.gips.myapp.repository.UserRepository;
//logintable専用サービスクラス。
@Service
public class MyappService {
	@Autowired
	private UserRepository repository;

//logintable操作するuserrepositoryのデータ入力用メソッド
public void registUser(UserEntity userentity) {
	repository.save(userentity);
}

//userrepositoryクラスのfindalluser呼び出し
//select * from logintableを実行するサービスクラスのメソッド
public List<UserEntity> findAllUser(){
	return repository.findAllUser();

}

//localhost8080を受けたログイン処理時に受け取ったデータ２つがＤＢに存在するか判定
//loginformのidを

//カスタムクエリ。idとpassが一致している場合にtrueを返す。

public boolean existsByIdAndPassword(String id,String password) {
	return repository.existsByIdAndPassword(id, password);
}

public boolean existsById(String id) {
	return repository.existsById(id);

}


public int updateUser(String updateid,String updatename,String updatepass,String id,String name, String password) {
	return repository.updateUser(updateid, updatename, updatepass, id,name,password);
}




}
