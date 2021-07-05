package com.lab.hometask.service.impl;

import com.lab.hometask.domain.Category;
import com.lab.hometask.repository.CategoryRepository;
import com.lab.hometask.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategoryWithAttributes(Category category) {
        categoryRepository.save(category);
    }
}
