package com.winter.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentDAO;

    public List<DepartmentDTO> list() throws Exception {
        return departmentDAO.list();
    }

    public DepartmentDTO detail(DepartmentDTO departmentDTO) throws Exception {
        return departmentDAO.detail(departmentDTO);
    }

    public int create(DepartmentDTO departmentDTO) throws Exception {
        return departmentDAO.create(departmentDTO);
    }

    public int delete(DepartmentDTO departmentDTO) throws Exception {
        return departmentDAO.delete(departmentDTO);
    }

    public int update(DepartmentDTO departmentDTO) throws Exception {
        return departmentDAO.update(departmentDTO);
    }

}