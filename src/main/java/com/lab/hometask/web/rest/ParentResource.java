package com.lab.hometask.web.rest;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class ParentResource {

    public GenericResponse<String> collectErrors(BindingResult result, String object) {
        var errors = new StringBuilder();
        List<ObjectError> errorList = result.getAllErrors();
        for (ObjectError error : errorList) {
            errors.append(error.getDefaultMessage()).append(",");
        }

        return new GenericResponse<>(object, errors.toString(), "collect_error");
    }


}
