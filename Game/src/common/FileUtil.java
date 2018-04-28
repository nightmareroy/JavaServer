package common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Collection;



public class FileUtil {
	public static String read(File file) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
	
			String content = "";
			StringBuilder sb = new StringBuilder();
	
			while (content != null) {
				content = bf.readLine();
	
				if (content == null) {
					break;
				}
	
				sb.append(content.trim());
			}
	
			bf.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String read(String filePath){
		File file = new File(filePath);
		return read(file);
	}

	public static void write(File file,String content) {
		try {
			if (file.exists()) {
				byte[] text = Files.readAllBytes(file.toPath());
				byte[] newText = content.getBytes("UTF-8");

				boolean same = true;
				if (text.length == newText.length) {
					for (int i = 0; i < text.length; i++) {
						if (text[i] != newText[i]) {
							same = false;
							break;
						}
					}
				} else {
					same = false;
				}

				if (!same) {
					Files.write(file.toPath(), newText);
				} else {
					Out.info("检查未变更，忽略生成", file.getName());
				}
			} else {
				Files.write(file.toPath(), content.getBytes("UTF-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write(String filePath,String content){
		File file = new File(filePath);
		write(file,content);
	}
	
	/**
	 * 创建文件夹
	 */
	public static boolean createFolder(File parent,String folderName) {
		File file=new File(parent, folderName);
		if(!file.exists()) {
			Out.info("创建文件夹：",parent+folderName);
			return file.mkdirs();
		}
		return false;
	}
	public static boolean createFolder(String parentPath,String folderName) {
		File file=new File(parentPath);
		return createFolder(file,folderName);
	}
	
//	/**
//	 * 复制一个文件 如果是源文件是目录、或者不存在、或者不可读、或者目标文件已存在返回false
//	 * 
//	 * @param src 源文件名
//	 * @param dest 目标文件名
//	 * @return
//	 */
//	public static boolean copy(String src, String dest) {
//		File srcFile = new File(src);
//		if (!(srcFile.exists() && srcFile.isFile() && srcFile.canRead())) {
//			return false;
//		}
//		File destFile = new File(dest);
//		if (destFile.exists()) {
//			destFile.delete();
//		}
//
//		BufferedInputStream bis = null;
//		BufferedOutputStream bos = null;
//		try {
//			bis = new BufferedInputStream(new FileInputStream(srcFile));
//			bos = new BufferedOutputStream(new FileOutputStream(destFile));
//			byte[] buf = new byte[1024];
//			int len = 0;
//			while ((len = bis.read(buf)) != -1) {
//				bos.write(buf, 0, len);
//			}
//
//			return true;
//		} catch (FileNotFoundException e) {
//			Out.error("FileUtil copy", e);
//		} catch (IOException e) {
//			Out.error("FileUtil copy", e);
//		} finally {
//			if (bos != null) {
//				try {
//					bos.close();
//				} catch (IOException e) {}
//			}
//			if (bis != null) {
//				try {
//					bis.close();
//				} catch (IOException e) {}
//			}
//		}
//
//		return false;
//	}
//
	/**
	 * 清除文件所有内容
	 * 
	 * @param file 要清除内容的文件
	 * @return
	 */
	public static boolean clearFile(File file) {
		if(!file.isFile()) {
			return false;
		}
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileWriter(file, false));
			writer.close();
		} catch (IOException e) {
			Out.error("FileUtil clear", e);
			return false;
		}
		return true;
	}
	
	/**
	 * 删除文件夹下的所有文件及文件夹
	 * 
	 * @param file
	 * @return
	 */
	public static boolean clearDirectory(File file) {
		if(!file.isDirectory()) {
			return false;
		}
		File[] files = file.listFiles();
		for (File file2 : files) {
			boolean result = deleteDirectory(file2);
			if(!result) {
				return false;
			}
		}
		return true;
	}
	public static boolean deleteDirectory(String directoryPath) {
		File file = new File(directoryPath);
		return clearDirectory(file);
	}
	
	/**
	 * 删除文件夹以及其下的所有文件及文件夹
	 * 
	 * @param file
	 * @return
	 */
	public static boolean deleteDirectory(File file) {
		if(file.isFile()) {
			return file.delete();
		}
		else if(file.isDirectory()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				boolean result = deleteDirectory(file2);
				if(!result) {
					return false;
				}
			}
			return file.delete();
		}
		return false;
	}
	
//
//	/**
//	 * 文件转字节数组
//	 */
//	public static byte[] file2bytes(File file) {
//		BufferedInputStream in = null;
//		try {
//			in = new BufferedInputStream(new FileInputStream(file));
//			ByteArrayOutputStream out = new ByteArrayOutputStream(in.available());
//			byte[] temp = new byte[1024];
//			int size = 0;
//			while ((size = in.read(temp)) != -1) {
//				out.write(temp, 0, size);
//			}
//			return out.toByteArray();
//		} catch (Exception e) {
//			Out.error("FileUtil file2bytes", e);
//		} finally {
//			if (in != null) {
//				try {
//					in.close();
//				} catch (IOException e) {
//					Out.error("FileUtil file2bytes", e);
//				}
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * 大文件拷贝（推荐）
//	 */
//	public static void copyNio(final File from, final File to) throws IOException {
//		final RandomAccessFile inFile = new RandomAccessFile(from, "r");
//		try {
//			final RandomAccessFile outFile = new RandomAccessFile(to, "rw");
//			try {
//				final FileChannel inChannel = inFile.getChannel();
//				final FileChannel outChannel = outFile.getChannel();
//				long pos = 0;
//				long toCopy = inFile.length();
//				while (toCopy > 0) {
//					final long bytes = inChannel.transferTo(pos, toCopy, outChannel);
//					pos += bytes;
//					toCopy -= bytes;
//				}
//			} finally {
//				outFile.close();
//			}
//		} finally {
//			inFile.close();
//		}
//	}
//
//	/**
//	 * 逐行写入文件
//	 */
//	public static void write(File file, Collection<String> lines) {
//		try {
//			PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, false), Charset.forName("UTF-8")), true);
//			for (String key : lines) {
//				writer.println(key);
//			}
//			writer.close();
//			writer = null;
//		} catch (Exception e) {
//			Out.error("FileUtil write", e);
//		}
//	}
}
