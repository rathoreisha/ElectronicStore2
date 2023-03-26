package com.shruteekatech.electronicStore.service.serviceimpl;

import com.shruteekatech.electronicStore.constant.AppConstant;
import com.shruteekatech.electronicStore.dtos.CategoryDto;
import com.shruteekatech.electronicStore.dtos.PagableResponse;
import com.shruteekatech.electronicStore.entity.Category;
import com.shruteekatech.electronicStore.exception.UsernotFoundException;
import com.shruteekatech.electronicStore.helper.Pageablemethod;
import com.shruteekatech.electronicStore.repository.CategoryRepo;
import com.shruteekatech.electronicStore.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    /**
     * @param categoryDto
     * @return
     */
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        log.info("Initiated Dao Call to save the Category");
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category save = this.categoryRepo.save(category);
        CategoryDto categoryDto1 = this.modelMapper.map(save, CategoryDto.class);
        log.info("Completed Dao call to save the Category");
        return categoryDto1;
    }

    /**
     * @param categorydto
     * @param catId
     * @return
     */
    @Override
    public CategoryDto updateCategory(CategoryDto categorydto, Long catId) {
        log.info("Initiated Dao Call to Update the Category with :{}",catId);
        Category category = this.categoryRepo.findById(catId).orElseThrow(() -> new UsernotFoundException(AppConstant.CATEGORY, AppConstant.ID, catId));

        category.setTitle(categorydto.getTitle());
        category.setDescription(categorydto.getDescription());
        category.setCoverImage(categorydto.getCoverImage());

        Category save = this.categoryRepo.save(category);

        log.info("Completed Dao Call to Update the Category with :{}",catId);
        return this.modelMapper.map(save,CategoryDto.class);
    }

    /**
     * @param catID
     * @return
     */
    @Override
    public CategoryDto getSingleCategory(Long catID) {
        log.info("Initiated Dao Call to Get the Category with :{}",catID);
        Category category = this.categoryRepo.findById(catID).orElseThrow(() -> new UsernotFoundException(AppConstant.CATEGORY, AppConstant.ID, catID));
        log.info("Cpmpleted Dao Call to Get the Category with :{}",catID);
        return this.modelMapper.map(category,CategoryDto.class);
    }

    /**
     * @return
     */
    @Override
    public PagableResponse<CategoryDto> getAllcategories(Integer pagenumber, Integer pagesize, String sortBy, String sortDir) {

        log.info("Initiating dao call to get the All Category data ");

        Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : (Sort.by(sortBy).descending());
        Pageable page = PageRequest.of(pagenumber, pagesize, sort);
        Page<Category> categories = this.categoryRepo.findAll(page);

        PagableResponse<CategoryDto> pageableresponse = Pageablemethod.getPageableresponse(categories, CategoryDto.class);

        log.info("Completed dao call to get the All Categories data ");
        return pageableresponse;

    }

    /**
     * @param keyword
     * @return
     */
    @Override
    public List<CategoryDto> searchCategory(String keyword) {
        log.info("Initiated Dao Call to search the Category with :{}",keyword);
        List<Category> categoryList = this.categoryRepo.findAByTitleContaining(keyword);
        log.info("Completed Dao Call to Search the Category with :{}",keyword);
        return categoryList.stream().map((category) -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
    }

    /**
     * @param catid
     */
    @Override
    public void deleteCategory(Long catid) {
        log.info("Initiated Dao Call to Delete the Category with :{}",catid);

        Category category = this.categoryRepo.findById(catid).orElseThrow(() -> new UsernotFoundException(AppConstant.CATEGORY, AppConstant.ID, catid));
        log.info("Completed Dao Call to Delete the Category with :{}",catid);
        this.categoryRepo.delete(category);

    }
}
