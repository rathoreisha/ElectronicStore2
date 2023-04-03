package com.shruteekatech.electronicStore.repository;

import com.shruteekatech.electronicStore.dtos.ProductDto;
import com.shruteekatech.electronicStore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {


    Page<ProductDto> findByTitleContaining(Pageable pageable);

    Page<ProductDto> findByLiveTrue(Pageable pageable);
}
