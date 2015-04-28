package org.bird.db.sessions;

import java.lang.reflect.Constructor;
import java.util.Hashtable;
import java.util.UUID;

import org.bird.db.exceptions.DbException;
import org.bird.system.EnumBDBC;

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

	public ISession getNewSession(EnumBDBC enumbdbc) throws DbException {
		
		Constructor c;
		ISession session;
		
		try{
			
			c = Class.forName(enumbdbc.getBSession()).getConstructor(EnumBDBC.class);
			
		} catch (Exception e) {
			throw new DbException("Db-0002",e);
		};
		
		return null;
	}

}
