package days05;

/**
 * @author user
 * @date 2024. 1. 5. 오후 12:35:51
 * @subject
 * @contents
 */
public class Ex05 {
	public static void main(String[] args) {
		String todo = "Auto-generated method stub";
		// 1. 문자열 길이  // 괄호가 있는 함수는 메서드, 없으면 필드?
		//char String.charAt(index)
		int strlength = todo.length();
		char one ;
		char one1 [] = new char[strlength];
		for (int i = 0; i < strlength; i++) {
			one1[i] = one = todo.charAt(i);
			System.out.printf("%d - %c\n",i,one);
			
		}
		/*
		 * [이창익] [오후 12:48] package days05;

/**
 package days05;

/**
 * @author kenik
 * @date 2024. 1. 5. - 오후 12:35:48
 * @subject
 * @content
 
   public class Ex05 {

   public static void main(String[] args) {
      String todo = "Auto-generated method stub";
      // 1. 문자열 길이       todo.length()
      // char String.charAt(index)
      /*
      for (int i = 0; i < todo.length() ; i++) {
         char one = todo.charAt(i);
         System.out.printf("%d - '%c'\n", i, one);
      } // for
      
      
       
      int strLength = todo.length();
      char one;
      char [] todoArray = new char[strLength];
      
      for (int i = 0 ; i <  strLength ; i++){
         todoArray[i] = one = todo.charAt(i);
          
         System.out.printf("%d - '%c'\n", i, one);
      } // for
      
      // char [] todoArray = todo.toCharArray();
       

   } // main

} // class

		 */
	}

}
