package com.lab.hometask.service;

import com.lab.hometask.domain.Category;
import com.lab.hometask.repository.CategoryRepository;
import com.lab.hometask.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;


    @Test
    void when_saveCategory_thenDoesNotThrowException() {
        assertDoesNotThrow(() -> categoryService.createCategoryWithAttributes(new Category()));
    }

}
