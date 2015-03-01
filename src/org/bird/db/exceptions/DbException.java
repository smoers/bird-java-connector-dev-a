package org.bird.db.exceptions;

public class DbException extends Exception {

	/**
	 * Set un message spécifique à l'exception levée par Java et retourne l'exception de java
	 * @param s String
	 * @param e Exception
	 */
	public DbException(String s, Exception e){
		super(s,e);
	}
	
	/**
	 * Set un message spécifique à l'exception levée
	 * @param s String
	 */
	public DbException(String s){
		super(s);
	}
	/*
	 * Contructeur 
	 * @param e : Type java.lang.Exception
	 */
	public DbException(Exception e){
		super(e.getMessage());
	}
}
