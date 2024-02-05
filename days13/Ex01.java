package days13;

import days14.TV;
import days14.Time;

/**
 * @author user
 * @date 2024. 1. 17. 오전 10:09:43
 * @subject
 * @contents
 */
public class Ex01 {
	public static void main(String[] args) {
		//1.Git 개요
		// 2. GitHub 계정 생성
		// 3. Git 설치
		// 4. New Repository - javaPro
		// 5. Token : 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
		// 6. E:\Class\Workspace\JavaClass-Home (집)
		// 7. E:\Class\Workspace\JavaClass-Sist (교육원)
		// 8. Git 사용자 등록
		//  $ git config --global user.name "사용자이름"
		//  $ git config --global user.email "사용자이메일"
		// 확인 방법 $ git config user.name
		// git remote -v
		// fatal: not a git repository (or any of the parent directories): .git
		// 9 .로컬 저장소 생성
		// $ git init
		// 10. 파일 확인
		// git ls\
		// 11. java project : gitPro
		// 11-2 .gitignore 파일 확인 /.metadata/
		// 12 . $git status 깃 상태 확인
		/*$ git status
		On branch master

		No commits yet

		Changes to be committed:
		(use "git rm --cached <file>..." to unstage)
		new file:   Hello.java

		Untracked files:
		(use "git add <file>..." to include in what will be committed)
				.gitignore
				gitPro/*/
		//13 . 다시 원격저장소 확인 -> 원격저장소 등록
		//origin  https://github.com/CozyBuddy/javaPro.git (fetch)
		//origin  https://github.com/CozyBuddy/javaPro.git (push)

		// walking directory , stage file, commit files 을 JavaClass-Sist 폴더가 다 함유하고 있음.
		//14. stage area 에 untracked files 을 추가
		//$ git add . (전부 )
		//15. 로컬 저장소 (git directory || local directory)에 추가
		// $ git commit -m "first javaPro commit"
		// 16. 원격 저장소 (GitHub directory )에 추가하는 명령어
		// $ git push --set-upstream origin master
		// 숨긴 .git 파일 삭제하면 관리대상에서 다 빠짐.
		// 17.JavaClass-Sist(교육원) -> 원격저장소
		// -- [집] -- JavaClass-Home 폴더 가정
		// 1) E:\Class\Workspace\JavaClass-Home 폴더로 이동
		// 2) Git Repository (깃 로컬 저장소) 생성 (init(단순 생성) , clone(원격에서 복제할때) )//폴더에서 gitbash 띄움
		// git clone 

		// git config user.name , user 이메일
		// git remote add origin 주소
		// ***[이클립스 + git명령어] ***
		// 1. javaClass-Sist (교육원)사용 예정.
		// gitpro 자바프로젝트 생성
		// 2.GitHub 
		// 	javaPro 원격저장소 생성
		// 3.javaPro 원격저장소를 복제
		// 해당 주소를 먼저 복사
		// 3-2 .C:\Users\ user\git\javaPro 로컬 저장소 설정
		// ㄴ .git폴더
		// 원격 저장소로 부터 저장한 파일
		// git clone 아이디 패스워드에서 패스워드는 toekn 값임
		TV tv1 = new TV();
		Time t = new Time();
		t.hour=1;
		

		System.out.println(tv1.power);




	}	

}
