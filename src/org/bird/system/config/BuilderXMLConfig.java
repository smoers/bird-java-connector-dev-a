package org.bird.system.config;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class BuilderXMLConfig {

	private Set<XMLConfig> listXMLConfig;
	public static final String DEFAULT_PATH_CONGIF_FILE = "./config/";
	public static final String DEFAULT_CONNECTORS_FILENAME = "connectors.xml";
	
	/** Contructeur privé */
	private BuilderXMLConfig(){
		listXMLConfig = new HashSet<XMLConfig>();
	}
	
	/** Holder */
	private static class SingletonHolder{	
		/** Instance unique non préinitialisée */
		private final static BuilderXMLConfig instance = new BuilderXMLConfig();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static BuilderXMLConfig getInstance(){
		return SingletonHolder.instance;
	}
	
	public <T> XMLConfig getXMLConfig(String path, String filename){
		
		boolean flag = true;
		XMLConfig<T> xmlconfig = null;
		//test si l'objet XMLConfig existe déjà pour le fichier de configuration
		// passé en parametre
		Iterator<XMLConfig> it = listXMLConfig.iterator();
		while(it.hasNext()){
			xmlconfig = it.next();
			if(xmlconfig.getPath().equals(path) && xmlconfig.getFilename().equals(filename)){
				flag = false;
				break;
			}
		}
		//si l'objet n'existe pas on le crée et le retourne
		if(flag){
			xmlconfig = new XMLConfig<T>(path,filename);
			listXMLConfig.add(xmlconfig);
		}
		
		return xmlconfig;
	}
	
	public <T> XMLConfig getXMLConfig(String filename){
		
		return getXMLConfig(BuilderXMLConfig.DEFAULT_PATH_CONGIF_FILE,filename);
		
	}


}
