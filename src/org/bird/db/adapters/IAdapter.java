package org.bird.db.adapters;

import java.util.Hashtable;
import java.util.UUID;

import org.bird.db.object.IAuthor;

/*
 * Cette interface doit être utilisée pour les adapter entre le GUI et la DB
 */
public interface IAdapter<T> {

	/*
	 * Permet de charger depuis la DB un objet à l'aide du UUID
	 */
	public T load(UUID id);
	
	/*
	 * Permet de sauver dans la DB un objet de type T
	 */
	public boolean save(T value);
	
	/*
	 * Permet de supprimer dans la DB un objet de type T
	 */
	public boolean delete(T value);
	
	/*
	 * Permet de modifier dans la DB un objet de type T
	 */
	public boolean modify(T value);
	
	/*
	 * Permet de faire une recherche dans la DB d'un objet de type T
	 * à l'aide des valeurs des propriétés de l'objet passé en paramêtre.
	 * Retourne toujours une collection d'interface Author
	 */
	public Hashtable<UUID,IAuthor> search(T value); 
	
	/*
	 * Permet de faire une recherche dans la DB à l'aide de la chaine de caractère
	 * passé en paramètre. 
	 * Retourne toujours une collection d'interface Author
	 */
	public Hashtable<UUID, IAuthor> search(String value);
	
}
