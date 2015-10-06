/**
 * Cette classe qui �tend la classe Connector va permettre
 * de r�f�rencer un d�p�t dans lequel seront stock�s les fichiers de
 * sauvegarde des DB de type memory
 */
package org.bird.db.connectors;

import java.util.UUID;

import org.bird.system.EnumBDBC;

public class MemoryConnector extends Connector {
	
	private String path = null;

	public MemoryConnector(UUID id, EnumBDBC enumbdbc, String path) {
		super(id, enumbdbc);
		this.setPath(path);
		
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

}
