package jpaeduexam.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp") // 테이블명과 클래스명이 다를 경우에 이 어노테이션을 꼭 써야한다.
public class EmpDto {

	@Id // primary key 지정
	private int empno; // int는 null값 없을 경우
	private String ename;
	private String job;
	private Integer mgr; // Integer는 객체라서 null값 가능
	private java.sql.Date hiredate;
	private int sal;
	private Integer comm;
	private Integer deptno;

	public EmpDto() {

	}

	public EmpDto(int empno, String ename, Date hiredate, int sal, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.hiredate = hiredate;
		this.sal = sal;
	}

	

	@Override
	public String toString() {
		return "EmpDto [empno=" + empno + ", ename=" + ename + ", mgr=" + mgr + ", hiredate=" + hiredate + ", sal="
				+ sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public java.sql.Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(java.sql.Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Integer getComm() {
		return comm;
	}

	public void setComm(Integer comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}


}
