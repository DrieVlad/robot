package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import gui.*;

public class TestLog
{
	static int n = 0;
	static File fi;
	static FileReader file;
	static Scanner scan;
	static ArrayList<String> list = new ArrayList<String>();
	
	@BeforeClass
	public static void beforeTest() throws IOException
	{
		System.out.println("st");
		fi = new File("C:\\log\\robots.log");
		if (fi.exists()) {
		    fi.delete();
		    fi.createNewFile();
		}
		System.out.println("end");
		file = new FileReader("C:\\log\\robots.log");
		scan = new Scanner(file);
		MainApplicationFrame MAF = new MainApplicationFrame();
		
		while(scan.hasNextLine()) 
		{
			list.add(scan.nextLine());
		    n++;
		}
		
		file.close();
		
	}
	
	@Test
	public void testCount()
	{
		assertEquals(4, n);
	}
	@Test
	public void testValue_1()
	{
		assertTrue(list.get(0).indexOf("Протокол работает") > -1);
	}
	@Test
	public void testValue_2()
	{
		assertTrue(list.get(1).indexOf("Окно логов создано") > -1);
	}
	@Test
	public void testValue_3()
	{
		assertTrue(list.get(2).indexOf("Инициализация") > -1);
	}
	@Test
	public void testValue_4()
	{
		assertTrue(list.get(3).indexOf("Основное окно создано") > -1);
	}
}
