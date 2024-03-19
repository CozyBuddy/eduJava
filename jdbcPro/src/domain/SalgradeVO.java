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
public class SalgradeVO {
	private int grade;
	private int losal;
	private int hisal;
	private int cnt;

}

