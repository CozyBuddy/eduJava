package days14;

/**
 * @author user
 * @date 2024. 1. 18. 오후 3:31:12
 * @subject
 * @contents
 */
public class StudentManagement {
	//등수 처리 method
	//
	public static void procRank(Student students[] , int count) {
		for (int i = 0; i < count; i++) {
			//students[i].tot;
			students[i].rank=1;
			for (int j = 0; j < count; j++) {
				if (students[i].tot<students[j].tot) {
					students[i].rank++;
				}
			}
		}
	}

}
