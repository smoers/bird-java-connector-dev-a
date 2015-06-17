package org.bird.db.object;

/**
 * Interface pour d�finir les objets de contr�le des DB
 * @author a49974
 *
 */
public interface IWhoIam {
	
	/**
	 * Retourne le nom de la DB d�fini par l'utilisateur
	 * @return DB Name Type String
	 */
	public String getDatabaseName();
	
	/**
	 * D�fini le nom de la DB
	 * @param databasename
	 */
	public void setDatabaseName(String databasename);
	
	/**
	 * Retourne la description de la DB d�finie par l'utilisateur
	 * @return Description Type String
	 */
	public String getDatabaseDesciption();
	
	/**
	 * D�fini la description de la DB
	 * @param databasedescription
	 */
	public void setDatabaseDescription(String databasedescription);
	
	/**
	 * Retourne l'ID de la DB
	 * Celui-ci doit �tre calcul� par l'objet Adaptor
	 * @return
	 */
	public String getDatabaseId();
	
}
