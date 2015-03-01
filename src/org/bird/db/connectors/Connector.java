package org.bird.db.connectors;

import java.util.UUID;
import org.bird.system.EnumBDBC;

public class Connector implements IConnector {
	
	private UUID id;
	private String name;
	private EnumBDBC enumbdbc;
	
	/**
	 * Constructeur 
	 * @param id : type UUID : identifiant unique
	 * @param enumbdbc : type : enum enumerateur des Bird Database Connector disponible
	 */
	public Connector(UUID id, EnumBDBC enumbdbc){
		this.id=id;
		this.enumbdbc=enumbdbc;
	}


	/**
	 * Retourne l'id du connecteur
	 * @return ID : type UUID 
	 */
	@Override
	public UUID getID() {
		return this.id;
	}

	/**
	 * Defini un nom au connecteur
	 * @param name : type String
	 */
	@Override
	public void setName(String name) {
		this.name=name;
	}

	/**
	 * Retourne le nom du connecteur
	 * @return Name : type String
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Retourne le FQCN de la classe à instancifié pour onbtenir l'adapter 
	 * lié à cette adapter
	 * @return BAdapter String
	 */
	@Override
	public String getBAdapter() {
		return this.enumbdbc.getBAdapter();
	}
	
	/**
	 * Retourne le FQCN de la classe de cette instance de connecteur
	 * @return BDBC String
	 */
	@Override
	public String getBDBC() {
		return this.enumbdbc.getBDBC();
	}

}
