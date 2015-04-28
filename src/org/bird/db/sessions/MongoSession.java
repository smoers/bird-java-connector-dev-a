package org.bird.db.sessions;

import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import org.bird.db.connectors.IConnector;
import org.bird.db.connectors.MongoConnector;
import org.bird.db.exceptions.DbException;
import org.bird.system.Core;

import com.mongodb.MongoClient;

public class MongoSession implements ISession {
	
	private UUID id;
	private MongoConnector connector;
	private MongoClient mongoclient;
	
	/**
	 * Contructeur
	 * Cette classe permet la connection à un serveur de DB Mongo 
	 * @param connector
	 */
	public MongoSession(MongoConnector connector){
		id = UUID.randomUUID();
		this.connector = connector;
	}
	
	/**
	 * Ouvre une session au serveur MongoDB spécifié dans la classe Connector
	 * @throws DbException
	 */
	public void Open() throws DbException {
		try {
			mongoclient = new MongoClient(connector.getServer(),connector.getPort());
		} catch (UnknownHostException e) {
			throw new DbException("DB-0003",e);
		}
	}

	/**
	 * Retourne l'id de l'instance de cette session
	 * @return UUID
	 */
	@Override
	public UUID getID() {
		return this.id;
	}

	/**
	 * Retourne l'instance de la clasee MongoConnector utilisée dans cette session
	 * @return IConnector
	 */
	@Override
	public IConnector getConnector() {
		// TODO Auto-generated method stub
		return this.connector;
	}

	/**
	 * Retourne un tableau avec les paramêtres du serveur de DB
	 * @return
	 */
	@Override
	public Hashtable<String, Object> getParameter() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retourne la liste de toutes les database bird disponibles sous cette session
	 * @return
	 */
	@Override
	public List getDatabaseList() {
		
		String db = Core.getDatabaseName();
		String whoiam = Core.getDatabaseWhoIam();
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
