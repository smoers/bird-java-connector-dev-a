package org.bird.db.adapters;

import java.util.Hashtable;
import java.util.UUID;

import org.bird.db.connectors.IConnector;

public class BuilderAdapter {
	
	private Hashtable<UUID, IAdapter> listadapter;
	
	/** Contructeur privé */
	private BuilderAdapter(){
		listadapter = new Hashtable();
	}
	
	/** Holder */
	private static class SingletonHolder{	
		/** Instance unique non préinitialisée */
		private final static BuilderAdapter instance = new BuilderAdapter();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static BuilderAdapter getInstance(){
		return SingletonHolder.instance;
	}

	public IAdapter getNewAdapter(IConnector connector){
		
		return null;
	}

}
