package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportingStructureService {
    ReportingStructure read(String id);
}
