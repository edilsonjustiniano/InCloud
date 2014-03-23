package br.com.univas.si5.incloud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Entity;

@Entity
@Table(name="History")
public class History implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHistory;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	
	/*
	 * Relacionamento N:1 entre History e Music
	 * History = N
	 * Music = 1
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMusic", nullable=false)
	private Music music;
	
	
	/**
	 * Getters and Setters
	 */
	public Long getIdHistory() {
		return idHistory;
	}
	public void setIdHistory(Long idHistory) {
		this.idHistory = idHistory;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Music getMusic() {
		return music;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
	
}
