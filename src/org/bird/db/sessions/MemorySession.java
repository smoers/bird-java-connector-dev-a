package org.bird.db.sessions;

import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import org.bird.db.connectors.IConnector;
import org.bird.db.connectors.MemoryConnector;
import org.bird.db.exceptions.DbException;

public class MemorySession implements ISession {
	
	private UUID id;
	private MemoryConnector connector;
	
	public MemorySession(MemoryConnector connector){
		this.id = UUID.randomUUID();
		this.connector = connector;
		
	}

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getDatabaseList() throws DbException {
		// TODO Auto-generated method stub
		return null;
	}

}
