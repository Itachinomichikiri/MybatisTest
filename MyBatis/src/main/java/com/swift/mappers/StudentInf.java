package com.swift.mappers;

import java.util.List;

import com.swift.beans.Student;

public interface StudentInf
{
	public int Insert(Student student);
	
	public Student SelectByAccount(String account1);
	
	public List<Student> SelectByAge(int ages);
	
	public List<Student> SelectLimit(int start,int len);
	
	public List<Student> SelectLike();
}
