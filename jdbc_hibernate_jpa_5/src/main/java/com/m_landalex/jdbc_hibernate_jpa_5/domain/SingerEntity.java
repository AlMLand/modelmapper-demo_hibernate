package com.m_landalex.jdbc_hibernate_jpa_5.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Audited
@EntityListeners(AuditingEntityListener.class)
@AuditOverride(forClass = AuditableEntity.class)
@Entity
@Table(name = "singer")
public class SingerEntity extends AuditableEntity<SingerEntity>{

	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "singer_id")
	private Long id;
	
	@Setter
	@Column(name = "first_name")
	private String firstName;
	
	@Setter
	@Column(name = "last_name")
	private String lastName;
	
	@Setter
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Setter
	@Version
	@Column(name = "singer_version")
	private int version;
	
	@OneToMany(mappedBy = "singerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AlbumEntity> albums;
	
	@Setter
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "singer_instrument", 
			joinColumns = @JoinColumn(name = "singer_id"), 
			inverseJoinColumns = @JoinColumn(name = "instrument_id"))		
	private List<InstrumentEntity> instruments;

	public SingerEntity(String firstName, String lastName, LocalDate birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public void setAlbums(List<AlbumEntity> albums) {
		albums.forEach(album -> album.setSingerId(this));
		this.albums = albums;
	}

}
