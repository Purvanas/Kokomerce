package fr.ensitech.tpjsf.model.dao;

import java.util.List;

import fr.ensitech.tpjsf.entity.User;


public interface IUserDao {

	Integer addUser(User user) throws Exception;
	User getUserById(int id) throws Exception;
	User getUserByEmail(String email) throws Exception;
	void updateUser(User user) throws Exception;
	void removeUser(int id) throws Exception;
	List<User> getUsers() throws Exception;
	

}
