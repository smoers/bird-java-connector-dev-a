package org.bird.db.connectors;

import java.util.UUID;
import org.bird.system.EnumBDBC;

public class MongoConnector extends Connector {
	
	private String server;
	private int port;

	
	/**
	 * Constructeur 
	 * @param id : type UUID : identifiant unique
	 * @param enumbdbc : type : enum enumerateur des Bird Database Connector disponible
	 */
	public MongoConnector(UUID id, EnumBDBC enumbdbc){
		super(id, enumbdbc);
	}

	public String getServer(){
		return this.server;
	}
	
	public int getPort(){
		return this.port;
	}

}
