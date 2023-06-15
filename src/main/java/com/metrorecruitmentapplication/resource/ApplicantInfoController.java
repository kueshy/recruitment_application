package com.metrorecruitmentapplication.resource;

import com.metrorecruitmentapplication.domain.ApplicantInfo;
import com.metrorecruitmentapplication.domain.HttpResponse;
import com.metrorecruitmentapplication.dto.ApplicantInfoDTO;
import com.metrorecruitmentapplication.service.ApplicantInfoServiceImpl;
import com.metrorecruitmentapplication.service.ApplicantInfoservice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ApplicantInfoController {

    private final ApplicantInfoservice applicantInfoservice;

    @PostMapping("/new_applicant")
    public ResponseEntity<HttpResponse> createApplicant(@RequestBody ApplicantInfoDTO applicantInfo
//                                                        @RequestParam("file")MultipartFile multipartFile
    ) throws IOException {
        ApplicantInfoDTO applicantInfoDTO = applicantInfoservice.createApplicantInfo(applicantInfo);

        return ResponseEntity.created(null).body(
                HttpResponse.builder().timestamp((Instant.now().toString())
                        )
                        .data(Map.of("Applicant info", applicantInfoDTO))
                        .message("Application created")
                        .developerMessage("This is still raw, more things to be added")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/allApplicants")
    public ResponseEntity<Page<ApplicantInfo>> getAllApplicantsInfo(@RequestParam(value = "page", required = false) Integer page,
                                                                    @RequestParam(value = "size", required = false) Integer size){
        Pageable pageable = PageRequest.of(0,15);
        if(page != null && size != null){
            pageable = PageRequest.of(page,size);
        }
        try{
            Page<ApplicantInfo> pages = applicantInfoservice.listAllApplicants(pageable);

            return ResponseEntity.ok(pages);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
