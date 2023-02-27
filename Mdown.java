package algo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Mdown {

	
	
	// 배열 만들어서 n번째 배열이 n-1 과 n-2가 공백이면 # 2개만 붙이개 업글할것

	
	public static void main(String[] args) {

		try {

			// 파일 읽어스 string 객체를 정렬하는 프로그램 구성
			Path input = Paths.get("바꿀꺼.txt");

			byte[] bytes = Files.readAllBytes(input);
						// ------------------- 추가한 코드

			// file 입출력 + String 처리 + 정렬 코딩
			String s = new String(bytes);
			String[] sa = s.split("\n");
			String[] md = new String[sa.length];
			for (int i=0; i<sa.length; i++) {
				md[i]= "### "+sa[i];
			}
			System.out.println(md[80]);

			// --정렬 코딩하기-------------------------

			int bufferSize = 50240;
			String b = " ";
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			for (String sx : md) {
				
				buffer.put(sx.getBytes());
				buffer.put(b.getBytes());
			}
			buffer.flip();
			FileOutputStream file = new FileOutputStream("바뀐거.txt");
			FileChannel channel = file.getChannel();
			channel.write(buffer);
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
