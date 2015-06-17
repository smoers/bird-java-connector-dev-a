package org.bird.db.connectors;

import java.util.UUID;

import org.bird.system.EnumBDBC;

public class InfinispanConnector extends Connector {
	
	private String databasepath;
	
	public InfinispanConnector(UUID id, EnumBDBC enumbdbc) {
		super(id, enumbdbc);
	}

	/**
	 * Retourne le chemin des fichiers de base de données
	 * c:\infinispan\ ou /home/<user>/infinispan/ ou ...
	 * @return the databasepath
	 */
	public String getDatabasepath() {
		return databasepath;
	}

	/**
	 * Défini le chemin des fichiers de base de données
	 * c:\infinispan\ ou /home/<user>/infinispan/ ou ...
	 * @param databasepath the databasepath to set
	 */
	public void setDatabasepath(String databasepath) {
		this.databasepath = databasepath;
	}

}
