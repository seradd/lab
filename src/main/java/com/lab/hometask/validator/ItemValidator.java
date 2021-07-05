package com.lab.hometask.validator;

import com.lab.hometask.domain.Item;
import com.lab.hometask.util.UtilOperation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> arg0) {
        return Item.class.equals(arg0);
    }

    @Override
    public void validate(Object arg0, Errors error) {
        var item = (Item) arg0;
        if (UtilOperation.longIsNull(item.getId())) {
            error.reject("Item Value", "Item Id can not be blank");
        }
    }

}
