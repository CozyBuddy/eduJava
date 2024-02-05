package days16;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor; // 롬복 설치한 후에 소스파일 - build path - configure - Library에서 external jars 하고 jar 파일 추가 해야 사용가능.
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeLombok {
	private String name;
	private String addr;
	private int tel;
	private String hireDate;

}
