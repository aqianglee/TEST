package com.aqiang.test.dao.impl;

import org.springframework.stereotype.Repository;

import com.aqiang.test.dao.StudentDao;
import com.aqiang.test.entities.Student;

@Repository("studentDao")
public class StudentDaoImpl extends DaoImpl<Student> implements StudentDao{

}
