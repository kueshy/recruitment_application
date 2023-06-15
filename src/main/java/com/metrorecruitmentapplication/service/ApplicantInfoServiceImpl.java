package com.metrorecruitmentapplication.service;

import com.metrorecruitmentapplication.domain.ApplicantInfo;
import com.metrorecruitmentapplication.dto.ApplicantInfoDTO;
import com.metrorecruitmentapplication.emumerations.CurrentEmploymentStatus;
import com.metrorecruitmentapplication.emumerations.Gender;
import com.metrorecruitmentapplication.emumerations.HighestAcademicQualification;
import com.metrorecruitmentapplication.repository.ApplicantInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicantInfoServiceImpl implements ApplicantInfoservice{

    private final ApplicantInfoRepository repository;

    @Override
    public ApplicantInfoDTO createApplicantInfo(ApplicantInfoDTO applicantInfoDTO) {
        ApplicantInfo applicantInfo = toEntity(applicantInfoDTO);
        applicantInfo = repository.save(applicantInfo);
        return toDto(applicantInfo);
    }

    @Override
    public Page<ApplicantInfo> listAllApplicants(Pageable pageable) {
        return repository.findAll(pageable);
    }

    private ApplicantInfoDTO toDto(ApplicantInfo applicantInfo) {
        ApplicantInfoDTO applicantInfoDTO = ApplicantInfoDTO.builder()
                .applicant_id(applicantInfo.getApplicant_id())
                .first_name(applicantInfo.getFirst_name())
                .second_name(applicantInfo.getSecond_name())
                .last_name(applicantInfo.getLast_name())
                .gender(Gender.valueOf(applicantInfo.getGender()))
                .current_employment_status(CurrentEmploymentStatus.valueOf(applicantInfo.getCurrent_employment_status()))
                .highest_academic_qualification(HighestAcademicQualification.valueOf(applicantInfo.getHighest_academic_qualification()))
                .date_of_birth(applicantInfo.getDate_of_birth())
                .email(applicantInfo.getEmail())
                .nationality(applicantInfo.getNationality())
                .nationality_id_no(applicantInfo.getNationality_id_no())
                .phone_number(applicantInfo.getPhone_number())
                .position_and_interview_year(applicantInfo.getPosition_and_interview_year())
                .prior_company(applicantInfo.getPrior_company())
                .prior_interview(applicantInfo.getPrior_interview())
                .professional_qualification(applicantInfo.getProfessional_qualification())
                .specialization(applicantInfo.getSpecialization())
                .years_of_experience(applicantInfo.getYears_of_experience())
                .build();
        return applicantInfoDTO;
    }

    private ApplicantInfo toEntity(ApplicantInfoDTO applicantInfoDTO) {
        ApplicantInfo applicantInfo = ApplicantInfo.builder()
                .date_of_birth(applicantInfoDTO.getDate_of_birth())
                .email(applicantInfoDTO.getEmail())
                .gender(applicantInfoDTO.getGender().name())
                .first_name(applicantInfoDTO.getFirst_name())
                .second_name(applicantInfoDTO.getSecond_name())
                .last_name(applicantInfoDTO.getLast_name())
                .current_employment_status(applicantInfoDTO.getCurrent_employment_status().name())
                .highest_academic_qualification(applicantInfoDTO.getHighest_academic_qualification().name())
                .nationality(applicantInfoDTO.getNationality())
                .phone_number(applicantInfoDTO.getPhone_number())
                .nationality_id_no(applicantInfoDTO.getNationality_id_no())
                .prior_company(applicantInfoDTO.getPrior_company())
                .prior_interview(applicantInfoDTO.getPrior_interview())
                .position_and_interview_year(applicantInfoDTO.getPosition_and_interview_year())
                .professional_qualification(applicantInfoDTO.getProfessional_qualification())
                .years_of_experience(applicantInfoDTO.getYears_of_experience())
                .specialization(applicantInfoDTO.getSpecialization())
                .build();
        return applicantInfo;
    }
}
