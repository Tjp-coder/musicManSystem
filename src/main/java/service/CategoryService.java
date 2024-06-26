package service;

import bean.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(String categoryName);
    void deleteCategory(int id);
    void updateCategory(Category category);
    List<Category> getAllCategories();
}
