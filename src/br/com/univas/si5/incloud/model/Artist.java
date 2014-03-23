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
import javax.persistence.Table;

@Entity
@Table(name="Artist")
public class Artist implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idArtist;
	
	@Column(nullable=false)
	private String name;

	/*
	 * Relacionamento N:1 entre Artist e Style
	 * Artist = N
	 * Style  = 1
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idStyle", nullable=false)
	private Style style;
	
	/*
	 * Relacionamento N:1 entre Artist e Country
	 * Artist = N
	 * Country= 1
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCountry", nullable=false)
	private Country country;
	
	
	/*
	 * Relacionamento 1: N entre Artist e Music
	 * Artist = 1
	 * Music = N
	 */
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="artist",
				targetEntity=Music.class)
	private Set<Music> musics;
	
	/**
	 * Getters and Setters
	 */
	public Long getIdArtist() {
		return idArtist;
	}
	public void setIdArtist(Long idArtist) {
		this.idArtist = idArtist;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
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
}
