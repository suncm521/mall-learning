package com.hxf.mall.service;

import com.hxf.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author Suncm
 * @ClassName PmsBrandService
 * @Date 2019/12/13 14:28
 * @Version 1.0
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
