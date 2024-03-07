package com.company._01__WebMVC.service.interfaces;

import java.util.List;

import com.company._01__WebMVC.model.Inquiry;

public interface InquiryService {

    public abstract List<Inquiry> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir);

    public abstract Inquiry createInquiry(Inquiry inquiry) throws Exception;

    public abstract Inquiry readInquiry(Long id) throws Exception;

    public abstract List<Inquiry> readInquiries();

    public abstract Inquiry updateInquiry(Long id, Inquiry inquiry) throws Exception;

    public abstract String deleteInquiry(Long id) throws Exception;

}
