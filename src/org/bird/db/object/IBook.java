package org.bird.db.object;

import org.joda.time.DateTime;

public interface IBook {
	
	/*
	 * Set ID
	 * @param id type object
	 */
	public void setID(Object id);
	
	/*
	 * get ID
	 */
	public Object getID();
	
	public void setTitle(String title);
	
	public String getTitle();

	public void setStyle(String style);
	
	public String getStyle();
	
	public void setPresentation(String presentation);
	
	public String getPresentation();
	
	public void setCover(IPhotoOrCover cover);
	
	public IPhotoOrCover getCover();
	
	public void setEditor(String editor);
	
	public String getEditor();
	
	public void setCollection(String collection);
	
	public String getCollection();
	
	public void setISBN(String isbn);
	
	public String getISBN();
	
	/*
	 * set date de creation de l'objet
	 * @param creationdate type org.joda.time.DateTime
	 */
	public void setCreationDate (DateTime creationdate);
	
	/*
	 * get Date de creation de l'objet
	 */
	public DateTime getCreationDate();



	


}
