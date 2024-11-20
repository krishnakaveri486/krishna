package com.lms.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDto {

   // private long id;
    private String name;
    private String emailId;
    private String mobile;
    private Date date;
}

