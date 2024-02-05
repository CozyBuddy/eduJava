package days06;

import java.util.Iterator;

public class Star {
	public static void main(String[] args) {
		/*
		 * /*


*
**
***
****

****
****
**
*

___*
__**
_***
****

****
_***
__**
___*

 이등변삼각형
__*
_***
*****

*
_*
__*
___*
____*

____*
___*
__*
_*
*

*___* 1,5
_*_* 2,4
__* 3
_*_* 2,4
*___* 1,5

마름모
__*
_***
*****
_***
__*
		 */
		for (int i = 1; i <=5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i==j || i==6-j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			System.out.println();
			
		}
	}

	}
}
