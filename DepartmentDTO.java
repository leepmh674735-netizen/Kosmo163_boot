package com.winter.app.departments;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DepartmentDTO {
    private String departmentNo;
    private String departmentName;
    private String category;
    private String openYn;
    private Long capacity;

}