package days10;

public class Ex01_00 {
	public static int gettotalDays(int year , int month,int day) {
		// year 2020,month 5, day 1 // 365*2019+2020.1 (31) + 2(29) +3(31) +... 
		int c= 0; 
		int b = 0; 
		int a[] = new int[year-1];
		for (int i = 0; i < a.length; i++){ 
			if((i+1)%4==0 && (i+1)%100!=0 || (i+1)%400==0){ 
				a[i] = 366;
			} else {
				a[i]=365; 
			} //a[0]->1년 일수
		}
		for (int i = 0; i < a.length; i++) {
			b+=a[i]; //요일

		} 
		for (int i = 0; i < month-1; i++) {
			if (a[year-1]==366) { 
				c+=b+day;
				if(month%2==1 ) { 
					c+=(month-1)/2*30+(month-1)/2*31;
				} else if (month%2==0&&month!=2) { 
					c+=(month-1)/2*31+(((month-1)/2-1)*31);
				}





			} 


		}
		return c%7;
	}
}




