package org.bird.db.connectors;

import java.lang.reflect.Constructor;
import java.util.Hashtable;
import java.util.UUID;

import org.bird.db.exceptions.DbException;
import org.bird.system.EnumBDBC;
import org.bird.system.config.BuilderXMLConfig;
import org.bird.system.config.XMLConfig;
import org.bird.system.config.exceptions.XMLConfigException;

/**
 * Cette classe, de type singleton, permet de gérer la liste 
 * des connecteurs de tout type
 * @author smoers
 *
 */
public class BuilderConnector {
	
	private Hashtable<UUID, IConnector> listconnector;
	private BuilderXMLConfig builderxmlconfig;
	private XMLConfig<Hashtable> xmlconfig;
	
	/** Contructeur privé */
	private BuilderConnector(){
		listconnector = new Hashtable();
		//Object pour la lecture et l'ecriture du fichier de config
		builderxmlconfig = BuilderXMLConfig.getInstance();
		xmlconfig = builderxmlconfig.<Hashtable>getXMLConfig(BuilderXMLConfig.DEFAULT_CONNECTORS_FILENAME);
	}
	
	/** Holder */
	private static class SingletonHolder{	
		/** Instance unique non préinitialisée */
		private final static BuilderConnector instance = new BuilderConnector();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static BuilderConnector getInstance(){
		return SingletonHolder.instance;
	}
	
	/**
	 * Ajoute un connecteur dans la list
	 * @param connector
	 */
	public void AddConnectorAtList(IConnector connector){
		listconnector.put(connector.getID(), connector);
	}
	
	/**
	 * Supprime un connecteur de la liste
	 * @param connector
	 */
	public void DeleteConnectorToList(IConnector connector){
		listconnector.remove(connector.getID());
	}
	
	/**
	 * 
	 * @param enumbdbc
	 * @return
	 * @throws DbException
	 */
	public IConnector getNewConnector(EnumBDBC enumbdbc) throws DbException {
		
		Constructor c;
		IConnector con;
		
		try {
			//récupère le contructeur de la classe
			c = Class.forName(enumbdbc.getBDBC()).getConstructor(EnumBDBC.class);
			//Instance de la classe avec lz bon paraamêtres
			con = (IConnector) c.newInstance(enumbdbc);
			//Place le nouvel objet IConnector dans le tableau
			listconnector.put(con.getID(), con);
			return con;
			
		} catch (Exception e) {
			throw new DbException("Db-0001",e);
		}
				
	}

	/**
	 * Retourne un connecteur sur base de son UUID
	 * @param id type UUID
	 * @return IConnector
	 */
	public IConnector getConnector(UUID id){
		
		return listconnector.get(id);
		
	}
	
	/**
	 * Retourne le tableau avec tout les connecteurs existant
	 * @return listconnector type Hashtable
	 */
	public Hashtable getListConnector(){
		return this.listconnector;
	}
	
	/**
	 * Cette méthode va permettre de retrouver les connecteurs déjà sauvegarder
	 * @return
	 * @throws DbException
	 */
	public void ReadFileConfigConnectors() throws XMLConfigException {
		
		try {
			//si le retour est null le fichier de config n'existe pas
			Hashtable tmp = xmlconfig.readConfig();
			if(tmp!=null){this.listconnector = tmp;}
		}
		catch (Exception e){
			throw new XMLConfigException("XMLConfig-0001",e);
		}

	}
	
	/**
	 * 
	 * @throws XMLConfigException
	 */
	public void WriteFileConfigConnectors() throws XMLConfigException {
		
		try{
			xmlconfig.writeConfig(listconnector);			
		}
		catch(Exception e){
			throw new XMLConfigException("XMLConfig-0002",e);
		}
		
	}
	

}
