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

    //检索指定学生的所有进行中的课程
    public List<Lesson> searchAllActiveLesson(int StudentID){
        //搜索此学生的所有选课条目
        List<Lesson_selected> lesson_selectedList = lsd.search("User_name", Integer.toString(StudentID));
        List<Lesson> activeLessonList=new ArrayList<>();
        //从选课条目中判断此课程是否已结课
        for(Lesson_selected temp:lesson_selectedList){
            Lesson tempLesson=ld.findLessonById(temp.getLesson_name());
            //如果未结课则加入List中
            if(tempLesson.getFlag().equals("0")){
                activeLessonList.add(tempLesson);
            }
        }
        //返回结果
        return activeLessonList;
    }

    public List<Lesson> searchAllStopLesson(int StudentID){
        //搜索此学生的所有选课条目
        List<Lesson_selected> lesson_selectedList = lsd.search("User_name", Integer.toString(StudentID));
        List<Lesson> activeLessonList=new ArrayList<>();
        //从选课条目中判断此课程是否已结课
        for(Lesson_selected temp:lesson_selectedList){
            Lesson tempLesson=ld.findLessonById(temp.getLesson_name());
            //如果未结课则加入List中
            if(tempLesson.getFlag().equals("1")){
                activeLessonList.add(tempLesson);
            }
        }
        //返回结果
        return activeLessonList;
    }

    public boolean checkSelected(String studentID, String lessonID){
        System.out.println(this.getClass().getName()+" "+studentID+" "+lessonID);

        List<Lesson_selected> lesson_selectedList = lsd.checkSelected(studentID,lessonID);
        System.out.println(this.getClass().getName()+" size="+lesson_selectedList.size());

        return lesson_selectedList.size() >= 1;
    }

}
