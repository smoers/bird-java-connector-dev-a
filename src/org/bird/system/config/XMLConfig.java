package org.bird.system.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Writer;


import com.thoughtworks.xstream.XStream;

public class XMLConfig<T> {
	
	private String path;
	private String filename;
	private XStream xstream;
	private T config;
	
	/**
	 * Constructeur
	 * @param path Type String Chemin du fcihier de configuration
	 * @param filename Type String Nom du fichier de configuration
	 */
	public XMLConfig(String path, String filename){
		this.path = path;
		this.filename = filename;
		//structure le chemin et le nom du ficher
		if(!this.path.endsWith("/")){this.path = this.path+"/";}
		if(this.filename.startsWith("/")){this.filename = this.filename.replace("/", "");}
		xstream = new XStream();
	}
	
	/**
	 * Permet la lecture du fichier de configuration depuis le disque
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public T readConfig() throws IOException, ClassNotFoundException{
		
		T config = null;
		
		if(this.XMLConfigExist()){
			Reader reader = new FileReader(path+filename);
			ObjectInputStream in = xstream.createObjectInputStream(reader);
			config =  (T) in.readObject();
			in.close();
			reader.close();
		}
		
		return config;
	}
	
	
	public void writeConfig(T config) throws IOException{
		
		Writer writer = new FileWriter(path+filename);		
		ObjectOutputStream out = xstream.createObjectOutputStream(writer, filename);
		out.writeObject(config);
		out.close();
		writer.close();
		
	}

	/**
	 * Retourne le chemin du fichier config
	 * @return path type String
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * Retourne le nom du fichier de config
	 * @return filename type String
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Controle l'existance du fichier de config
	 * @return boolean
	 */
	public boolean XMLConfigExist(){
		
		File file = new File(path+filename);
		return file.exists();
		
	}

}
