package com.example.board.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=100)
	private String writer;
	
	@Column(nullable=false)
	private String title;
	
	@Lob
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	
	@Column(columnDefinition="BIGINT(20) DEFAULT 0")
	private long hitCount;

//	public static int seekOffset(int page, int size) {
//		if (page > 0) {
//			return (page - 1) * size;
//		}
//		return 0;
//	}
}
