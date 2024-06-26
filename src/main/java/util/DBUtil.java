package util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;

    /**
     * 获得数据库连接
     *
     * @return
     */
    private Connection getConnection() {
        connection = ConnectionProvider.getConnection();
        return connection;
    }

    public ResultSet getResultSet(String sql, Object[] params) {
        try {
            ps = getConnection().prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public boolean setData(String sql, Object[] params) {
        try {
            ps = getConnection().prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * 关闭连接
     */
    public void close() {
        if (null != resultSet) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }

        if (null != ps) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps = null;
        }

        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

    public static void close(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException {
        if (null != conn) {
            conn.close();
        }
        close(ps,rs);
    }
    public static void close(PreparedStatement ps,ResultSet rs) throws SQLException {
        if (null != ps)
            ps.close();
        if (null != rs)
            rs.close();
    }
    /**
     * 封装list
     */
    public Object resultToList(ResultSet resultSet, Class<?> classs) {
        //用来封装实体类对象
        List<Object> list = new ArrayList<Object>();
        try {
            while (resultSet.next()) {
                //用反射机制创建实体类对象
                Object entity = classs.newInstance();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    //根据索引获取当前字段名称
                    String columnName = resultSet.getMetaData().getColumnName(i);
                    //获取当前索引的值
                    Object value = resultSet.getObject(i);
                    //根据字段名称获得当前类中的单一属性
                    Field field = classs.getDeclaredField(columnName);
                    //将当前属性设置为可赋值状态
                    field.setAccessible(true);
                    //为指定对象的属性进行赋值
                    field.set(entity, value);
                }
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        DBUtil dbUtils = new DBUtil();
        Connection connection = dbUtils.getConnection();
        if (connection != null)
            System.out.println("数据库连接成功！");
        else
            System.out.println("数据库连接失败！");
    }
}
