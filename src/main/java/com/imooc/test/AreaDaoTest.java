package com.imooc.test;

import com.imooc.dao.AreaDao;
import com.imooc.entity.Area;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AreaDaoTest extends BaseTest {
	@Autowired
	private AreaDao areaDao;

	@Test
	public void testAInsertArea() throws Exception {
		Area area = new Area();
		area.setAreaName("区域1");
		area.setPriority(1);
		area.setCreateTime(new Date());
		area.setLastEditTime(new Date());
		int effectedNum = areaDao.insertArea(area);
		assertEquals(1, effectedNum);
	}


}
