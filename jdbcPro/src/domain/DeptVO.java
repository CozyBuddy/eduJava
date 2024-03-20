package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor


public class DeptVO { //valueObject
	
		private int deptno;
		private String dname;
		private String loc;
		
}
