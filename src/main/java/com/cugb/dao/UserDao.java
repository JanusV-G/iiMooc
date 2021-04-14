package com.cugb.dao;

import com.cugb.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    //一些参数化变量:
    private String tableName = "user";      //指定的表名, 一键修改
    private String configName = "imooc";    //需要使用的C3P0配置名
    private String sql = null;
    private QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource(configName));


    //用户登录验证
    public User checkUser(String user_email,String password) {
        String sql = "SELECT * FROM USER WHERE User_email = ? AND Password = ?";
        try {
            return queryRunner.query(sql, new BeanHandler<User>(User.class),user_email,password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    //检索条目
    //keyword: 需要查找的列名
    //message: 对应的信息
    public List<User> search(String keyWords, String message) {
        sql = "select * from `" + tableName + "` where " + keyWords + "= ?";
        List<User> users = null;
        try {
            users = queryRunner.query(sql, new BeanListHandler<>(User.class), message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    //添加用户
    public int add(User target){
        //设置sql:
        sql = "INSERT INTO `" + tableName + "` (User_name, User_type, Student_id, User_email, Password, User_photo) values(?,?,?,?,?,?)";
        int row = 0;
        try {
            row = queryRunner.update(sql, target.getUser_name(), target.getUser_type(), target.getStudent_id(),target.getUser_email(),target.getPassword(),target.getUser_photo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    //更具邮箱修改密码
    public int changePassword(String email, String password) {
        sql = "UPDATE USER SET Password = ? WHERE User_email = ?";
        try {
            return queryRunner.update(sql,password,email);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    //修改用户信息
    public int changeUserInfo(User user) {
        sql = "UPDATE USER SET user_name = ?, student_id=?, user_email=?, user_photo=?  WHERE User_id = ?";
        try {
            return queryRunner.update(sql,user.getUser_name(),user.getStudent_id(),user.getUser_email(),user.getUser_photo(),user.getUser_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //根据用户编号找用户
    public User findUserById(int user_id) {
        sql = "SELECT * FROM user WHERE user_id=?";
        try {
            return queryRunner.query(sql, new BeanHandler<User>(User.class),user_id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


}