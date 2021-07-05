package com.lab.hometask.validator;

import com.lab.hometask.domain.Item;
import com.lab.hometask.dto.CategoryDto;
import com.lab.hometask.util.UtilOperation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CategoryValidator implements Validator {

    @Override
    public boolean supports(Class<?> arg0) {
        return Item.class.equals(arg0);
    }

    @Override
    public void validate(Object arg0, Errors error) {
        var category = (CategoryDto) arg0;
        if (UtilOperation.stringIsEmpty(category.getName())) {
            error.reject("Category Name", "Item Value can not be blank");
        }

        category.getAttributes().forEach(attribute -> {
            if (UtilOperation.stringIsEmpty(attribute.getName()))
                error.reject("Attribute Name", "Attribute Name can not be blank" );
        });


    }

}
