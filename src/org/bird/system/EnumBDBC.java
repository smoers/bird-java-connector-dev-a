package org.bird.system;

/**
 * Enumere la liste des connecteurs et des adaptateurs disponible dans la version de Bird
 * @author smoers
 *
 */

public enum EnumBDBC {
	
	   MongoDB("org.bird.db.connectors.MongoConnector","org.bird.db.adapters.MongoAdapter"),
	   BerkeleyDB("org.bird.db.connectors.BerkeleyConnector","org.bird.db.adapters.BerkeleyAdapter"), 
	   SQLite("org.bird.db.connectors.SQLiteConnector","org.bird.db.adapters.SQLiteAdapter"),
	   MapDB("org.bird.db.connectors.MapDBConnector","org.bird.db.adapters.MapDBAdapter");
	   
	   protected String bdbc;
	   protected String badapter;
	 
	   /** Constructeur */
	   EnumBDBC(String bdbc, String badapter) {
	      this.bdbc = bdbc;
	      this.badapter = badapter;
	   }
	 
	   public String getBDBC() {
	      return this.bdbc;
	   }
	   
	   public String getBAdapter(){
		   return this.badapter;
	   }


}
