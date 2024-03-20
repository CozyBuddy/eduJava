package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class EMPVO {
	int empno;
	String ename;
	String job;
	int mgr;
	//String hire;
	Date hiredate;
	double sal;
	double comm;
	int depno;
	

}

