package days24;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// [v]alue [O]bject = 값을 저장할 용도의 객체
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
@Builder
public class MemberVO {
	private String name;
	private String position;

}
