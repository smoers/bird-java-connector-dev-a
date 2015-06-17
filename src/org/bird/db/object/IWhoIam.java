package org.bird.db.object;

/**
 * Interface pour définir les objets de contrôle des DB
 * @author a49974
 *
 */
public interface IWhoIam {
	
	/**
	 * Retourne le nom de la DB défini par l'utilisateur
	 * @return DB Name Type String
	 */
	public String getDatabaseName();
	
	/**
	 * Défini le nom de la DB
	 * @param databasename
	 */
	public void setDatabaseName(String databasename);
	
	/**
	 * Retourne la description de la DB définie par l'utilisateur
	 * @return Description Type String
	 */
	public String getDatabaseDesciption();
	
	/**
	 * Défini la description de la DB
	 * @param databasedescription
	 */
	public void setDatabaseDescription(String databasedescription);
	
	/**
	 * Retourne l'ID de la DB
	 * Celui-ci doit être calculé par l'objet Adaptor
	 * @return
	 */
	public String getDatabaseId();
	
}
