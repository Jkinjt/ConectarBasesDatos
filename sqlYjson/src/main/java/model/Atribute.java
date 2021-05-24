/**
 * 
 */
package model;

import Utils.TypeSql;

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

	
	public TypeSql getTypeInt() {
		TypeSql result=TypeSql.empty;
		if(type!=null) {
			if(this.type.contains("int")) {
				result=TypeSql.integer;	
						
			}else if(this.type.contains("varchar")) {
				result=TypeSql.varchar;	
			}else if(this.type.contains("date")) {
				result=TypeSql.date;
			}
			
		}
		
		return result;
	}


	@Override
	public String toString() {
		return "Atribute [name=" + name + ", type=" + type + ", valor=" + valor + "]";
	}

	
	
	
	
	

}
