package com.metrorecruitmentapplication.repository;

import com.metrorecruitmentapplication.domain.ApplicantInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantInfoRepository extends JpaRepository<ApplicantInfo,Long> {
}
