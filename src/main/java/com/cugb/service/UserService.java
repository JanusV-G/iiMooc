package com.cugb.service;

import com.cugb.dao.UserDao;
import com.cugb.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserService {
    UserDao ud=new UserDao();

    //检测邮箱是否已存在
    public boolean checkEmail(String email){
        //使用dao层查询方法:
        List<User> userList = ud.search("User_email", email);
        //如果没找到则证明邮箱可用
        if(userList.size()==0){
            return true;
        }else {
            return false;
        }
    }
    //添加用户:
    public int addUser(User newUser){
        return ud.add(newUser);
    }

    //用户登录验证
    public int checkUser(String user_email, String password, HttpSession session) {
        User user = ud.checkUser(user_email,password);
        if(user!=null) {
            //将当前用户对象保存到session域中
        	 session.setAttribute("login_user", user);
             session.setAttribute("user_name", user.getUser_name());
            return user.getUser_type();
        }else {
            return 3;
        }
    }

    //根据邮箱修改密码
    public boolean changePassword(String email, String password) {
        return ud.changePassword(email, password) > 0;
    }

    //修改用户信息
    public boolean changeUserInfo(User user) {
        return ud.changeUserInfo(user)>0?true:false;
    }

    //根据id查找并更新域
    public void UpdateSessionById(int user_id, HttpServletRequest request) {
        User newUser = ud.findUserById(user_id);

        //跟新数据
        HttpSession temp = request.getSession();
        temp.invalidate();
//        HttpSession session = request.getSession();
//        session.setAttribute("login_user", newUser);
    }

}