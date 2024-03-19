package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class DeptEmpSalVo {
	private int empno;
	private String dname;
	private String ename;
	private int sal;
	private Date hiredate;
	private int deptno;

}
