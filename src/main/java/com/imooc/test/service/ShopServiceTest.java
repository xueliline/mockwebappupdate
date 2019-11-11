package com.imooc.test.service;

import com.imooc.dto.ShopExcution;
import com.imooc.entity.Area;
import com.imooc.entity.Shop;
import com.imooc.entity.ShopCategory;
import com.imooc.service.ShopService;
import com.imooc.test.BaseTest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;
	private FileItem createFileItem(File file, String fieldName) {
		FileItemFactory factory = new DiskFileItemFactory(16, null);
		FileItem item = factory.createItem(fieldName, "text/plain", true, file.getName());
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		try {
			FileInputStream fis = new FileInputStream(file);
			OutputStream os = item.getOutputStream();
			while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Test
	public void testAddShop() throws Exception {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setOwnerId(5L);
		Area area = new Area();
		area.setAreaId(1L);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(1L);
		shop.setShopName("mytest1");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		shop.setShopImg("test1");
		shop.setLongitude(1D);
		shop.setLatitude(1D);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(sc);
		File  showImg=new File("C:\\Users\\Susan\\Pictures\\fj.jpg");
		FileItem  fileitem=createFileItem(showImg,"test.jpg");
		CommonsMultipartFile mfile = new CommonsMultipartFile(fileitem);
		ShopExcution se = shopService.addShop(shop,mfile);
		assertEquals("mytest1", se.getShop().getShopName());
	}


//	@Test
//	public void testGetByEmployeeId() throws Exception {
//		long employeeId = 1;
//		ShopExcution shopExecution = shopService.getByEmployeeId(employeeId);
//		List<Shop> shopList = shopExecution.getShopList();
//		for (Shop shop : shopList) {
//			System.out.println(shop);
//		}
//	}

//	@Ignore
//	@Test
//	public void testGetByShopId() throws Exception {
//		long shopId = 1;
//		Shop shop = shopService.getByShopId(shopId);
//		System.out.println(shop);
//	}

}
