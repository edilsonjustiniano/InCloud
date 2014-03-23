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
@Table(name="Style")
public class Style implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStyle;
	
	@Column(nullable=false)
	private String name;

	/*
	 * Relacionamento 1:N entre Style e Artist
	 * Style = 1 
	 * Artist = N
	 */
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="style",
				targetEntity=Artist.class)
	private Set<Artist> artists;
	
	
	/**
	 * Getters and Setters
	 */
	public Long getIdStyle() {
		return idStyle;
	}
	public void setIdStyle(Long idStyle) {
		this.idStyle = idStyle;
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
	
	

}
