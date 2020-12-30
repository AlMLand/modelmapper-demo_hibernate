package com.morlandalex.jdbc_hibernate_jpa_5.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Audited
@AuditOverride(forClass = AuditableEntity.class)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "album")
public class AlbumEntity extends AuditableEntity<AlbumEntity>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "album_id")
	private Long id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "release_date")
	private LocalDate releaseDate;
	
	@Version
	@Column(name = "version")
	private int version;
	
	@ManyToOne
	@JoinColumn(name = "singer_id")
	private SingerEntity singerId;

	public AlbumEntity(String title, LocalDate releaseDate) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
	}

	public AlbumEntity(String title, LocalDate releaseDate, SingerEntity singerId) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.singerId = singerId;
	}

}
