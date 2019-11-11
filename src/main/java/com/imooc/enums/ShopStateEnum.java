package com.imooc.enums;

public enum ShopStateEnum {
    CHECK(0,"审核") ,OFFLINE(-1, "非法商铺"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"), INNER_ERROR(
            -1001, "操作失败"), NULL_SHOPID(-1002, "ShopId为空"), NULL_SHOP_INFO(
            -1003, "传入了空的信息");
    private int state;
    private String stateInfo;
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }



    ShopStateEnum(int i, String stateInfo) {
        this.state=i;
        this.stateInfo=stateInfo;
    }
    public  static ShopStateEnum stateof(int index){
        for (ShopStateEnum state:values())
        {
            if(state.getState()==index)
                return state;
        }
        return null;
    }
}
