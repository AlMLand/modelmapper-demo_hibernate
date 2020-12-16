package com.morlandalex.jdbc_hibernate_jpa_5.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"singerEntities"})
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@Audited
@AuditOverride(forClass = AuditableEntity.class)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "instrument")
public class InstrumentEntity extends AuditableEntity<InstrumentEntity>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instrument_id")
	private Long id;

	@Column(name = "instrument")
	private String instrument;

	@ManyToMany
	@JoinTable(name = "singer_instrument", 
				joinColumns = @JoinColumn(name = "instrument_id"), 
				inverseJoinColumns = @JoinColumn(name = "singer_id"))
	private Set<SingerEntity> singerEntities;

}
