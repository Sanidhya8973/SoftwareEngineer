package com.company._01__WebMVC.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company._01__WebMVC.model.Inquiry;

@Repository(value = "repository_inquiry")
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

}
