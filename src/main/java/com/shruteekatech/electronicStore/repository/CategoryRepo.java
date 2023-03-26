package com.shruteekatech.electronicStore.repository;

import com.shruteekatech.electronicStore.dtos.CategoryDto;
import com.shruteekatech.electronicStore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Long> {


    List<Category> findAByTitleContaining(String keyword);
}
