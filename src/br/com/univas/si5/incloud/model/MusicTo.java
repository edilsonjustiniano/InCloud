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
@Table(name="MusicTo")
public class MusicTo implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMusicTo;
	
	@Column(nullable=false)
	private String description;

	/*
	 * Relacionamento 1:N entre MusicTo e Music
	 * MusicTo = 1
	 * Music = N
	 */
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="musicTo",
				targetEntity=Music.class)
	private Set<Music> musics;
	
	
	/**
	 * Getters and Setters
	 */
	public Long getIdMusicTo() {
		return idMusicTo;
	}
	public void setIdMusicTo(Long idMusicTo) {
		this.idMusicTo = idMusicTo;
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
