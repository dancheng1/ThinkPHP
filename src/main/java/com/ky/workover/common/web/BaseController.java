package com.ky.workover.common.web;

import com.ky.workover.common.utils.DateUtils;
import com.ky.workover.common.persistence.Page;
import com.ky.workover.common.utils.StringUtils;
import com.ky.workover.common.utils.security.Encodes;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditorSupport;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;


/**
 * 基础控制器
 * 其他控制器继承此控制器获得日期字段类型转换和防止XSS攻击的功能
 *
 * @author ty
 * @description
 * @date 2014年3月19日
 */
public class BaseController {
//    @Autowired
//    private SysConfigService sysConfigService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }

            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });

        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });

        // Timestamp 类型转换
        binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Date date = DateUtils.parseDate(text);
                setValue(date == null ? null : new Timestamp(date.getTime()));
            }
        });
    }

    /**
     * 获取page对象
     *
     * @param request
     * @return page对象
     */
    public <T> Page<T> getPage(HttpServletRequest request) {
        int pageNo = 1;    //当前页码
        int pageSize = 20;    //每页行数
        String orderBy = "id";    //排序字段
        String order = "asc";    //排序顺序
        if (StringUtils.isNotEmpty(request.getParameter("page")))
            pageNo = Integer.valueOf(request.getParameter("page"));
        if (StringUtils.isNotEmpty(request.getParameter("rows")))
            pageSize = Integer.valueOf(request.getParameter("rows"));
        if (StringUtils.isNotEmpty(request.getParameter("sort")))
            orderBy = request.getParameter("sort").toString();
        if (StringUtils.isNotEmpty(request.getParameter("order")))
            order = request.getParameter("order").toString();
        return new Page<T>(pageNo, pageSize, orderBy, order);
    }

    /**
     * 获取easyui分页数据
     *
     * @param page
     * @return map对象
     */
    public <T> Map<String, Object> getEasyUIData(Page<T> page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", page.getResult());
        map.put("total", page.getTotalCount());
        return map;
    }

    /**
     * 用来获取当前登录用户
     *
     * @return 当前登录用户
     */
    /*public User getCurUser() {

        //Object = null;
        User curUser = (User) SecurityUtils.getSubject().getPrincipal();
        return curUser;
    }*/

    /**
     * 将request转成map参数集
     * 例如：request中的参数t1=1&t2=3
     * 形成的map结构：
     * key=t1;value[0]=1;key=t2,value[0]=3
     *
     * @param request
     * @return
     */
    public Map<String, String> getParamMap(HttpServletRequest request) {
        //将request参数转成map
        Map<String, String[]> map = request.getParameterMap();
        Set<Map.Entry<String, String[]>> set = map.entrySet();
        Iterator<Map.Entry<String, String[]>> it = set.iterator();
        Map<String, String> res = new HashMap<>();
        //迭代
        while (it.hasNext()) {
            Map.Entry<String, String[]> entry = it.next();
            for (String i : entry.getValue()) {
                //判断条件内容是否为空
                if (StringUtils.isNotBlank(i)) {
                    //entry.getValue()[0] 忽略重复传参只取第一个
                    res.put(entry.getKey(), entry.getValue()[0]);
                }
            }
        }
        return res;
    }

    /**
     * @param entity
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @description 实体对象转map
     * @other [其他说明]  通过反射机制进行对象互转
     * 用于条件查询
     */

    public Map<String, String> getParamMap(Object entity) {
        if (entity == null) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(entity.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(entity);
                    if (value != null)
                        map.put(key, value.toString());
                }

            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }

    /**
     * 获取RowBounds对象
     *
     * @param request
     * @return RowBounds对象
     */

    public RowBounds getMybatisPage(HttpServletRequest request) {
        int pageNo = 1;    //当前页码
        int pageSize = 20;    //每页行数
        int start = 0;//查数据库开始位置
        int end = 0;//查数据库结束位置
        if (StringUtils.isNotEmpty(request.getParameter("page")))
            pageNo = Integer.valueOf(request.getParameter("page"));
        if (StringUtils.isNotEmpty(request.getParameter("rows")))
            pageSize = Integer.valueOf(request.getParameter("rows"));
        start = (pageNo - 1) * pageSize;
        end = pageNo * pageSize;
        return new RowBounds(start, end);
    }

    public RowBounds getMybatisPage(int pageNo,int pageSize) {
        int start = 0;//查数据库开始位置
        start = (pageNo - 1) * pageSize;
        /* int end = 0;//查数据库结束位置*/
        /* end = pageNo * pageSize;*/
        return new RowBounds(start, pageSize);
    }
    /**
     * 获取时间不允许的可能原因（单次）
     *
     * @param
     * @return RowBounds对象
     */
    /*public String getPermitTime() {
        //查出定时任务提前多少分钟进行新增
         int createTime=Integer.valueOf(this.sysConfigService.findSysConfigByItemKey(SysConfigConstant.LINEPLAN_THREE).getItemValue());
        //查出最大允许的时间
         int days=Integer.valueOf(this.sysConfigService.findSysConfigByItemKey(SysConfigConstant.LINEPLAN_ONE).getItemValue());
        return "计划开始时间必须大于当前时间"+createTime+"分钟或者计划时间必须是"+days+"天以内";
    }*/
    /**
     * 获取时间不允许的可能原因(周期)
     *
     * @param
     * @return RowBounds对象
     */
    /*public String getPermitTimeZQ() {
        //查出定时任务提前多少分钟进行新增
         int createTime=Integer.valueOf(this.sysConfigService.findSysConfigByItemKey(SysConfigConstant.LINEPLAN_THREE).getItemValue());
        //查出最大允许的时间
         int days=Integer.valueOf(this.sysConfigService.findSysConfigByItemKey(SysConfigConstant.LINEPLAN_FOUR).getItemValue());
        return "计划开始时间必须大于当前时间"+createTime+"分钟或者计划时间必须是"+days+"天以内";
    }*/

    /**
     * 解析tokenId,取出ID中存放的属性
     * @param tokenId
     * @return
     */
    public Map<String, String> tokenIdParam(String tokenId){
        Map<String, String> map = new HashMap<>();
        String deTokenId = null;
        try {
            deTokenId = new String(Encodes.decodeBase64(tokenId),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String[] str = deTokenId.split("_");
        map.put("userId", str[0].equals("null")?"": str[0]);
        map.put("enterpriseId", str[1].equals("null")?"": str[1]);
        map.put("orgId", str[2].equals("null")?"": str[2]);
        map.put("nowDate", str[3].equals("null")?"": str[3]);
        return map;
    }

}
