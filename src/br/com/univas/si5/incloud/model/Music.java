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
@Table(name="Music")
public class Music implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMusic;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String path;

	/*
	 * Relacionameto N:1 entre Music e MusicTo
	 * Music = N
	 * MusicTo = 1
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMusicTo",nullable=false)
	private MusicTo musicTo;
	
	
	/*
	 * Relacionamento N:1 entre Music e TypeMusic
	 * Music = N
	 * TypeMusic = 1
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMusicType", nullable=false)
	private TypeMusic typeMusic;
	
	
	/*
	 * Relacionamento 1:N entre Music e History
	 * Music = 1
	 * history = N
	 */
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="music",
				targetEntity=History.class
			)
	private Set<History> histories;
	
	
	/*
	 * Relacionamento N: 1 entre Music e Artis
	 * Music = N
	 * Artist = 1
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idArtist", nullable=false)
	private Artist artist;

	
	/*
	 * Relacionamento N:1 entre Music e User
	 * Music = N 
	 * User = 1 
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser", nullable=false)
	private User user;
	
	/**
	 * Getters and Setters
	 */
	public Long getIdMusic() {
		return idMusic;
	}
	public void setIdMusic(Long idMusic) {
		this.idMusic = idMusic;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public MusicTo getMusicTo() {
		return musicTo;
	}
	public void setMusicTo(MusicTo musicTo) {
		this.musicTo = musicTo;
	}
	
	public TypeMusic getTypeMusic() {
		return typeMusic;
	}
	public void setTypeMusic(TypeMusic typeMusic) {
		this.typeMusic = typeMusic;
	}
	
	public Set<History> getHistories() {
		return histories;
	}
	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}
	
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
