package br.com.univas.si5.incloud.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UserType")
public class UserType implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUserType;
	
	@Column(nullable=false)
	private String description;

	// MappedBy = nome do atributo na classe do lado N (nesse caso a classe User) que se 
	// refere a classe do lado 1 [relacionamento 1:N 1 = UserType n = User] o nome deve ser igual
	// ao do atributo na classe do lado N
	// targetEntity = Classe correspondente do lado N (nesse caso a classe User)
	// fetch = maneira como a lista de elementos do lado N será carregada, nesse caso apenas quando for 
	// chamado o método GET do atributo
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="userType", 
				targetEntity=User.class)
	private Set<User> users;
	
	
	/**
	 * Getters and Setters
	 */
	public Long getIdUserType() {
		return idUserType;
	}
	public void setIdUserType(Long idUserType) {
		this.idUserType = idUserType;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	

}
