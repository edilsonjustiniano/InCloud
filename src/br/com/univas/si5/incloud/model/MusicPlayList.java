package br.com.univas.si5.incloud.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="MusicPlayList")
public class MusicPlayList implements Serializable{

	@EmbeddedId
	@NotNull
	private MusicPlayListPK id;

	/**
	 * Getters and Setters
	 */
	public MusicPlayListPK getId() {
		return id;
	}
	public void setId(MusicPlayListPK id) {
		this.id = id;
	}
	
	
}
