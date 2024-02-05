package days07;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
		char con = 'y';
		String struser;
		String regex = "[1-3]";
		
		try (Scanner sc = new Scanner(System.in);){
			
			do {
			double a = Math.random();
			int com = (int)((a*10)%3+1);
			String com1[] = { "가위","바위","보"};
			do {
			System.out.print("가위(1),바위(2),보(3) 선택 >");
			struser = sc.next();
			
			} while (!struser.matches(regex) );
			int user = Integer.parseInt(struser);
			System.out.printf("컴퓨터 : %s , 사용자 : %s\n",com1[com-1],com1[user-1]);
			switch (user-com) {
			case -2: case 1:
				System.out.println("사용자 승리");
				break;
			case -1: case 2:
				System.out.println("컴퓨터 승리");
				break;
			default:
				System.out.println("무승부");
				break;
			} 
				System.out.print("계속하시겠습니까?");
				con = sc.next().charAt(0);
				if (con=='n'||con=='N') 
				{
					System.out.println("종료합니다.");
					break;
					
				}
				
			} while (con=='Y'||con=='y');
		
		   } catch (Exception e) {
		  }
		
		//System.out.printf();
		//comstr = (com==1?"가위": (com==2? "바위","보"));
	}


}

 /*답
 * int com , user;
      String [] rps = { "", "가위", "바위", "보" };
      char con = 'y';
      
      try (Scanner scanner = new Scanner(System.in)) {
         do {
            com = (int)(Math.random() * 3) + 1;         
            System.out.print("> user 가위(1),바위(2),보(3) 선택 ? ");         
            user = scanner.nextInt();           
            System.out.printf("컴퓨터 : %s, 사용자 : %s\n"
                  , rps[com], rps[user] );          
            switch (user - com) {
            case -2: case 1:
               System.out.println("사용자 승리");
               break;
            case -1: case 2:
               System.out.println("컴퓨터 승리");
               break; 
            default:
               System.out.println("무승부");
               break;
            }  
            
            System.out.print("다시 게임할거니 ? ");
            con = (char) System.in.read();
            System.in.skip(System.in.available()); // 13, 10
         } while ( Character.toUpperCase(con) == 'Y' ); 
      } catch (Exception e) { 
      }
      
public static void main(String[] args) {
    char con = 'y';
    String struser;
    String regex = "[1-3]";

    try (Scanner sc = new Scanner(System.in)) {
        String com1[] = {"가위", "바위", "보"};
        int user;
        do {
            System.out.print("가위(1),바위(2),보(3) 선택 >");
            struser = sc.next();
        } while (!struser.matches(regex));

        user = Integer.parseInt(struser);
        double a = Math.random();
        int com = (int) (a * 3) + 1; // 1, 2, 3 중 무작위로 선택

        System.out.printf("컴퓨터 : %s , 사용자 : %s\n", com1[com - 1], com1[user - 1]);

        switch (user - com) {
            case -2:
            case 1:
                System.out.println("사용자 승리");
                break;
            case -1:
            case 2:
                System.out.println("컴퓨터 승리");
                break;
            default:
                System.out.println("무승부");
                break;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

}
*/
