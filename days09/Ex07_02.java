package days09;

import java.util.Calendar;

public class Ex07_02 {
	public static void main(String[] args) {
		// 5.나이(퇴직일)
		// 1)한국식 나이 연나이 +1
		// 2)연 나이 - 올해년도 - 출생년도
		// 3)만 나이
		String rrn = "930110-5121311";
		//String birthday = getBirth(rrn);
		//System.out.println(birthday);
		int yearAge = getYearAge(rrn);
		int korAge = getkorAge(rrn);
		int amAge = getAmericanAge(rrn);
		System.out.printf("%s - 연나이 : %d살, 한국식나이 : %d살 ,만나이 : %d살",rrn,yearAge,korAge,amAge);
	}


	private static int getGender(String rrn) { // 이방식이 추후에 활용하기에 더 좋음.
		char a = rrn.charAt(7);  //'1' - 48 
		return a-48;
	}

	// 한국식 나이 = 연나이 +1
	public static int getkorAge(String rrn) {
		return getYearAge(rrn)+1;

	}
	// 연 나이 = 올해년도- 출생년도
	public static int getYearAge(String rrn) {
		Calendar c = Calendar.getInstance();
		int birthYear ;
		int thisYear = c.get(Calendar.YEAR);
		birthYear = Integer.parseInt(rrn.substring(0,2));
		int gender = getGender(rrn);

		switch (gender) {
		case 9: case 0:
			birthYear += 1800;
			break;
		case 1: case 2: case 5: case 6:
			birthYear += 1900;
			break;
		case 3: case 4: case 7: case 8:
			birthYear +=2000;
			break;
		}
		return thisYear - birthYear;
		//System.out.println(thisYear);
		//출생년도
	}
	/*
	 * private static String getBirth(String rrn) { int year =
	 * Integer.parseInt(rrn.substring(0,2)); int gender = getGender(rrn); int
	 * birthYear; switch (gender) { case 9: case 0: birthYear += 1800; break; case
	 * 1: case 2: case 5: case 6: birthYear += 1900; break; case 3: case 4: case 7:
	 * case 8: birthYear +=2000; break; } String birthday =
	 * String.format("%d년 %d월 %d일",year); return birthday;
	 */
	
	Calendar a = Calendar.getInstance();
	





	// 만 나이
	public static int getAmericanAge(String rrn) {
		Calendar c = Calendar.getInstance();
		int americanAge = getYearAge(rrn); // 생일 지남 유무
		int thisMM=c.get(Calendar.MONTH) +1;
		int thisDD=c.get(Calendar.DATE);
		int birthMM=Integer.parseInt(rrn.substring(2,4));
		int birthDD=Integer.parseInt(rrn.substring(4,6));

		int d = c.get(Calendar.YEAR);
		int year = getkorAge(rrn);
		if (!(thisMM>=birthMM && thisDD>=birthMM)) {
			americanAge-=1;
		}
		return americanAge;



	}

}
/*
 *      
      // [주민등록번호]
      // 住民登錄番號 / Resident registration number, RRN
      // *** 1. 생년월일
      // 2. 성별
      // 3. 내국인/외국인
      // 4. 출신지역
      // *** 5. 나이 
      // 6. 검증
      
      
      
      // 주민등록번호 -> 나이
      // 3:06 수업시작~~ 
      /*
       *                 2022.12.31 23.1.1  23.12.31  24.1.1
       * 
       * 1) 한국식 나이      1         2      2         3
       *      ㄴ 한국식나이 = 연 나이 + 1
       *      
       * 2) 연 나이          0         1      1        2
       *      ㄴ  연나이 = 올해연도(2024)-출생년도(1999)
       *                 = 25 
       * 3) 만 나이          0         0      1        1
       * 
       *  
       * 
       * 
      String rrn = "990123-1700001";
      // birthMMdd = "0123" -> 123  Integer.parseInt( rrn.substring(2,6) )
      // thisMMdd  =           1011
      
      int yearAge = getYearAge(rrn);
      int koreaAge = getKoreaAge(rrn);
      int americanAge = getAmericanAge(rrn);
      System.out.printf("%s - 연나이:%d살, 한국식나이:%d살, 만나이:%d살\n"
            , rrn, yearAge, koreaAge, americanAge); 

   } // main
   
   // 한국식 나이 = 연나이 + 1
   private static int getKoreaAge(String rrn) {
      return getYearAge(rrn) + 1;
   }
   
   // 연 나이 = 올해년도 - 출생년도
   private static int getYearAge(String rrn) {
      int birthYear ;// 출생 년도
      int thisYear = 2024;  // 올해 년도
      
      /* [1] Date 날짜,시간 클래스 
      Date d = new Date();
      thisYear = d.getYear() + 1900;
      
      
      // [2] Calendar 날짜,시간 클래스 
      Calendar c = Calendar.getInstance();
      thisYear = c.get(Calendar.YEAR);
      
      // System.out.println( thisYear );
      
      // 출생년도 99
      birthYear = Integer.parseInt(rrn.substring(0,2));
        int gender =  getGender(rrn); 
      switch (gender) {
      case 9: case 0:   
         birthYear += 1800;
         break; 
      case 1: case 2: case 5: case 6:
         birthYear += 1900;
         break;
      case 3: case 4: case 7: case 8:
         birthYear += 2000;
         break;
      } // switch
      
      return thisYear - birthYear;
   }
   // 만 나이
   private static int getAmericanAge(String rrn) {
      // 출생일 : 2023.10.09 
      // 오늘일 : 2024. 1.11
      
      // 
      
      // 만나이 : 0
      //         = 올해년도(2024) - 출생년도(2023)
      //           = 1 -1   생일이 지나지않으면 1살을 뺀다
      //           = 0   
      // 4:02 수업 시작~~~ 
      int americanAge = getYearAge(rrn) ;
      
       
      Calendar c = Calendar.getInstance();       
      int thisMM = c.get(Calendar.MONTH) + 1;  // *100
      int thisDD = c.get(Calendar.DATE);
      int birthMM = Integer.parseInt(rrn.substring(2,4));
      int birthDD = Integer.parseInt(rrn.substring(4,6));      
      if( !(thisMM >= birthMM && thisDD >= birthDD) ) {          
         americanAge--;
      }
       
     
      Date d = new Date();
      d.after(date);
      d.before(d);
      d.compareTo(d);
     
     
      c.after(c);
      c.before(c);
      c.compareTo(c);
  
      
      return americanAge;
   }
    
   private static int getGender(String rrn) {
      return rrn.charAt(7) - 48;   // 1
   }

   private static String getBirth(String rrn) { 
      int year = Integer.parseInt(rrn.substring(0,2)); // "99"
      int month = Integer.parseInt(rrn.substring(2,4)); // "99"
      int day = Integer.parseInt(rrn.substring(4,6)); // "99"
       
      int gender =  getGender(rrn); 
      
      switch (gender) {
      case 9: case 0:   
         year += 1800;
         break; 
      case 1: case 2: case 5: case 6:
         year += 1900;
         break;
      case 3: case 4: case 7: case 8:
         year += 2000;
         break;
      } // switch
      
      String birthday = String.format("%d년 %d월 %d일"
            , year, month, day);
      
      return birthday;
   }
   
} 
*/
 


