package br.com.univas.si5.incloud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MusicPlayListPK implements Serializable {

	@Column(name="idMusic", nullable=false)
	private Long idMusic;
	
	@Column(name="idPlayList", nullable=false)
	private Long idPlayList;

	
	/**
	 * Getters and Setters
	 */
	public Long getIdMusic() {
		return idMusic;
	}
	public void setIdMusic(Long idMusic) {
		this.idMusic = idMusic;
	}

	public Long getIdPlayList() {
		return idPlayList;
	}
	public void setIdPlayList(Long idPlayList) {
		this.idPlayList = idPlayList;
	}
	
	
}
