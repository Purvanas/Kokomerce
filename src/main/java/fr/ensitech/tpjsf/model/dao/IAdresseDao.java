package fr.ensitech.tpjsf.model.dao;

import fr.ensitech.tpjsf.entity.Adresse;

public interface IAdresseDao {
	
	String getAdressesByUserId(int userId)throws Exception;
	Integer addAdresse(Adresse adresse)throws Exception;
	void updateAdresse(Adresse adresse)throws Exception;
	void removeAdresse(int id)throws Exception;

}
