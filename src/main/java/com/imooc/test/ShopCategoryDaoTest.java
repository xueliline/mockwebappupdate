package com.imooc.test;

import com.imooc.dao.ShopCategoryDao;
import com.imooc.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private  ShopCategoryDao shopCategoryDao;
    @Test
    public void tt ()throws Exception
    {
        ShopCategory shopCategory=new ShopCategory();
        shopCategory.setCreateTime(new Date());
        shopCategory.setLastEditTime(new Date());
        shopCategory.setPriority(1);
        shopCategory.setShopCategoryDesc("ss");
        shopCategory.setShopCategoryImg("dddd");
        shopCategory.setShopCategoryName("衣服");
        shopCategory.setShopCategoryId(1L);
        int res=shopCategoryDao.insertShopCategory(shopCategory);
    }
}
