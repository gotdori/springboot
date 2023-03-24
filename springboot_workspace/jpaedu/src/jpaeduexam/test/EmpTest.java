package jpaeduexam.test;

import java.util.Scanner;

import jpaeduexam.dao.EmpDao;

public class EmpTest {
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		Scanner sc = new Scanner(System.in);
		dao.printAll();
		
		dao.groupFunctionTest();
		dao.deleteEmpno(7934);
		dao.close();
	}
}
