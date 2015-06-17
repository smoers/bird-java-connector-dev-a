package org.bird.db.object.infinispan;

import java.io.Serializable;

import javax.persistence.Id;

import org.bird.db.object.IWhoIam;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

public class WhoIamInfinispan implements IWhoIam, Serializable {
	
	@Field(store=Store.YES, index=Index.YES)
	private String databasename;
	@Field(store=Store.YES, index=Index.YES)
	private String databasedescription;
	@Id
	private String databaseid;

	@Override
	public String getDatabaseName() {
		return this.databasename;
	}

	@Override
	public void setDatabaseName(String databasename) {
		this.databasename = databasename;
	}

	@Override
	public String getDatabaseDesciption() {
		return this.databasedescription;
	}

	@Override
	public void setDatabaseDescription(String databasedescription) {
		this.databasedescription = databasedescription;
	}

	@Override
	public String getDatabaseId() {
		return this.databaseid;
	}

}
