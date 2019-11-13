package com.akali.common.code;

import com.google.common.collect.ImmutableMap;

/**
 * @ClassName ProductCode
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/11/13 0013
 * @Version V1.0
 **/
public enum ProductCode implements ResultCode{
    /**
     *
     */
    SPU_DETAIL_NOT_EXSIST(false,30025,"商品详情不存在"),
    THE_SKU_IS_EXSIST(false,30025,"添加的商品sku已存在"),
    ;

    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private ProductCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, ProductCode> CACHE;
    static {
        final ImmutableMap.Builder<Integer, ProductCode> builder = ImmutableMap.builder();
        for (ProductCode commonCode : values()) {
            builder.put(commonCode.code(), commonCode);
        }
        CACHE = builder.build();
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
