package com.imooc.service;

import com.imooc.dto.ShopExcution;
import com.imooc.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

public interface ShopService {
    ShopExcution addShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException;
}
