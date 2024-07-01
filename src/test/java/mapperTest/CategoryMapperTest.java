package mapperTest;

import static org.junit.jupiter.api.Assertions.*;

import bean.Category;
import mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.MybatisUtils;

import java.util.List;

public class CategoryMapperTest {

    private SqlSession session;
    private CategoryMapper categoryMapper;

    @BeforeEach
    public void setUp() {
        session = MybatisUtils.getSession();
        categoryMapper = session.getMapper(CategoryMapper.class);
    }

    @AfterEach
    public void tearDown() {
        session.close();
    }

    @Test
    public void testAddCategory() {
        int result = categoryMapper.addCategory("Test ADD Category");
        session.commit();
        assertEquals(1, result);
    }

    @Test
    public void testDeleteCategory() {
        categoryMapper.addCategory("Delete Category");
        List<Category> categories = categoryMapper.getAllCategories();
        int idToDelete = categories.get(categories.size() - 1).getId();
        int result = categoryMapper.deleteCategory(idToDelete);
        session.commit();
        assertEquals(1, result);
    }

    @Test
    public void testUpdateCategory() {
        categoryMapper.addCategory("Update Category");
        List<Category> categories = categoryMapper.getAllCategories();
        Category categoryToUpdate = categories.get(categories.size() - 1);
        categoryToUpdate.setCategoryName("Updated Category Name");
        int result = categoryMapper.updateCategory(categoryToUpdate);
        session.commit();
        assertEquals(1, result);
    }

    @Test
    public void testGetAllCategories() {
        List<Category> categories = categoryMapper.getAllCategories();
        assertNotNull(categories);
    }
}
