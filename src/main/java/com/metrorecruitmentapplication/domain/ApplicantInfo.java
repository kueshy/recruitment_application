package com.metrorecruitmentapplication.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Table(name = "tbl_metro_recruitment", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
public class ApplicantInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long applicant_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "second_name")
    private String second_name;
    @Column(name = "last_name")
    private String last_name;
    @JsonFormat(pattern = "mm/dd/yyyy")
    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;
    @Column(name = "gender")
    private String gender;
    //    private AttachDocument document;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "nationality_id_no")
    private int nationality_id_no;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "phone_number")
    private int phone_number;
    @Column(name = "highest_academic_qualification")
    private String highest_academic_qualification;
    @Column(name = "prior_interview")
    private String prior_interview;
    @Column(name = "position_and_interview_year")
    private String position_and_interview_year;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "professional_qualification")
    private String professional_qualification;
    @Column(name = "prior_company")
    private String prior_company;
    @Column(name = "years_of_experience")
    private int years_of_experience;
    @Column(name = "current_employment_status")
    private String current_employment_status;
    @Column(name = "file_name", columnDefinition = "BLOB")
    private byte[] file_name;
}
