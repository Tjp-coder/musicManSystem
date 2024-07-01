package impl;

import static org.junit.jupiter.api.Assertions.*;

import bean.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.impl.CategoryServiceImpl;

import java.util.List;

public class CategoryServiceImplTest {

    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setUp() {
        categoryService = new CategoryServiceImpl();
    }

    @Test
    public void testAddCategory() {
        int result = categoryService.addCategory("Test Service Add Category");
        assertEquals(1, result);
    }

    @Test
    public void testDeleteCategory() {
        categoryService.addCategory("Delete Service Category");
        List<Category> categories = categoryService.getAllCategories();
        int idToDelete = categories.get(categories.size() - 1).getId();
        int result = categoryService.deleteCategory(idToDelete);
        assertEquals(1, result);
    }

    @Test
    public void testUpdateCategory() {
        categoryService.addCategory("Update Service Category");
        List<Category> categories = categoryService.getAllCategories();
        Category categoryToUpdate = categories.get(categories.size() - 1);
        categoryToUpdate.setCategoryName("Updated Service Category Name");
        int result = categoryService.updateCategory(categoryToUpdate);
        assertEquals(1, result);
    }

    @Test
    public void testGetAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        assertNotNull(categories);
    }
}
