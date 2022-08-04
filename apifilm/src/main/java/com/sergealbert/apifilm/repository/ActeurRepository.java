package com.sergealbert.apifilm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sergealbert.apifilm.model.Acteur;


public interface ActeurRepository extends JpaRepository<Acteur, Long> {

}
