package com.cugb.dao;

import com.cugb.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    //һЩ����������:
    private String tableName = "user";      //ָ���ı���, һ���޸�
    private String configName = "imooc";    //��Ҫʹ�õ�C3P0������
    private String sql = null;
    private QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource(configName));


    //�û���¼��֤
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

    //������Ŀ
    //keyword: ��Ҫ���ҵ�����
    //message: ��Ӧ����Ϣ
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
    //����û�
    public int add(User target){
        //����sql:
        sql = "INSERT INTO `" + tableName + "` (User_name, User_type, Student_id, User_email, Password, User_photo) values(?,?,?,?,?,?)";
        int row = 0;
        try {
            row = queryRunner.update(sql, target.getUser_name(), target.getUser_type(), target.getStudent_id(),target.getUser_email(),target.getPassword(),target.getUser_photo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    //���������޸�����
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

    //�޸��û���Ϣ
    public int changeUserInfo(User user) {
        sql = "UPDATE USER SET user_name = ?, student_id=?, user_email=?, user_photo=?  WHERE User_id = ?";
        try {
            return queryRunner.update(sql,user.getUser_name(),user.getStudent_id(),user.getUser_email(),user.getUser_photo(),user.getUser_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //�����û�������û�
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