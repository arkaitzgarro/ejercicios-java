package com.arkaitzgarro.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.Hibernate;

@Entity
@Table(name = "actor")
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = " last_name")
	private String lastName;

	@ManyToMany(mappedBy = "actors", fetch = FetchType.EAGER)
	private List<Film> films;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<Film> getFilms() {
		Hibernate.initialize(films);

		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
}
