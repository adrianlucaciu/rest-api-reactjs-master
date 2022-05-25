package com.mightyjava.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_lines")
public class Lines {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String lineNumber;

	@Column(nullable = false)
	private String firstStation;

	@Column(nullable = false)
	private String finalStation;

	@Column(nullable = false)
	private Long isbnNumber;

	@Column(nullable = false)
	private Double stations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLineNumber(String title) {
		this.lineNumber = title;
	}

	public String getFirstStation() {
		return firstStation;
	}

	public void setFirstStation(String author) {
		this.firstStation = author;
	}

	public String getFinalStation() {
		return finalStation;
	}

	public void setFinalStation(String coverPhotoURL) {
		this.finalStation = coverPhotoURL;
	}

	public Long getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(Long isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public Double getStations() {
		return stations;
	}

	public void setStations(Double price) {
		this.stations = price;
	}

}
