package service.impl;

import bean.Category;
import mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;
import service.CategoryService;
import util.MybatisUtils;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public void addCategory(String categoryName) {
        try (SqlSession session = MybatisUtils.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            mapper.addCategory(categoryName);
            session.commit();
        }
    }

    @Override
    public void deleteCategory(int id) {
        try (SqlSession session = MybatisUtils.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            mapper.deleteCategory(id);
            session.commit();
        }
    }

    @Override
    public void updateCategory(Category category) {
        try (SqlSession session = MybatisUtils.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            mapper.updateCategory(category);
            session.commit();
        }
    }

    @Override
    public List<Category> getAllCategories() {
        try (SqlSession session = MybatisUtils.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getAllCategories();
        }
    }
}
