package com.cugb.dao;

import com.cugb.entity.Lesson_selected;
import com.cugb.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Lesson_selectedDao {
    //һЩ����������:
    private String tableName = "lesson_selected";      //ָ���ı���, һ���޸�
    private String configName = "imooc";    //��Ҫʹ�õ�C3P0������
    private String sql = null;
    private QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource(configName));

    //���ѧ��ѡ�μ�¼:
    public int add(int studentID, int lessonID){
        sql = "INSERT INTO `" + tableName + "` (user_name, Lesson_name, finish_account) values(?,?,?)";
        int row=0;
        try {
            //Ĭ��ѡ��ʱ�Ľ���Ϊ0
            row=queryRunner.update(sql, studentID, lessonID, 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    //������Ŀ
    //keyword: ��Ҫ���ҵ�����
    //message: ��Ӧ����Ϣ
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
