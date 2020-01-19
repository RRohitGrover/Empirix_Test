package Emprix.Start;

import java.io.UnsupportedEncodingException;

public class Test_Lang {

	public static void main(String[] args) throws Exception {
		String a ="アラート";
		String b = "Alerts";
		byte[] arr = a.getBytes("US-ASCII");
		byte[] arr1 = b.getBytes("US-ASCII");
		
		for(int i : arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i : arr1)
		{
			System.out.print(i+" ");
		}
	}

}
