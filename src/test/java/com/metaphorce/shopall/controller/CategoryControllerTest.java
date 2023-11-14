package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.entity.Category;
import com.metaphorce.shopall.repository.CategoryRepository;
import com.metaphorce.shopall.service.BuyerService;
import com.metaphorce.shopall.service.CategoryService;
import com.metaphorce.shopall.service.SellerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@WebMvcTest
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CategoryService categoryService;
    @MockBean
    private BuyerService buyerService;
    @MockBean
    private SellerService sellerService;
    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    public void createCategorySuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/categories/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test category\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void createCategoryError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/categories/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getCategorySuccess() throws Exception {
        int id = 1;
        Category category = new Category();
        category.setId(id);
        given(categoryService.getById(category.getId())).willReturn(category);
        mockMvc.perform(MockMvcRequestBuilders.get("/categories/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getCategoryFailed() throws Exception {
        int id = 0;
        Category category = new Category();
        category.setId(id);
        given(categoryService.getById(category.getId())).willReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/categories/{id}", category.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findCategoryByNameSuccess() throws Exception {
        String name = "string";
        Category category = new Category();
        category.setName(name);
        given(categoryService.getByName(category.getName())).willReturn(category);
        mockMvc.perform(MockMvcRequestBuilders.get("/categories/findByName?name=", category.getName()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findCategoryByNameError() throws Exception {
        String name = "";
        Category category = new Category();
        category.setName(name);
        given(categoryService.getByName(category.getName())).willReturn(category);
        mockMvc.perform(MockMvcRequestBuilders.get("/categories/findByName?name=", category.getName()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateCategorySuccess() throws Exception {
        int id = 1;
        String name = "test";
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        when(categoryService.updateCategory(category.getId(), category)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);
        mockMvc.perform(MockMvcRequestBuilders.get("/categories/{id}", category.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteCategorySuccess() throws Exception {
        int id = 1;
        Category category = new Category();
        category.setId(id);
        when(categoryService.deleteCategory(category.getId())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/categories/{id}", category.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteCategoryError() throws Exception {
        int id = 1;
        Category category = new Category();
        category.setId(id);
        when(categoryService.deleteCategory(category.getId())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/categories/{id}", category.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
