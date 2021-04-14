package com.cugb.dao;

import com.cugb.entity.Lesson_selected;
import com.cugb.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Lesson_selectedDao {
    //一些参数化变量:
    private String tableName = "lesson_selected";      //指定的表名, 一键修改
    private String configName = "imooc";    //需要使用的C3P0配置名
    private String sql = null;
    private QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource(configName));

    //添加学生选课记录:
    public int add(int studentID, int lessonID){
        sql = "INSERT INTO `" + tableName + "` (user_name, Lesson_name, finish_account) values(?,?,?)";
        int row=0;
        try {
            //默认选课时的进度为0
            row=queryRunner.update(sql, studentID, lessonID, 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    //检索条目
    //keyword: 需要查找的列名
    //message: 对应的信息
    public List<Lesson_selected> search(String keyWords, String message){
        sql = "select * from `" + tableName + "` where " + keyWords + "= ?";
        List<Lesson_selected> Lesson_selected = null;
        try {
            Lesson_selected = queryRunner.query(sql, new BeanListHandler<>(Lesson_selected.class), message);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Lesson_selected;
    }

    public List<Lesson_selected> checkSelected(String studentID, String lessonID){
        sql = "select * from `" + tableName + "` where user_name = ? and lesson_name = ?";
        List<Lesson_selected> Lesson_selected = null;
        try {
            Lesson_selected = queryRunner.query(sql, new BeanListHandler<>(Lesson_selected.class), studentID,lessonID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Lesson_selected;
    }


}
