package days06;

public class Ex04_02 {
	public static void main(String[] args) {
	    //대,소문자 출력 for문
	    // 한 라인에 10개씩 출력(추가)
	    for (int i = 'A',count=1; i < 'z'; i++) {
	        //if (i>'Z'&&i<'a') continue;
	        if (Character.isAlphabetic(i)) {
	            if (count%10==1)
	            System.out.printf("%d.%c(%03d)",count/10+1,(char)i,i);
	            count++;
	        } else if (count%10==0) {
	        	System.out.println();
	            
	            count++;
	        } else {
	        	System.out.printf("%c(%03d)",(char)i,i);
	        	count++;
	        }
	    }
	}
}





	/* 답
     for (int i = 'A', count = 1, lineNumber = 1; i <= 'z' ; i++) { 

         // if( i > 'Z' && i < 'a' ) continue;
         if( Character.isAlphabetic(i) ) {

            if( count % 10 == 1) System.out.printf("%d : ", lineNumber++);

            System.out.printf("%c(%03d)", (char)i, i ); 

            /*
            if ( Character.isUpperCase(i)  ) { // 대문자
               //대문자   %10 == 4 개행
               if( i % 10 == 4) System.out.println();
            } else { // 소문자
               //소문자   %10 == 0 개행
               if( i % 10 == 0) System.out.println();
            }

            if( count % 10 == 0) System.out.println();

            count++;

         } // if

      } // 

   } // main

} // class
	 */
	/*
	 * public static void main(String[] args) {
		//대,소문자 출력 for문
		// 한 라인에 10개씩 출력(추가)
		for (int i = 'A',count=1; i < 'z'; i++) {
			//if (i>'Z'&&i<'a') continue;
			if (Character.isAlphabetic(i)) {
				if (count%10==1)
				System.out.printf("%d.%c(%03d)\n",count/10+1,(char)i,i);
				count++;
			} else {
				System.out.printf("%c(%03d)",(char)i,i);
				count++;

			}

		}

		}


	}

	 */



