package com.xiaoyuer.service.impl;

import com.xiaoyuer.entity.po.ProductInfo;
import com.xiaoyuer.entity.query.ProductInfoQuery;
import com.xiaoyuer.entity.query.SimplePage;
import com.xiaoyuer.entity.vo.PaginationResultVO;
import com.xiaoyuer.enums.PageSize;
import com.xiaoyuer.mapper.ProductInfoMapper;
import com.xiaoyuer.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 商品信息Service
 * @author: xiaoyuer
 * @date: 2023/11/05
 */
@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {

	@Resource
	private ProductInfoMapper<ProductInfo, ProductInfoQuery> productInfoMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<ProductInfo> findListByParam(ProductInfoQuery query) {
		return this.productInfoMapper.selectList(query);
	}


	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(ProductInfoQuery query) {
		return this.productInfoMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<ProductInfo> findListByPage(ProductInfoQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<ProductInfo> list = this.findListByParam(query);
		PaginationResultVO<ProductInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(ProductInfo bean) {
		return this.productInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<ProductInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.productInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<ProductInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.productInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public ProductInfo getProductInfoById(Integer id) {
		return this.productInfoMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateProductInfoById(ProductInfo bean, Integer id) {
		return this.productInfoMapper.updateById(bean,id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteProductInfoById(Integer id) {
		return this.productInfoMapper.deleteById(id);
	}

	/**
	 * 根据Code查询
	 */
	public ProductInfo getProductInfoByCode(String code) {
		return this.productInfoMapper.selectByCode(code);
	}

	/**
	 * 根据Code更新
	 */
	public Integer updateProductInfoByCode(ProductInfo bean, String code) {
		return this.productInfoMapper.updateByCode(bean,code);
	}

	/**
	 * 根据Code删除
	 */
	public Integer deleteProductInfoByCode(String code) {
		return this.productInfoMapper.deleteByCode(code);
	}

	/**
	 * 根据SkuTypeAndColorType查询
	 */
	public ProductInfo getProductInfoBySkuTypeAndColorType(Integer skuType, Integer colorType) {
		return this.productInfoMapper.selectBySkuTypeAndColorType(skuType, colorType);
	}

	/**
	 * 根据SkuTypeAndColorType更新
	 */
	public Integer updateProductInfoBySkuTypeAndColorType(ProductInfo bean, Integer skuType, Integer colorType) {
		return this.productInfoMapper.updateBySkuTypeAndColorType(bean,skuType, colorType);
	}

	/**
	 * 根据SkuTypeAndColorType删除
	 */
	public Integer deleteProductInfoBySkuTypeAndColorType(Integer skuType, Integer colorType) {
		return this.productInfoMapper.deleteBySkuTypeAndColorType(skuType, colorType);
	}

}