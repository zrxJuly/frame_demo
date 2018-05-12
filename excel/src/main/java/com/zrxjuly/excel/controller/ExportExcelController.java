package com.zrxjuly.excel.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.zrxjuly.excel.entity.User;

/**
 * 导出数据到Excel
 * @author zrxJuly
 *
 */
public class ExportExcelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 第一步，创建一个WEBBOOK，对应一个Excel文件
			HSSFWorkbook wb = new HSSFWorkbook();
			// 第二步，在WEBBOOK中添加一个sheet，对应Excel文件中的sheet
			HSSFSheet sheet = wb.createSheet("人员信息");
			// 设置每列的宽度
			sheet.setColumnWidth(0, 8000);// 序号
			sheet.setColumnWidth(1, 8000);// 姓名
			sheet.setColumnWidth(2, 8000);// 年龄
			sheet.setColumnWidth(3, 8000);// 性别
			sheet.setColumnWidth(4, 8000);// 爱好
			sheet.setColumnWidth(5, 10000);// 学校
			// 设置字体.
			HSSFFont headfont = wb.createFont();
			headfont.setFontName("微软雅黑");
			headfont.setFontHeightInPoints((short) 15);// 字体大小.
			headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗.
			
			// 设置字体.
			HSSFFont font = wb.createFont();
			font.setFontName("微软雅黑");
			font.setFontHeightInPoints((short) 11);// 字体大小.
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗.
			
			// 设置字体
			HSSFFont font1 = wb.createFont();
			font1.setFontName("微软雅黑");
			font1.setFontHeightInPoints((short) 12);// 字体大小
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			// 字体
			HSSFFont font2 = wb.createFont();
			font2.setFontName("微软雅黑");
			font2.setFontHeightInPoints((short) 12);// 字体大小
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			font2.setColor((short) 2);
			
			// 第三步，创建单元格，并设置表头水平居中.
			// 样式一
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			style.setFont(headfont);
			// 样式二
			HSSFCellStyle s = wb.createCellStyle();
			s.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
			s.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			s.setFont(font);
			// 样式三
			HSSFCellStyle s1 = wb.createCellStyle();
			s1.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
			s1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			s1.setFont(font1);
			// 样式四
			HSSFCellStyle s2 = wb.createCellStyle();
			s2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平靠左
			s2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			s2.setFont(font2);
			
			// 第四步，在sheet中添加表头第0行.
			// 创建第一行.
			HSSFRow row0 = sheet.createRow(0);
			row0.setHeight((short) 1000);
			
			// 创建第一列.
			HSSFCell cell0 = row0.createCell(0);
			cell0.setCellValue("人员信息名单列表");
			cell0.setCellStyle(style);
			/**
			 * 合并单元格 第一个参数：第一个单元格的行数（从0开始） 第二个参数：第二个单元格的行数（从0开始）
			 * 第三个参数：第一个单元格的列数（从0开始） 第四个参数：第二个单元格的列数（从0开始）
			 */
			CellRangeAddress range = new CellRangeAddress(0, 0, 0, 5);
			sheet.addMergedRegion(range);
			
			// 创建第二行.
			HSSFRow row1 = sheet.createRow(1);
			row1.setHeight((short) 500);
			// 创建列.
			HSSFCell cell1 = row1.createCell(0);
			cell1.setCellValue("序号");
			cell1.setCellStyle(s);
			
			cell1 = row1.createCell(1);
			cell1.setCellValue("姓名");
			cell1.setCellStyle(s);
			
			cell1 = row1.createCell(2);
			cell1.setCellValue("年龄");
			cell1.setCellStyle(s);
			
			cell1 = row1.createCell(3);
			cell1.setCellValue("性别");
			cell1.setCellStyle(s);
			
			cell1 = row1.createCell(4);
			cell1.setCellValue("爱好");
			cell1.setCellStyle(s);
			
			cell1 = row1.createCell(5);
			cell1.setCellValue("学校");
			cell1.setCellStyle(s);
			
			List<User> list = this.userList();
			
			// 第六步，写入实体数据，实际应用中这些数据从数据库中得到.
			for (int i = 0; i < list.size(); i++) {
				User user = list.get(i);
				// 创建行. 由于第一行和第二行已经创建，所以这里从第三行开始创建，因此i+2.
				HSSFRow row = sheet.createRow(i + 2);
				row.setHeight((short) 450);
				// 创建单元格，并设置值.
				HSSFCell cell = row.createCell(0);
				cell.setCellValue(i+1);// 序号
				cell.setCellStyle(s1);
				
				cell = row.createCell(1);
				cell.setCellValue(user.getName());
				cell.setCellStyle(s1);
				
				cell = row.createCell(2);
				cell.setCellValue(user.getAge());
				cell.setCellStyle(s1);
				
				cell = row.createCell(3);
				cell.setCellValue(user.getSex());
				cell.setCellStyle(s1);
				
				cell = row.createCell(4);
				cell.setCellValue(user.getHobby());
				cell.setCellStyle(s1);
				
				cell = row.createCell(5);
				cell.setCellValue(user.getSchool());
				cell.setCellStyle(s1);
			}
			
			// 第七步，将文件存到流中.
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			wb.write(os);
			// 设置导出文件名.
			String excelName = new String("人员信息列表".getBytes(), "iso-8859-1");
			excelName = excelName + ".xls";
			resp.setContentType("application/vnd.ms-excel");
			resp.setHeader("Content-disposition", "attachment;filename=" + excelName);
			OutputStream outputStream = resp.getOutputStream();
			wb.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	public List<User> userList() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setAge(18);
		user.setHobby("篮球");
		user.setName("zs");
		user.setPwd("123456");
		user.setSchool("山东大学");
		user.setSex(2);// 1:男 2：女
		users.add(user);
		User user2 = new User();
		user2.setAge(20);
		user2.setHobby("乒乓球");
		user2.setName("zs");
		user2.setPwd("123456");
		user2.setSchool("山东大学");
		user2.setSex(2);// 1:男 2：女
		users.add(user2);
		return users;
	}
}
