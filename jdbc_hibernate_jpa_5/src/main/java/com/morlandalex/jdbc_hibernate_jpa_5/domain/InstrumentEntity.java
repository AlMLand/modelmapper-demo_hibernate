package com.morlandalex.jdbc_hibernate_jpa_5.domain;

import java.util.List;

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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
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
	private List<SingerEntity> singers;

	public InstrumentEntity(String instrument) {
		super();
		this.instrument = instrument;
	}

}
