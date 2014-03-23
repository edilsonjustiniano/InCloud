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
@Table(name="Country")
public class Country implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCountry;
	
	@Column(nullable=false)
	private String name;
	
	/*
	 * Relacionamento 1:N entre Country e Artist
	 * Country = 1
	 * Artist = N
	 */
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="country",
				targetEntity=Artist.class
			)
	private Set<Artist> artists;
	
	/*
	 * Relacionamento 1:N entre Country e User
	 * Country = 1
	 * User = N
	 */
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="country",
				targetEntity=User.class
				)
	private Set<User> users;
	
	/**
	 * Getters and Setters
	 */
	public Long getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Artist> getArtists() {
		return artists;
	}
	public void setArtists(Set<Artist> artists) {
		this.artists = artists;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
