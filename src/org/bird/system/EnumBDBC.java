package org.bird.system;

/**
 * Enumere la liste des connecteurs et des adaptateurs disponible dans la version de Bird
 * @author smoers
 *
 */

public enum EnumBDBC {
	
	   MongoDB("org.bird.db.connectors.MongoConnector","org.bird.db.adapters.MongoAdapter","org.bird.db.sessions.MongoSession"),
	   BerkeleyDB("org.bird.db.connectors.BerkeleyConnector","org.bird.db.adapters.BerkeleyAdapter","org.bird.db.sessions.BerkeleySession"), 
	   SQLite("org.bird.db.connectors.SQLiteConnector","org.bird.db.adapters.SQLiteAdapter","org.bird.db.sessions.SQLiteSession"),
	   MapDB("org.bird.db.connectors.MapDBConnector","org.bird.db.adapters.MapDBAdapter","org.bird.db.sessions.MapDBSession");
	   
	   protected String bdbc;
	   protected String badapter;
	   protected String bsession;
	 
	   /** Constructeur */
	   EnumBDBC(String bdbc, String badapter, String bsession) {
	      this.bdbc = bdbc;
	      this.badapter = badapter;
	      this.bsession = bsession;
	   }
	 
	   public String getBDBC() {
	      return this.bdbc;
	   }
	   
	   public String getBAdapter(){
		   return this.badapter;
	   }
	   
	   public String getBSession(){
		   return this.bsession;
	   }


}
