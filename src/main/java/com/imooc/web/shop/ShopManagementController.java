package com.imooc.web.shop;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.entity.Shop;
import com.imooc.util.HttpServletRequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
@Controller
public class ShopManagementController {

    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    private Map<String,Object> registerShop(HttpServletRequest request ){
        //
        Map<String,Object> modelmap=new HashMap<>();
        String shopstr= HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper=new ObjectMapper();
        Shop shop=null;
        try{
            shop=mapper.readValue(shopstr,Shop.class);

        } catch (Exception e){
            modelmap.put("success",false);
            modelmap.put("errMsg",e.getMessage());
        }
        return modelmap;
    }
    @RequestMapping(value = "/test")
    private String test(){
        return "shop/test";
    }


}
