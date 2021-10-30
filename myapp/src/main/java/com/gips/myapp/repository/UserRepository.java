package com.gips.myapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gips.myapp.entity.UserEntity;
//logintable用リポジトリ
public interface UserRepository extends JpaRepository<UserEntity, String>{
	//select分実行用抽象メソッド
	@Query(value="select * from logintable", nativeQuery = true)
	List<UserEntity> findAllUser();

	//select文実行 idとpassが一致したもののみ取得ver
	boolean existsByIdAndPassword(String id,String password);

	boolean existsById(String id);


	@Transactional
	@Modifying
	@Query(value = "update logintable set id = :updateid, name= :updatename, password= :updatepass where id= :id and name= :name"
			+ " and password= :password"
			, nativeQuery = true)

	int updateUser(@Param("updateid")String updateid,@Param("updatename")String updatename,@Param("updatepass")String updatepass,
			@Param("id")String id,@Param("name")String name,@Param("password")String password);




}
