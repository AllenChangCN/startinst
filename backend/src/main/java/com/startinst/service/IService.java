package com.startinst.service;

import com.startinst.dao.Item;
import com.startinst.dao.Page;
import com.startinst.dao.UserFavorPage;
import com.startinst.dao.Widget;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.PageMapper;
import com.startinst.dao.mapper.PageTagMapper;
import com.startinst.dao.mapper.WidgetMapper;
import com.startinst.model.HttpResponse;
import com.startinst.model.PageCreateModel;
import com.startinst.utils.HttpResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
public interface IService
{


}
