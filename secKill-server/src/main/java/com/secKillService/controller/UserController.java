package com.secKillService.controller;


import com.secKillService.dao.SecKillGoodsDao;
//import com.secKillService.dao.UserDao;
import com.secKillService.entity.Student;
import com.secKillService.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@RestController
public class UserController {

//    @Autowired
//    private UserDao userDao;

//    @Autowired
//    private SecKillGoodsDao stuDao;


    @RequestMapping(value="add")
    public ModelAndView add(Student stu){
        return new ModelAndView("add");
    }

    @RequestMapping(value="addScore",method = RequestMethod.POST)
    public ModelAndView addScore(Student stu){

        return new ModelAndView("success");
    }

    @RequestMapping(value = "index1")
    public ModelAndView indexPage(){
        return new ModelAndView("index1");
    }

//    @RequestMapping(value = "selectall_Backup")
//    public void selectAll_Backup(){
//        List<User> user = userDao.selectAll();
//        for (User u: user) {
//            System.out.println(u.getUserName()+">>>>>"+u.getPassword());
//        }
//    }

//    @RequestMapping(value = "selectall")
//    public ModelAndView selectAll(){
//        List<Student> stuList = stuDao.selectAll();
//
//        ModelAndView view=new ModelAndView("detail");
//        view.addObject("stuList",stuList);
//        return view;
//    }

    @RequestMapping(value = "delete")
    public ModelAndView deleteById(@RequestParam("id") long id){
        //根据id删除某个学生的信息
          
        ModelAndView view=new ModelAndView("detail");
        view.addObject("stuList",null);
        return view;
    }
}