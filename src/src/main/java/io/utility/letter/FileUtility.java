package io.utility.letter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class FileUtility {

	public static String DEFAULT_ENCODING = "UTF-8";

	public static BufferedReader readFileBuffered(String path, String ext, String encoding) throws Exception {

		StringBuffer sbFilePath = new StringBuffer();
		File userFile = null;
		BufferedReader fsReader = null;
		Reader reader = null;

		sbFilePath.append(path);
		if(ext != null) {
			sbFilePath.append(".").append(ext);
		}

		if(encoding != null) {
			reader = new InputStreamReader(new FileInputStream(sbFilePath.toString()),encoding);
		} else {
			reader = new InputStreamReader(new FileInputStream(sbFilePath.toString()));
		}

		userFile = new File(sbFilePath.toString());
		if(!userFile.exists()) {
			return null;
		}

		fsReader = new BufferedReader(reader);

		return fsReader;
	}

	public static BufferedReader readFileBuffered(String path) throws Exception {
		return readFileBuffered(path, null, null);
	}

	public static BufferedReader readFileBuffered(String path, String encoding) throws Exception {
		return readFileBuffered(path, null, encoding);
	}

	public static FileReader readFileReader(String path, String ext) throws Exception {

		StringBuffer sbFilePath = new StringBuffer();
		File userFile = null;
		FileReader fsReader = null;

		sbFilePath.append(path);
		if(ext != null) {
			sbFilePath.append(".").append(ext);
		}

		userFile = new File(sbFilePath.toString());

		if(!userFile.exists()) {
			return null;
		} else {
			fsReader = new FileReader(userFile);
		}

		return fsReader;
	}

	public static String readFileString(String path) throws Exception {

		String strReadResult = null;
		
		FileReader fileReader = readFileReader(path, null);
		LineNumberReader lnReader = new LineNumberReader(fileReader);

		StringBuffer sbOut = new StringBuffer();
		while((strReadResult = lnReader.readLine()) != null) {
			sbOut.append(strReadResult);
		}
		
		return sbOut.toString();
	}

	public static FileReader readFile(String path) throws Exception {
		return readFileReader(path, null);
	}

	public static byte[] readFileByte(String fullFilePath) throws Exception {

		File file = new File(fullFilePath);

		return readFileByte(file);
	}

	public static byte[] readFileByte(File file) throws Exception {

		if (!file.exists()) {
			return null;
		}

		// Set length of file
		long fileLength = file.length();

		// Create the byte array to hold the data
		byte[] byteOut = new byte[(int) fileLength];

		try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
			while ((is.read(byteOut)) > 0) {}
		} catch (IOException e) {
			throw e;
		}

		return byteOut;
	}

	public static void saveFile(String fullPathFileName, byte[] byteOut) throws IOException {
		File file = new File(fullPathFileName);
		saveFile(file, byteOut);
	}

	public static void saveFile(File fileDir, byte[] byteOut) throws IOException {

		fileDir.getParentFile().mkdirs();
		fileDir.createNewFile();
		File file = new File(fileDir.getParentFile(), fileDir.getName());

		try (OutputStream os = new FileOutputStream(file); 
				InputStream in = new ByteArrayInputStream(byteOut);) {

			int n = -1;
			while ((n = in.read(byteOut)) > 0) {
				os.write(byteOut, 0, n);
			}
			os.flush();
			
		} catch (IOException e) {
			throw e;
		}

	}

	/**
	 * 
	 * @param fileName
	 * @param extend
	 * @param byteOut
	 * @throws IOException
	 */
	public static void saveFileByte(String fileName, String extend, byte[] byteOut) throws IOException {

		fileName = StringUtility.getFileName(fileName, extend);
		File file = new File(fileName);

		try (OutputStream os = new FileOutputStream(file);
				InputStream in = new ByteArrayInputStream(byteOut);) {
	        int n = -1;
	        while((n = in.read(byteOut)) > 0) {
	        	os.write(byteOut, 0, n);
	        }
	        os.flush();
		} catch (IOException e) {
			throw e;
		}

	}

	public static void saveFileString(String fileName, String extend, String contents) throws IOException {
		FileUtility.saveFileString(fileName, null, contents, DEFAULT_ENCODING);
	}

	public static void saveFileString(String fileName, String extend, String contents, String encoding) throws IOException {

		fileName = StringUtility.getFileName(fileName, extend);

		System.out.println(fileName);
		File file = new File(fileName);
		OutputStream os = new FileOutputStream(file);
		Writer out = new OutputStreamWriter(os, encoding);
		out.write(contents);

		out.close();
        os.flush();
        os.close();
	}
}