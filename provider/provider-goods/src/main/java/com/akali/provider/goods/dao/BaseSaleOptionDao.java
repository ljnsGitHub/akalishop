package com.akali.provider.goods.dao;

import com.akali.common.dto.goods.SaleOptionDTO;
import com.akali.provider.goods.bean.PmsSaleOption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName BaseSaleOptionDao
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/11/13 0013
 * @Version V1.0
 **/
public interface BaseSaleOptionDao extends CrudRepository<PmsSaleOption,Long> {
    @Query("select new com.akali.common.dto.goods.SaleOptionDTO(s) from PmsSaleOption s where s.cateId = ?1")
    List<SaleOptionDTO> findByCateId(Long cateId);
}
