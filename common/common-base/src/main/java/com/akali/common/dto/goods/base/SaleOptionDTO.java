package com.akali.common.dto.goods.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * @ClassName SpuSaleOptionDTO
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/11/13 0013
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOptionDTO {
    /**
     * 选项名
     */
    private String name;

    public SaleOptionDTO(Object object) {
        BeanUtils.copyProperties(object,this);
    }
}
