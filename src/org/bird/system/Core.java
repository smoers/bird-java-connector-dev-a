package org.bird.system;

import java.util.HashSet;

import org.bird.system.config.BuilderXMLConfig;
import org.bird.system.config.XMLConfig;

public class Core {
	
	private static String DatabaseName = "bird";
	private static String DatabaseWhoIam = "whoiam";
	
	/** Contructeur privé */
	private Core(){
		Core.setDatabaseName("bird");
		Core.setDatabaseWhoIam("whoiam");
	}
	
	/** Holder */
	private static class SingletonHolder{	
		/** Instance unique non préinitialisée */
		private final static Core instance = new Core();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static Core getInstance(){
		return SingletonHolder.instance;
	}

	
	private static void setDatabaseName(String name){
		Core.DatabaseName = name;
	}
	
	private static void setDatabaseWhoIam(String whoiam){
		Core.DatabaseWhoIam = whoiam;
	}
	
	public static String getDatabaseName(){
		return Core.DatabaseName;
	}
	
	public static String getDatabaseWhoIam(){
		return Core.DatabaseWhoIam;
	}
	
}
