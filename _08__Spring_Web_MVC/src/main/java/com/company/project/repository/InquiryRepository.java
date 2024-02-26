package com.company.project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company.project.model.Inquiry;

@Repository(value = "repository_inquiry")
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

}
