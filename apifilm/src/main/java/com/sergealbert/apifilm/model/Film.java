package com.sergealbert.apifilm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "FILM")
@NoArgsConstructor
public class Film {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titre;
	private String description;
	
	/*
	 * @ManyToMany(fetch = FetchType.EAGER)
	 * 
	 * @JoinTable( name = "JOUER", //Nom de la table de jointure joinColumns
	 * = @JoinColumn(name="ID_FILM"), //champ de la table de jointure
	 * inverseJoinColumns = @JoinColumn(name="ID_ACTEUR")//champ de la table de
	 * jointure )
	 */
	
	@ManyToMany(fetch = FetchType.LAZY,
	    cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
    })
	@JoinTable(name = "JOUER",
      joinColumns = { @JoinColumn(name = "ID_FILM") },
      inverseJoinColumns = { @JoinColumn(name = "ID_ACTEUR") })
	private Set<Acteur> acteurs = new HashSet<>();
}
