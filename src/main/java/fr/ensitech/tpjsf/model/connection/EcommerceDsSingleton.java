package fr.ensitech.tpjsf.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;



public class EcommerceDsSingleton {

private static EcommerceDsSingleton instance;
	
	private EcommerceDsSingleton() {
		
	}
	
	public static EcommerceDsSingleton getInstance() {
		if (instance == null) {
			instance = new EcommerceDsSingleton();
		}
		return instance;
	}
	
	public static Connection getConnection() throws Exception{
		System.out.println("Récupération d'une connection à la bdd");
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/users_db";
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
	
}
