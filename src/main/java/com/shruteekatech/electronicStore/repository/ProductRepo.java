package com.shruteekatech.electronicStore.repository;

import com.shruteekatech.electronicStore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {


    Page<Product> findAllByTitleContaining(String title,Pageable pageable);

    Page<Product> findAllByLiveTrue(Pageable pageable);
}
