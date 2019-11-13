package com.akali.provider.goods.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AttributionDTO
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/11/11 0011
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributionDTO {
    /**
     * 三级分类id
     */
    private Long cateId;
    /**
     * 参数所属分组
     */
    private Long groupId;
    /**
     * 参数名
     */
    private String name;
    /**
     * 是否是数值类型 true是，false不是
     */
    private Boolean numeric;
    /**
     * 数组类型的单位
     */
    private String unit;

    /**
     * 是否是通用属性，true是，false不是
     */
    private Boolean generic;
    /**
     * 是否参与搜索
     */
    private Boolean searching;
    /**
     * 是否是固定选项，true是，false不是
     */
    private Boolean hasOptions;
}
