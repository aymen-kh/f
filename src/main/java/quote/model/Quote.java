package quote.model;

import java.io.Serializable;

public class Quote implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
private String contenu;
private String auteur;
private String source;

public Quote() {
	super();}



public Quote(int id, String contenu, String auteur, String source) {
	super();
	this.id = id;
	this.contenu = contenu;
	this.auteur = auteur;
	this.source = source;
}

public Quote(String contenu, String auteur, String source) {
	super();
	this.contenu = contenu;
	this.auteur = auteur;
	this.source = source;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContenu() {
	return contenu;
}
public void setContenu(String contenu) {
	this.contenu = contenu;
}
public String getAuteur() {
	return auteur;
}
public void setAuteur(String auteur) {
	this.auteur = auteur;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}


}
