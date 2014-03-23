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
@Table(name="TypeMusic")
public class TypeMusic implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTypeMusic;
	
	@Column(nullable=false)
	private String description;

	/*
	 * Relacionamento 1:N entre TypeMusic e Music
	 * TypeMusic = 1
	 * Music = N
	 */
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="typeMusic",
				targetEntity=Music.class)
	private Set<Music> musics;
	
	
	/**
	 * Getters and Setters
	 */
	public Long getIdTypeMusic() {
		return idTypeMusic;
	}
	public void setIdTypeMusic(Long idTypeMusic) {
		this.idTypeMusic = idTypeMusic;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Music> getMusics() {
		return musics;
	}
	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}
	
}
