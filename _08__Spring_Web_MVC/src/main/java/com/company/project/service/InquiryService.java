package com.company.project.service;

import com.company.project.repository.InquiryRepository;
import org.springframework.stereotype.Service;

@Service(value = "service_inquiry")
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }



}
