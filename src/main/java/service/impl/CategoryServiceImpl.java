package service.impl;

import bean.Category;
import mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;
import service.CategoryService;
import util.MybatisUtils;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public int addCategory(String categoryName) {
        try (SqlSession session = MybatisUtils.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            int row = mapper.addCategory(categoryName);
            session.commit();
            return row;
        }
    }

    @Override
    public int deleteCategory(int id) {
        try (SqlSession session = MybatisUtils.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            int row = mapper.deleteCategory(id);
            session.commit();
            return row;
        }
    }

    @Override
    public int updateCategory(Category category) {
        try (SqlSession session = MybatisUtils.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            int row = mapper.updateCategory(category);
            session.commit();
            return row;
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
