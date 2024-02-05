package days19;

import java.io.FileReader;

public class Review4 {
	public static void main(String[] args) {
		int lines[] = new int['Z'-'A'+1+'z'-'a'+1+'9'-'0'+1];
		int line;
		String readPath = "C:\\Users\\user\\git\\MyJava\\javaPro\\src\\days18\\Ex01.java";
		try (FileReader fr = new FileReader(readPath);){
			while ((line=fr.read())!=-1) {
					if (line>='A'&&line<='Z') {
						lines[line-'A']+=1;
					} else if(line>='a'&&line<='z') {
						lines[line-'a'+26]+=1;
					}	else if(line>='0'&&line<='9') {
						lines[line-'0'+52]+=1;
					}
				
				}
			for (int i = 0; i < lines.length; i++) {
				
				System.out.printf("[%c] :%s%d개\n",(i<=25?'A'+i:(i<=51?'a'+i-26:'0'+i-52)),"#".repeat(lines[i]),lines[i]);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
