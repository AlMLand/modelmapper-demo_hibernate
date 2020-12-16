package com.morlandalex.jdbc_hibernate_jpa_5.domain;

import java.time.LocalDate;
import java.util.Set;

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

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString(exclude = {"version","albumEntities","instrumentEntities"})
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@Audited
@AuditOverride(forClass = AuditableEntity.class) // pozvoljaet vzjat dannie iz superklassa 
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "singer")
public class SingerEntity extends AuditableEntity<SingerEntity>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "singer_id")
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Version
	@Column(name = "singer_version")
	private int version;
	
	@OneToMany(mappedBy = "singerEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<AlbumEntity> albumEntities;
	
	@ManyToMany
	@JoinTable(name = "singer_instrument", 
			joinColumns = @JoinColumn(name = "singer_id"), 
			inverseJoinColumns = @JoinColumn(name = "instrument_id"))		
	private Set<InstrumentEntity> instrumentEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<AlbumEntity> getAlbumEntities() {
		return albumEntities;
	}

	public void setAlbumEntities(Set<AlbumEntity> albumEntities) {
		albumEntities.forEach(albumEntity -> albumEntity.setSingerEntity(this));
		this.albumEntities = albumEntities;
	}

	public boolean addAlbumEntities(AlbumEntity albumEntity) {
		albumEntity.setSingerEntity(this);
		return this.albumEntities.add(albumEntity);
	}
	
	public Set<InstrumentEntity> getInstrumentEntities() {
		return instrumentEntities;
	}

	public void setInstrumentEntities(Set<InstrumentEntity> instrumentEntities) {
		this.instrumentEntities = instrumentEntities;
	}

}
