package com.cugb.service;

import com.cugb.dao.LessonDao;
import com.cugb.dao.Lesson_selectedDao;
import com.cugb.entity.Lesson;
import com.cugb.entity.Lesson_selected;

import java.util.ArrayList;
import java.util.List;

public class Lesson_selectedService {
    Lesson_selectedDao lsd=new Lesson_selectedDao();
    LessonDao ld=new LessonDao();

    public boolean courseSelection(int studentID, int lessonID){
        if(lsd.add(studentID,lessonID)==1){
            return true;
        }else {
            return false;
        }
    }

    //����ָ��ѧ�������н����еĿγ�
    public List<Lesson> searchAllActiveLesson(int StudentID){
        //������ѧ��������ѡ����Ŀ
        List<Lesson_selected> lesson_selectedList = lsd.search("User_name", Integer.toString(StudentID));
        List<Lesson> activeLessonList=new ArrayList<>();
        //��ѡ����Ŀ���жϴ˿γ��Ƿ��ѽ��
        for(Lesson_selected temp:lesson_selectedList){
            Lesson tempLesson=ld.findLessonById(temp.getLesson_name());
            //���δ��������List��
            if(tempLesson.getFlag().equals("0")){
                activeLessonList.add(tempLesson);
            }
        }
        //���ؽ��
        return activeLessonList;
    }

    public List<Lesson> searchAllStopLesson(int StudentID){
        //������ѧ��������ѡ����Ŀ
        List<Lesson_selected> lesson_selectedList = lsd.search("User_name", Integer.toString(StudentID));
        List<Lesson> activeLessonList=new ArrayList<>();
        //��ѡ����Ŀ���жϴ˿γ��Ƿ��ѽ��
        for(Lesson_selected temp:lesson_selectedList){
            Lesson tempLesson=ld.findLessonById(temp.getLesson_name());
            //���δ��������List��
            if(tempLesson.getFlag().equals("1")){
                activeLessonList.add(tempLesson);
            }
        }
        //���ؽ��
        return activeLessonList;
    }

    public boolean checkSelected(String studentID, String lessonID){
        System.out.println(this.getClass().getName()+" "+studentID+" "+lessonID);

        List<Lesson_selected> lesson_selectedList = lsd.checkSelected(studentID,lessonID);
        System.out.println(this.getClass().getName()+" size="+lesson_selectedList.size());

        return lesson_selectedList.size() >= 1;
    }

}
