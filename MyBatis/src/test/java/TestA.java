import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.swift.beans.Student;
import com.swift.mappers.StudentInf;

public class TestA
{
	private static SqlSessionFactory sqlsessionfactory;
	@BeforeClass
	public static void init()
	{
		try
		{
			Reader reader =Resources.getResourceAsReader("Mybatis.xml");
			sqlsessionfactory=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void Insert_Test()
	{
		
		SqlSession session =sqlsessionfactory.openSession();
		StudentInf studentinf=session.getMapper(StudentInf.class);
		String account;
		String name;
		int age;
		for(int i=0;i<30;i++)
		{
			if(i<10)
			{
				account="20151304030"+i;
				name="swift0"+i;
			}
			else
			{
				account="2015130403"+i;
				name="swift"+i;
			}
			age=(int)(Math.random()*10)+15;
			Student student=new Student(account,name,age);
			studentinf.Insert(student);
		}
		session.commit();
		session.close();
	}
	@Test
	public void Select_Test()
	{
		SqlSession session =sqlsessionfactory.openSession();
		StudentInf studentinf=session.getMapper(StudentInf.class);
		
		Student student=studentinf.SelectByAccount("201513040323");
		System.out.println(student.getName() + " " +student.getAccount()+" "+student.getAge());
		
		List<Student> students=studentinf.SelectByAge(20);
		
		for(Student stu:students)
		{
			System.out.println(stu.getAccount()+" "+stu.getAge());
		}
		session.close();	
	}
	
	@Test
	public void Select_Limit_Test()
	{
		SqlSession session =sqlsessionfactory.openSession();
		StudentInf studentinf=session.getMapper(StudentInf.class);
		int start,len;
		start=5;
		len=10;
		List<Student> students=studentinf.SelectLimit(start, len);
		for(Student stu:students)
		{
			System.out.println(stu.getAccount()+" "+stu.getName());
		}
		
		session.close();	
	}
	
	@Test
	public void Select_Like_Test()
	{
		SqlSession session =sqlsessionfactory.openSession();
		StudentInf studentinf=session.getMapper(StudentInf.class);
		List<Student> students=studentinf.SelectLike();
		for(Student stu:students)
		{
			System.out.println(stu.getAccount()+" "+stu.getName());
		}
		session.close();	
	}

}























