package br.com.univas.si5.incloud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PlayList")
public class PlayList implements Serializable {

	
	@Id
	private Long idPlayList;
	
	@Column(nullable=false)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdIn;

	
	/*
	 * Relacionamento N:1 entre PlayList e Users
	 * PlayList = N
	 * User = 1
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser", nullable=false)
	private User user;
	
	/**
	 * Getters and Setters
	 */
	public Long getIdPlayList() {
		return idPlayList;
	}

	public void setIdPlayList(Long idPlayList) {
		this.idPlayList = idPlayList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(Date createdIn) {
		this.createdIn = createdIn;
	}
	
	
}
