package com.metrorecruitmentapplication.dto;

import com.metrorecruitmentapplication.emumerations.CurrentEmploymentStatus;
import com.metrorecruitmentapplication.emumerations.Gender;
import com.metrorecruitmentapplication.emumerations.HighestAcademicQualification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@SuperBuilder
public class ApplicantInfoDTO {
    private Long applicant_id;
    @NotEmpty
    private String first_name;
    private String second_name;
    @NotEmpty
    private String last_name;
    private LocalDate date_of_birth;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    //    private AttachDocument document;
    private String nationality;
    private int nationality_id_no;
    @NotEmpty
    private String email;
    private int phone_number;
    @Enumerated(EnumType.STRING)
    private HighestAcademicQualification highest_academic_qualification;
    private String prior_interview;
    private String position_and_interview_year;
    private String specialization;
    private String professional_qualification;
    private String prior_company;
    private int years_of_experience;
    @Enumerated(value = EnumType.STRING)
    private CurrentEmploymentStatus current_employment_status;
//    @NotEmpty
//    private byte[] file_document;
    private String file_name;
}
