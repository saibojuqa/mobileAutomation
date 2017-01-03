package com.peoplematter.web.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by sai.boju on 12/26/16.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails {
    private String city;
    private String state;
    private String zipcode;
    private String jobName;
    private String firstName;
    private String lastName;
    private String ssn;
    private String verifyPin;
    private String month;
    private String day;
    private String race;
    private String gender;
    private String hours;
    private String startMonth;
    private String startDay;
    private String startYear;
    private String noticePeriod;
    private String general;
    private String numeric;
    private String address1;
    private String state_selection;
    private String cellphone;



}
