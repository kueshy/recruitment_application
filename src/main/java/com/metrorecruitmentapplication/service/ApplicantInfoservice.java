package com.metrorecruitmentapplication.service;

import com.metrorecruitmentapplication.dto.ApplicantInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ApplicantInfoservice {
    ApplicantInfoDTO createApplicantInfo(ApplicantInfoDTO applicantInfoDTO);
    Page listAllApplicants(Pageable pageable);
}
