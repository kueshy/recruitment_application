package com.metrorecruitmentapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long file_id;
    @Column(name = "file_name", columnDefinition = "BLOB")
    private byte[] file_name;
}
