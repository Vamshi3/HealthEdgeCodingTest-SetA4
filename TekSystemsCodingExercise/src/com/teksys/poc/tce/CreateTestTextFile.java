package com.teksys.poc.tce;
/*
 * Client Task: Healthedge Coding Exercise through TekSystems
 * Program: To Create a Text File Locally and input numeric values from User which 
 *          has to be converted to Engish in New Result Text File.
 * Author Name : Vamshi Krishna
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateTestTextFile {
	public static void main(String[] args) {
		try {
			CreateTestTextFile tf = new CreateTestTextFile();
			Scanner scan = new Scanner(System.in);
			String filename = "";
			while (filename.trim().length() == 0) {
				//Example file path can be C:\Testing\CreateFile.txt
				filename = tf.getUserInput(scan, "Please enter file location path and its name");
			}
			String resultfilename = "";
			while (resultfilename.trim().length() == 0) {
				//Example file path can be C:\Testing\ResultFile.txt
				resultfilename = tf.getUserInput(scan, "Please enter result file location and path");
			}
			File file = new File(filename);
			File resultfile = new File(resultfilename);
			if (!file.exists() || ! resultfile.exists()) {
				System.out.println("New File Has Been Created!");
				tf.collectUserInput(file, scan);
				tf.createResultFile(file,resultfile);
			} else {
				System.out.println("File already exists.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getUserInput(Scanner scan, String msg) {
		System.out.println(msg + " : ");
		String filename = scan.nextLine().trim();
		return filename;
	}

	private void createResultFile(File file,File resultFile) {
		CreateTestTextUtil singleton = CreateTestTextUtil.singleton();
		BufferedReader reader;
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			fw = new FileWriter(resultFile);
			bw = new BufferedWriter(fw);
			String line = null;
			while ((line = reader.readLine()) != null) {
				{
					line = line.replace("$", "").trim();
					String[] split = line.split("[.]");
					if (split.length > 2) {
						System.out.println("Invalid value - has multiple decimal points");
					}

					String dollerVaue = singleton.getStringForInt(Integer.parseInt(split[0]));
					String centVaue = singleton.getStringForInt(Integer.parseInt(split[1]));
					if ("Zero".equals(centVaue)) {
						dollerVaue = dollerVaue + " doller only \n";
					} else {
						dollerVaue = dollerVaue + " doller and " + centVaue + " cents only \n";
					}
					System.out.println(dollerVaue);
					bw.write(dollerVaue);
					bw.newLine();
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void collectUserInput(File file, Scanner scan) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			System.out.println("Please Enter the data:");
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			while (true) {

				String text = scan.nextLine();
				// User has to input "Done" in case of completing the entering of Currency Values
				if ("Done".equalsIgnoreCase(text)) {
					break;
				}
				bw.write(text);
				bw.newLine();
			}

		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			}

			catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
