package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating ReportingStructure with employee id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        ReportingStructure reportingStructure = new ReportingStructure(employee);

        int numberOfReports = 0;


        List<Employee> directReports = employee.getDirectReports();

        // check if the directReports  is not null
        if(directReports != null) {
            numberOfReports = directReports.size();
            for (Employee emp : directReports) {

                Employee employee1 = employeeRepository.findByEmployeeId(emp.getEmployeeId());
                List<Employee> directReports1 = employee1.getDirectReports();
                if (directReports1 != null) {
                    numberOfReports += directReports1.size();
                }
            }
        }

        reportingStructure.setNumberOfReports(numberOfReports);
        return reportingStructure;
    }

}