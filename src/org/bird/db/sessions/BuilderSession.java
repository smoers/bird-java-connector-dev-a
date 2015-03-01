package org.bird.db.sessions;

import java.util.Hashtable;
import java.util.UUID;

public class BuilderSession {
	
	private Hashtable<UUID, ISession> listsession;
	
	/** Contructeur privé */
	private BuilderSession(){
		listsession = new Hashtable();
	}
	
	/** Holder */
	private static class SingletonHolder{	
		/** Instance unique non préinitialisée */
		private final static BuilderSession instance = new BuilderSession();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static BuilderSession getInstance(){
		return SingletonHolder.instance;
	}

	public ISession getNewSession(ISession session){
		
		return null;
	}

}
