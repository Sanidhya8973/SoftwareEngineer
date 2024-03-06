package com.company.project.service.interfaces;

import java.util.List;

import com.company.project.model.Inquiry;

public interface InquiryService {

    public abstract List<Inquiry> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir);

    public abstract Inquiry createInquiry(Inquiry inquiry) throws Exception;

    public abstract Inquiry readInquiry(Long id) throws Exception;

    public abstract List<Inquiry> readInquiries();

    public abstract Inquiry updateInquiry(Long id, Inquiry inquiry) throws Exception;

    public abstract String deleteInquiry(Long id) throws Exception;

}
