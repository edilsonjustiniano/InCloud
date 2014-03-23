package br.com.univas.si5.incloud.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@SequenceGenerator(name="user_gen", sequenceName="USER_SEQ", allocationSize=1)
	private Long idUser;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String mail;
	
	//Usada em um relacionamento muitos-para-um (N-1), na classe do lado N, 
	//permitindo que a entidade N consiga acessar a entidade do lado 1
	//Essa anotação apresenta que a classe Atual é o lado N e a classe indicada
	//no atributo é o lado 1 
	
	// fetch = maneira como a lista de elementos do lado N será carregada, nesse caso apenas quando for 
	// chamado o método GET do atributo
	
	//@JoinColumn: usada em conjunto com a anotacao @ManyToOne para indicar ao framework qual 
	//e o campo da chave estrangeira que esta associado com a chave primaria da classe atual, 
	//isto  ́, o campo com @Id do objeto associado a anotacao @ManyToOne.
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUserType", nullable=false)
	private UserType userType;
	
	
	/*
	 * Relacionamento N:1 entre User e Country
	 * User = N
	 * Country = 1
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCountry", nullable=false)
	private Country country;
	
	
	/*
	 * Relacionamento 1:N entre User e Music
	 * User = 1 
	 * Music = N 
	 */
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="user",
				targetEntity=Music.class)
	private Set<Music> musics;
	
	
	/*
	 * Relacionamento 1:N entre Users e PayList
	 * Uer = 1 
	 * PlayList = N
	 */
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="user",
				targetEntity=PlayList.class
			)
	private Set<PlayList> playLists;
	
	
	/**
	 * Getters and Setters
	 */
	public Long getId() {
		return idUser;
	}
	public void setId(Long idUser) {
		this.idUser = idUser;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public UserType getUserType() {
		return userType;
	}
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Set<Music> getMusics() {
		return musics;
	}
	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}
	
	public Set<PlayList> getPlayLists() {
		return playLists;
	}
	public void setPlayLists(Set<PlayList> playLists) {
		this.playLists = playLists;
	}

}
