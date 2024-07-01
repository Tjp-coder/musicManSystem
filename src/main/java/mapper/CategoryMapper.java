package mapper;

import bean.Category;

import java.util.List;

public interface CategoryMapper {
    int addCategory(String categoryName);

    int deleteCategory(int id);

    int updateCategory( Category category);

    List<Category> getAllCategories();
}
