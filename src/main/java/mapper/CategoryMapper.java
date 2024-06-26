package mapper;

import bean.Category;

import java.util.List;

public interface CategoryMapper {
    void addCategory(String categoryName);

    void deleteCategory(int id);

    void updateCategory( Category category);

    List<Category> getAllCategories();
}
