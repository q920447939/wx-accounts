package com.withmes.wxaccounts.config.base.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.withmes.plan.config.base.dal.BaseMapper;
import com.withmes.plan.config.base.exception.ValidateErrorException;
import com.withmes.plan.config.base.utils.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * ClassName: BaseServiceImpl 
 * @Description: 业务实现层基类
 * @author liming
 * @param <T>
 * @date 2018年3月20日
 *
 * =================================================================================================
 *     Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 *		
 */
public abstract class BaseServiceImpl<T> {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired(required = false)
	private Validator validator;

	private BaseMapper<T> mapper;

	protected Class<T> entityClass;

	public BaseServiceImpl() {
		entityClass = Reflections.getClassGenricType(getClass());
	}

	@PostConstruct
	private void initConfig() {
		this.mapper = this.getBaseMapper();
	}

	/**
	 * @Description: 获取实体对象
	 * @return   
	 * @author liming
	 * @date 2016年9月3日
	 */
	public abstract BaseMapper<T> getBaseMapper();

	/**
	 * @Description: 校验器
	 * @param entity
	 * @throws Exception   
	 * @author liming
	 * @date 2018年3月20日
	 */
	public void validate(T entity) {
		if (null == validator) {
			return;
		}
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
		if (constraintViolations.size() > 0) {
			StringBuilder validateError = new StringBuilder();
			for (ConstraintViolation<T> constraintViolation : constraintViolations) {
				validateError.append("属性：").append(constraintViolation.getPropertyPath()).append("报错！")
						.append(constraintViolation.getMessage()).append(";");
			}
			throw new ValidateErrorException(validateError.toString());
		}
	}

	public int add(T entity) {
		validate(entity);
		return mapper.insert(entity);
	}

	public int update(T entity) {
		return mapper.updateById(entity);
	}
	
	public int updateAllColumn(T entity) {
	    return mapper.updateAllColumnById(entity);
	}

	public int delete(Serializable id) {
		return mapper.deleteById(id);
	}

	public T findById(Serializable id) {
		return mapper.selectById(id);
	}

	public List<T> findBatchIds(Collection<? extends Serializable> idList) {
		return mapper.selectBatchIds(idList);
	}

	public List<T> findByParams(Wrapper<T> wrapper) {
		return mapper.selectList(wrapper);
	}

	public Integer findCount(Wrapper<T> wrapper) {
		return mapper.selectCount(wrapper);
	}

}
