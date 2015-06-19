package org.bird.db.sessions;

import java.io.File;
import java.lang.annotation.ElementType;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.bird.db.connectors.IConnector;
import org.bird.db.connectors.InfinispanConnector;
import org.bird.db.exceptions.DbException;
import org.bird.db.object.IAuthor;
import org.bird.db.object.infinispan.AuthorInfinispan;
import org.bird.db.object.infinispan.BookInfinispan;
import org.bird.db.object.infinispan.CycleInfinispan;
import org.bird.system.Core;
import org.hibernate.search.cfg.Environment;
import org.hibernate.search.cfg.SearchMapping;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.cache.Index;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

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
		
		EmbeddedCacheManager manager = new DefaultCacheManager();
		ConfigurationBuilder cb = new ConfigurationBuilder();
		SearchMapping mapping = new SearchMapping();
		
		mapping.entity(AuthorInfinispan.class).indexed().providedId()
		.property("lastname", ElementType.METHOD).field()
		.property("firstname", ElementType.METHOD).field()
		.property("authoralias", ElementType.METHOD).field();

	
		mapping.entity(CycleInfinispan.class).indexed().providedId()
		.property("cycletitle", ElementType.METHOD).field();
	
		mapping.entity(BookInfinispan.class).indexed().providedId()
		.property("title", ElementType.METHOD).field()
		.property("style", ElementType.METHOD).field();
				
		Properties properties = new Properties();
		properties.put(Environment.MODEL_MAPPING, mapping);
	
		Configuration c = cb.indexing()
				.index(Index.LOCAL)
				.withProperties(properties)
				.persistence()
				.passivation(false)
				.addSingleFileStore()
				.preload(true)
				.shared(false)
				.fetchPersistentState(true)
				.ignoreModifications(false)
				.purgeOnStartup(false)
				.location("D:/infinispan")
				.build();
	
		manager.defineConfiguration("book012015", c);
	
		Cache<UUID, IAuthor> cache = manager.getCache("book012015"); 

		return cache;
	}
}
