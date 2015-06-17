package org.bird.db.sessions;

import java.io.File;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import org.bird.db.connectors.IConnector;
import org.bird.db.connectors.InfinispanConnector;
import org.bird.db.exceptions.DbException;
import org.bird.system.Core;
import org.infinispan.Cache;

public class InfinispanSession implements ISession {
	
	private UUID id;
	private InfinispanConnector connector;
	
	public InfinispanSession(InfinispanConnector connector) {
		this.connector = connector;
	}

	private Hashtable<String, Object> parameters;

	@Override
	public UUID getID() {
		return this.id;
	}

	@Override
	public IConnector getConnector() {
		return this.connector;
	}

	@Override
	public Hashtable<String, Object> getParameter() {
		return null;
	}

	@Override
	public List getDatabaseList() throws DbException {
		
		try{
			String cachepath = this.connector.getDatabasepath()+"/"+Core.getDatabaseName();
			//Vérifie l'existence du répertoire avec les caches files
			if(new File(cachepath).exists()){
				cachepath = cachepath+"/"+Core.getDatabaseWhoIam();
				//Vérifie l'existence du fichier de cache pour les objets WhoIam
				if(new File(cachepath).exists()){
					
					//Infinispan cache
					
					//
					
				}
				else{
					throw new  DbException("infinispan-002");
				}
			}
			else{
				throw new  DbException("infinispan-001");
			}
			
		}catch(Exception e){
			
		}
					
		return null;
	}

	public Cache getCache(){
		
		Cache cache<
		
		return null;
	}
}
