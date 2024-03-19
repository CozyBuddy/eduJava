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
public class EMPVO {
	int empno;
	String ename;
	String job;
	int mgr;
	//String hire;
	Date hire;
	double sal;
	double comm;
	int depno;
	

}

