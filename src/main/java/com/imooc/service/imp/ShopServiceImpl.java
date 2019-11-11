package com.imooc.service.imp;

import com.imooc.dao.ShopDao;
import com.imooc.dto.ShopExcution;
import com.imooc.entity.Shop;
import com.imooc.enums.ShopStateEnum;
import com.imooc.service.ShopService;
import com.imooc.util.FileUtil;
import com.imooc.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;
@Service
public class ShopServiceImpl implements ShopService {
    private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
        String dest = FileUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImgAddr);
    }
    @Autowired
private ShopDao shopDao;
    @Override
    @Transactional
    public ShopExcution addShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException {
        if(shop==null)
        {
            return new ShopExcution(ShopStateEnum.NULL_SHOP_INFO);
        }
        try{
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int eff=shopDao.insertShop(shop);
            if(eff<=0) {
                throw new RuntimeException("店铺创建失败");
            }else{
                if(shopImg!=null)
                {
                    addShopImg(shop,shopImg);
                }
            }

        }catch (Exception e)
        {
            throw new RuntimeException("add shoperror" +e.getMessage());
        }
        return new ShopExcution(ShopStateEnum.CHECK, shop);
    }
}
