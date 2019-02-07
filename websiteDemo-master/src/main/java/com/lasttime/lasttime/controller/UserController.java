package com.lasttime.lasttime.controller;


import com.lasttime.lasttime.dao.StuDao;
import com.lasttime.lasttime.dao.UserDao;
import com.lasttime.lasttime.entity.Student;
import com.lasttime.lasttime.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private StuDao stuDao;


    @RequestMapping(value="add")
    public ModelAndView add(Student stu){
        return new ModelAndView("add");
    }

    @RequestMapping(value="addScore",method = RequestMethod.POST)
    public ModelAndView addScore(Student stu){

        return new ModelAndView("success");
    }

    @RequestMapping(value = "index")
    public ModelAndView indexPage(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "selectall_Backup")
    public void selectAll_Backup(){
        List<User> user = userDao.selectAll();
        for (User u: user) {
            System.out.println(u.getUserName()+">>>>>"+u.getPassword());
        }
    }

    @RequestMapping(value = "selectall")
    public ModelAndView selectAll(){
        List<Student> stuList = stuDao.selectAll();

        ModelAndView view=new ModelAndView("detail");
        view.addObject("stuList",stuList);
        return view;
    }

    @RequestMapping(value = "delete")
    public ModelAndView deleteById(@RequestParam("id") long id){
        //根据id删除某个学生的信息
          
        ModelAndView view=new ModelAndView("detail");
        view.addObject("stuList",null);
        return view;
    }
}