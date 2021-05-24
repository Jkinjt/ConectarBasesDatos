/**
 * 
 */
package model;

/**
 * @author Joaquin
 *Clase que recoge la información de cada atributo de la tabla en sql
 */
public class Atribute {
	private String name;
	private String type;
	private String valor;
	
	
	public Atribute() {
		super();
	}


	public Atribute(String atributte, String type) {
		super();
		this.name = atributte;
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	

	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	@Override
	public String toString() {
		return "Table [atributte=" + name + ", type=" + type + "]";
	}
	
	
	
	

}
