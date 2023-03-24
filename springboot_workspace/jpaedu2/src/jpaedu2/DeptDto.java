package jpaedu2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//DB에서는 내가 원하는 필드랑 join 가능 foreign key도 primary나 unique 제약조건이 가능한데
//JPA에서는 primary만 foreign key 가능
@Entity
@Table(name = "dept")
public class DeptDto {

	@Id
	int deptno; // primary key로 만들고 EmpDto에서 참조한다.
	String dname;
	String loc_code;

	public DeptDto() {
	}
	
	//EmpDto 객체 insert 시 사용한다.
	public DeptDto(int deptno) {
		this.deptno = deptno;
		this.dname = "";
		this.loc_code = "";
	}

	//DepthDto 객체 insert시 사용한다.
	public DeptDto(int deptno, String dname, String loc_code) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc_code = loc_code;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc_code() {
		return loc_code;
	}

	public void setLoc_code(String loc_code) {
		this.loc_code = loc_code;
	}
}
