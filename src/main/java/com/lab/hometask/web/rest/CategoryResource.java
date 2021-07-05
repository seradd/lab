package com.lab.hometask.web.rest;

import com.lab.hometask.dto.CategoryDto;
import com.lab.hometask.service.CategoryService;
import com.lab.hometask.validator.CategoryValidator;
import com.lab.hometask.web.rest.converter.CategoryConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Category Operations")
@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryResource extends ParentResource {

    private final CategoryConverter categoryConverter;
    private final CategoryService categoryService;
    private final CategoryValidator categoryValidator;

    @ApiOperation(value = "Creating categories with attribute definitions")
    @PostMapping("/create")
    public ResponseEntity<?> createCategoryWithAttributes(@RequestBody CategoryDto categoryDto, BindingResult result) {
        categoryValidator.validate(categoryDto, result);
        if (result.hasErrors()) {
            return ResponseEntity.ok(collectErrors(result, categoryDto.toString()));
        }
        categoryService.createCategoryWithAttributes(categoryConverter.toEntity(categoryDto));
        return ResponseEntity.ok().build();
    }
}
