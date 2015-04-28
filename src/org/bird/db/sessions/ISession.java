package org.bird.db.sessions;

import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import org.bird.db.connectors.IConnector;

public interface ISession {
	
	/**
	 * Retourne l'identifiant de la Session
	 */
	public UUID getID();
	
	/**
	 * Retourne le connecteur associé à cette instance
	 */
	public IConnector getConnector();
	
	/**
	 * Retourne les paramètre du DBEngine sous forme d'un tableau
	 */
	public Hashtable<String, Object> getParameter();

	/**
	 * 
	 *  @return La liste des Database bird disponible sur cette connexion
	 */
	public List getDatabaseList();
}
