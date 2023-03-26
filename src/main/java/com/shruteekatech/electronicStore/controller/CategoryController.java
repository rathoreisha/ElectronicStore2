package com.shruteekatech.electronicStore.controller;

import com.shruteekatech.electronicStore.constant.AppConstant;
import com.shruteekatech.electronicStore.dtos.ApiResponse;
import com.shruteekatech.electronicStore.dtos.CategoryDto;
import com.shruteekatech.electronicStore.dtos.PagableResponse;
import com.shruteekatech.electronicStore.service.CategoryService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto categoryDto)
    {
        CategoryDto category = this.categoryService.createCategory(categoryDto);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
    @PutMapping("/update/{catid}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Long catid )
    {
        CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, catid);
        return new ResponseEntity<>(updateCategory,HttpStatus.CREATED);
    }

    @GetMapping("/getsingle/{catid}")
    public ResponseEntity<CategoryDto> getsinglecategory(@PathVariable Long catid)
    {
        CategoryDto singleCategory = this.categoryService.getSingleCategory(catid);
        return new ResponseEntity<>(singleCategory,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<PagableResponse> getAllcategories(@RequestParam(value = "pagenumber", defaultValue = "0", required = false) Integer pagenumber,
                                                            @RequestParam(value = "pagesize", defaultValue = "10", required = false) Integer pagesize
                                                      , @RequestParam(value = "sortBy", defaultValue = "categoryId", required = false) String sortBy,
                                                            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir)
    {
        log.info("Initiated request to get all the user details");
        PagableResponse<CategoryDto> allcategories = this.categoryService.getAllcategories(pagenumber, pagesize, sortBy, sortDir);


        return new ResponseEntity<>(allcategories,HttpStatus.OK);
    }

    @DeleteMapping("/{catid}")
    public ResponseEntity<ApiResponse> deletecategory(@PathVariable Long catid)
    {
        this.categoryService.deleteCategory(catid);
        ApiResponse apiResponse =ApiResponse.builder().message(AppConstant.DELETE).status(true).build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @GetMapping("/{keyword}")
    public  ResponseEntity<List<CategoryDto>> searchCategory(@PathVariable String keyword)
    {
        List<CategoryDto> searchCategory = this.categoryService.searchCategory(keyword);
        return new ResponseEntity<>(searchCategory,HttpStatus.OK);
    }
}
