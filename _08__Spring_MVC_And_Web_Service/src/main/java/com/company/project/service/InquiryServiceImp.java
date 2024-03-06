package com.company.project.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.service.interfaces.InquiryService;
import com.company.project.repository.InquiryRepository;
import com.company.project.model.Inquiry;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

@Service(value = "service_inquiry")
public class InquiryServiceImp implements InquiryService {

    private final InquiryRepository inquiryRepository;

    @Autowired
    public InquiryServiceImp(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    @Override
    public List<Inquiry> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < sortBy.length; i++) {
            Sort.Order order = null;
            if (sortDir.equalsIgnoreCase(Sort.Direction.DESC.name())) {
                order = new Sort.Order(Sort.Direction.DESC, sortBy[i]);
            } else {
                order = new Sort.Order(Sort.Direction.ASC, sortBy[i]);
            }
            orderList.add(order);
        }
        Sort sort = Sort.by(orderList);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Inquiry> inquiryPage = inquiryRepository.findAll(pageable);
        List<Inquiry> inquiryList = inquiryPage.getContent();
        return inquiryList;
    }

    @Override
    public Inquiry createInquiry(Inquiry inquiry) throws Exception {
        if (null != inquiry) {
            return inquiryRepository.save(inquiry);
        } else {
            throw new Exception("[EXCEPTION] -> inquiry can not be null");
        }
    }

    @Override
    public Inquiry readInquiry(Long id) throws Exception {
        Optional<Inquiry> optional = inquiryRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("[EXCEPTION] -> inquiry not found in database");
        }
    }

    @Override
    public List<Inquiry> readInquiries() {
        return inquiryRepository.findAll();
    }

    @Override
    public Inquiry updateInquiry(Long id, Inquiry inquiry) throws Exception {
        Optional<Inquiry> optional = inquiryRepository.findById(id);
        if (optional.isPresent()) {
            Inquiry updateInquiry = new Inquiry();
            if (inquiry.getFirstName() != null) {
                updateInquiry.setFirstName(inquiry.getFirstName());
            }
            if (inquiry.getLastName() != null) {
                updateInquiry.setLastName(inquiry.getLastName());
            }
            if (inquiry.getEmail() != null) {
                updateInquiry.setEmail(inquiry.getEmail());
            }
            if (inquiry.getContact() != null) {
                updateInquiry.setContact(inquiry.getContact());
            }
            if (inquiry.getQuestion() != null) {
                updateInquiry.setQuestion(inquiry.getQuestion());
            }
            if (inquiry.getTag() != null) {
                updateInquiry.setTag(inquiry.getTag());
            }
            return inquiryRepository.save(updateInquiry);
        } else {
            throw new Exception("[EXCEPTION] -> inquiry not found in database");
        }
    }

    @Override
    public String deleteInquiry(Long id) throws Exception {
        if (inquiryRepository.existsById(id)) {
            inquiryRepository.deleteById(id);
            return "[SUCCESS] -> inquiry deleted";
        } else {
            throw new Exception("[EXCEPTION] -> inquiry not found in database");
        }
    }

}
