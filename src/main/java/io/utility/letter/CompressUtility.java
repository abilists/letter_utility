package io.utility.letter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * reference URL https://myadventuresincoding.wordpress.com/2016/01/02/java-simple-gzip-utility-to-compress-and-decompress-a-string/
 * 
 * @author home
 *
 */
public class CompressUtility {
	
	private static final int DEFAULT_VALUE = 6;

	/**
	 * Compress files as ZIP
	 * 
	 * @param srcFiles
	 * @param parentPath
	 * @param nameZip
	 * @throws Exception
	 */
    public static void compressByFiles(final List<String> srcFiles, String parentPath, String nameZip) throws Exception {

        Path path = Paths.get(parentPath).toAbsolutePath();
        FileOutputStream fos = null;
        ZipOutputStream zipOut = null;
        try {
	        fos = new FileOutputStream(path + "/" + nameZip);
	        zipOut = new ZipOutputStream(fos);

	        for (String srcFile : srcFiles) {
	        	FileInputStream fis = null;
	        	try {
		            File fileToZip = new File(srcFile);
		            fis = new FileInputStream(fileToZip);
		            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
		            zipOut.putNextEntry(zipEntry);

		            byte[] bytes = new byte[1024];
		            int length;
		            while((length = fis.read(bytes)) >= 0) {
		                zipOut.write(bytes, 0, length);
		            }
				} finally {
					if(fis != null) {
						fis.close();
					}
				}
	        }

		} catch (Exception e) {
			throw new RuntimeException("Failed to zip files", e);
		}finally {
			if(zipOut != null) {
				zipOut.close();
			}
			if(fos != null) {
				fos.close();
			}
		}
    }
	
	/**
	 * Compress String data
	 * 
	 * @param data original String data
	 * @return
	 * @throws Exception
	 */
	public static byte[] compress(final String data) throws Exception {

		try(
			ByteArrayOutputStream baOut = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(baOut) {
				{def.setLevel(DEFAULT_VALUE);}
			};
		) {
			gzip.write(data.getBytes(StandardCharsets.UTF_8));
			gzip.finish();
			gzip.flush();
			return baOut.toByteArray();
		} 
		catch (Exception e) {
			throw new RuntimeException("Failed to zip content", e);
		}

	}

	/**
	 * DeCompress String data
	 * 
	 * @param data Ziped
	 * @return
	 * @throws Exception
	 */
	public static String deCompress(final byte[] data) throws Exception {

	    if ((data == null) || (data.length == 0)) {
	        throw new IllegalArgumentException("Cannot unzip null or empty bytes");
	    }
		
		if (!isZipped(data)) {
	        return new String(data);
	    }

		ByteArrayInputStream baIn = null;
		GZIPInputStream gzip = null;
		InputStreamReader insReader = null;
		BufferedReader bufferedReader = null;
		try {
			baIn = new ByteArrayInputStream(data);
			gzip = new GZIPInputStream(baIn);
			insReader = new InputStreamReader(gzip, StandardCharsets.UTF_8);
			bufferedReader = new BufferedReader(insReader);

            StringBuilder output = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine()) != null) {
              output.append(line);
            }

            return output.toString();
		} catch (Exception e) {
			throw new RuntimeException("Failed to unzip content", e);
		}finally {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
			if(insReader != null) {
				insReader.close();
			}
			if(gzip != null) {
				gzip.close();
			}
			if(baIn != null) {
				baIn.close();
			}
		}

	}

	/**
	 * Check if it is ziped
	 * 
	 * @param compressed
	 * @return
	 */
	public static boolean isZipped(final byte[] compressed) { 
		
		if( (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) 
				&& (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8)) ) {
			return true;
		} else {
			return false;
		}
	}

}
