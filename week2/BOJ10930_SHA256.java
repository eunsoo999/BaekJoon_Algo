package week2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class BOJ10930_SHA256 {
	
	public static byte[] sha256(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256"); //��ü ����
		md.update(msg.getBytes()); // �Է°��� �� ��(String�� byte������ ��ȯ)
		
		return md.digest(); // ����� : �ؽ��� ȣ��
	}
	
	public static String bytesToHex1(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		System.out.println(bytesToHex1(sha256(str)));
	}
}