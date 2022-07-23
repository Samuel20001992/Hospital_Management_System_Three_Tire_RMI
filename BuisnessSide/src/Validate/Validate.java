package Validate;

import DataTypes.Employee;
import DataTypes.Patient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static String validate_Patient(Patient patient)
    {

        Pattern pattern = Pattern.compile("[A-z]+");
        Pattern pattern1 = Pattern.compile("[0-9]+");
        Pattern pattern2 = Pattern.compile("[A-z 0-9]");

        Matcher fname = pattern.matcher(patient.getFirstName());
        Matcher mname = pattern.matcher(patient.getMiddleName());
        Matcher lname = pattern.matcher(patient.getLastName());
        Matcher s_e_x = pattern.matcher(patient.getSex());
        Matcher a_g_e = pattern1.matcher(String.valueOf(patient.getAge()) );
        Matcher pnumber = pattern1.matcher(String.valueOf(patient.getPhoneNumber()));

        if(fname.matches()) {
            if(lname.matches()) {
                if(s_e_x.matches()) {
                    if(a_g_e.matches()) {
                        if(pnumber.matches()) {
                                return "success";
                        }
                        else {
                             return "Wrong Phone Number Input";
                        }
                    }
                    else {
                        return "Wrong Age Input";
                    }
                }
                else {
                    return "Wrong Sex Input";
                }
            }
            else {
                return "Wrong Last Name Input";
            }

        }
        else {
            return "Wrong First Name Input";
        }

    }
    public static String validate_Employee(Employee employee)
    {

        Pattern pattern = Pattern.compile("[A-z]+");
        Pattern pattern1 = Pattern.compile("[0-9]+");
        Pattern pattern2 = Pattern.compile("[A-z 0-9]");
        Pattern pattern4 = Pattern.compile("[1-5]");
        Matcher fname = pattern.matcher(employee.getFirstName());
        Matcher mname = pattern.matcher(employee.getMiddleName());
        Matcher lname = pattern.matcher(employee.getLastName());
        Matcher s_e_x = pattern.matcher(employee.getSex());
        Matcher a_g_e = pattern1.matcher(String.valueOf(employee.getAge()));
        Matcher pnumber = pattern1.matcher(String.valueOf(employee.getPhoneNumber()));
        Matcher salaryCheck = pattern1.matcher(String.valueOf(employee.getSalary()));
        Matcher departmentCheck = pattern4.matcher(String.valueOf(employee.getSalary()));


        if(fname.matches()) {
            if(lname.matches()) {
                if(s_e_x.matches()) {
                    if(a_g_e.matches()) {
                        if(pnumber.matches()) {
                            if (salaryCheck.matches()){
                                if (departmentCheck.matches()){

                                    return "success";
                                }
                                else {
                                    return "Wrong Department Input";
                                }
                            }
                            else {
                                return "Wrong Salary Input";
                            }
                        }
                        else {
                            return "Wrong Phone Number Input";
                        }
                    }
                    else {
                        return "Wrong Age Input";
                    }
                }
                else {
                    return "Wrong Sex Input";
                }
            }
            else {
                return "Wrong Last Name Input";
            }
        }
        else {
            return "Wrong First Name Input";
        }

    }

}
