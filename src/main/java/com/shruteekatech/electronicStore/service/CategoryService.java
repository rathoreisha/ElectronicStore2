package com.shruteekatech.electronicStore.service;

import com.shruteekatech.electronicStore.dtos.CategoryDto;
import com.shruteekatech.electronicStore.dtos.PagableResponse;

import java.util.List;

public interface CategoryService {

//    Create
    CategoryDto createCategory(CategoryDto categoryDto);

//    Update
    CategoryDto updateCategory(CategoryDto Category,Long catId);

//    GetSinglecategory
    CategoryDto getSingleCategory(Long catID);

//    GetAll Category
    PagableResponse<CategoryDto> getAllcategories(Integer pagenumber, Integer pagesize, String sortBy, String sortDir);

//    Search Category
    List<CategoryDto> searchCategory(String keyword);

//    Delete Category
    void deleteCategory(Long catid);

}
