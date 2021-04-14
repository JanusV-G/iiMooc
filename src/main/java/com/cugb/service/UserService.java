package com.cugb.service;

import com.cugb.dao.UserDao;
import com.cugb.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserService {
    UserDao ud=new UserDao();

    //��������Ƿ��Ѵ���
    public boolean checkEmail(String email){
        //ʹ��dao���ѯ����:
        List<User> userList = ud.search("User_email", email);
        //���û�ҵ���֤���������
        if(userList.size()==0){
            return true;
        }else {
            return false;
        }
    }
    //����û�:
    public int addUser(User newUser){
        return ud.add(newUser);
    }

    //�û���¼��֤
    public int checkUser(String user_email, String password, HttpSession session) {
        User user = ud.checkUser(user_email,password);
        if(user!=null) {
            //����ǰ�û����󱣴浽session����
        	 session.setAttribute("login_user", user);
             session.setAttribute("user_name", user.getUser_name());
            return user.getUser_type();
        }else {
            return 3;
        }
    }

    //���������޸�����
    public boolean changePassword(String email, String password) {
        return ud.changePassword(email, password) > 0;
    }

    //�޸��û���Ϣ
    public boolean changeUserInfo(User user) {
        return ud.changeUserInfo(user)>0?true:false;
    }

    //����id���Ҳ�������
    public void UpdateSessionById(int user_id, HttpServletRequest request) {
        User newUser = ud.findUserById(user_id);

        //��������
        HttpSession temp = request.getSession();
        temp.invalidate();
//        HttpSession session = request.getSession();
//        session.setAttribute("login_user", newUser);
    }

}