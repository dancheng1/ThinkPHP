package com.ky.workover.boreturn.service;

import com.alibaba.fastjson.JSON;
import com.ky.workover.boreturn.mapper.BoreturnDetailMapper;
import com.ky.workover.boreturn.mapper.BoreturnMapper;
import com.ky.workover.boreturn.model.BRList;
import com.ky.workover.boreturn.model.Boreturn;
import com.ky.workover.boreturn.model.BoreturnCustom;
import com.ky.workover.boreturn.model.BoreturnDetail;
import com.ky.workover.common.json.JsonUtils;
import com.ky.workover.corp.mapper.CorpSummaryDetailMapper;
import com.ky.workover.corp.model.CorpSummaryDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/2/21.
 */
@Service
public class BoreturnService {

    @Autowired
    private BoreturnMapper boreturnMapper;

    @Autowired
    private BoreturnDetailMapper boreturnDetailMapper;

    @Autowired
    private CorpSummaryDetailMapper corpSummaryDetailMapper;

    /**
     * 查询全部借还单子
     * @return
     */
    public Map<String, Object> findAll(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<Boreturn> list = boreturnMapper.findAll();
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(list, JsonUtils.isNullFilter)));   //以list的形式进行行显示
            map.put("total", list.size());  //对list的数量进行汇总
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 根据单号查询
     * @param s
     * @return
     */
    public List<Boreturn> findByOrder(String s){
        List<Boreturn> list = new ArrayList<>();
        try{
            list = boreturnMapper.findByOrder(s);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 查询借还单子By_id
     * @param boreturn1
     * @return
     */
    public Map<String, Object> findById(Boreturn boreturn1){
        Map<String, Object> map = new HashMap<>();
        try{
            Boreturn boreturn = boreturnMapper.selectByPrimaryKey(boreturn1.getId());
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(boreturn,JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 根据物品号模糊查询所有单子信息
     * @param boreturnDetail12345
     * @return
     */
    public Map<String, Object> findListByCorpId(BoreturnDetail boreturnDetail12345){
        Map<String, Object> map = new HashMap<>();
        try{
            List<BoreturnDetail> listForString1 = boreturnDetailMapper.findListByCorpId(boreturnDetail12345.getCorpId());
            List<String> listForString = new ArrayList<>();
            for(BoreturnDetail boreturnDetail : listForString1){
                String str = boreturnDetail.getBorrowId();
                int ok = 1;
                for(String s : listForString){
                    if(str.equals(s)){
                        ok = 0;
                        break;
                    }
                }
                if(ok == 1){
                    listForString.add(str);
                }
            }

            List<BRList> list = new ArrayList<>();
            for(String str : listForString){
                BRList brList = new BRList();
                Boreturn boreturn = boreturnMapper.findByOrderId(str);
                brList.setBoreturn(boreturn);
                List<CorpSummaryDetail> list2 = new ArrayList<>();
                List<BoreturnDetail> list1 = boreturnDetailMapper.findListByBorrowId(str);
                for(BoreturnDetail boreturnDetail : list1){
                    list2.add(corpSummaryDetailMapper.selectByPrimaryKey(boreturnDetail.getCorpId()));
                }
                brList.setList(list2);
                list.add(brList);
            }
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(list, JsonUtils.isNullFilter)));   //以list的形式进行行显示
            map.put("total", list.size());  //对list的数量进行汇总
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 生成借还生产单号
     * @return
     */
    public String JOrder(String s1){
        int sum = 0;
        String str;
        String  str1;
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        Date date = new Date();
        String s = format.format(date);
        String s2 = s1 + s;
        try{
            List<Boreturn> list = boreturnMapper.findByOrder(s2);
            if(list.size() != 0){
                for(Boreturn boreturn : list){
                    int temp;
                    String s4 = boreturn.getOrderId();
                    String s3 = s4.substring(7, s4.length());
                    if(s3 != null && s3.isEmpty() == false){
                        temp = Integer.parseInt(s3);
                    } else {
                        temp = 0;
                    }
                    if(temp > sum){
                        sum = temp;
                    }
                }
            } else {
                sum = 0;
            }
            sum++;
            if(sum > 10){
                if(sum >= 100){
                    if(sum >= 1000){
                        str = "";
                    } else {
                        str = "0";
                    }
                } else {
                    str = "00";
                }
            } else {
                str = "000";
            }
            str = s2 + str + sum;
            return str;
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 新增借还单子
     * @param boreturnCustom
     * @return
     */
    public Map<String, Object> insertBoreturn(BoreturnCustom boreturnCustom){
        Map<String, Object> map = new HashMap<>();
        String s1 = "J";
        try{
            String dh = JOrder(s1);

            List<CorpSummaryDetail> list = boreturnCustom.getList();

            Boreturn boreturn = new Boreturn();
            boreturn.setOrderId(dh);
            boreturn.setSum(list.size());
            boreturn.setUserId(boreturnCustom.getUserId1());
            boreturn.setSpId(boreturnCustom.getUserId2());
            boreturn.setLqTime(boreturnCustom.getLqTime());
            boreturn.setGhTime(boreturnCustom.getGhTime());
            boreturn.setType(1);

            int ok = 1;
            for(CorpSummaryDetail corpSummaryDetail : list){
                BoreturnDetail boreturnDetail = new BoreturnDetail();
                boreturnDetail.setBorrowId(dh);
                boreturnDetail.setCorpId(corpSummaryDetail.getAssetsno());
                boreturnDetail.setType(1);
                ok = boreturnDetailMapper.insert(boreturnDetail);
                if(ok == 0){
                    break;
                } else {
                    corpSummaryDetailMapper.updateUsesTate(corpSummaryDetail.getAssetsno());
                }
            }
            if(ok == 1){
                int count = boreturnMapper.insert(boreturn);
                if(count != 0){
                    map.put("isSuccess", "1");
                    map.put("msg", "保存成功！");
                } else {
                    map.put("isSuccess", "0");
                    map.put("msg", "保存失败！");
                }
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "保存失败！");
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "保存失败！");
        }
        return map;
    }

    /**
     * 新增还单子
     * @param boreturnCustom
     * @return
     */
    public Map<String, Object> insertBoreturn1(BoreturnCustom boreturnCustom){
        Map<String, Object> map = new HashMap<>();
        String s1 = "H";
        try{
            String dh = JOrder(s1);

            List<CorpSummaryDetail> list = boreturnCustom.getList();

            Boreturn boreturn = new Boreturn();
            boreturn.setOrderId(dh);
            boreturn.setSum(list.size());
            boreturn.setUserId(boreturnCustom.getUserId1());
            boreturn.setSpId(boreturnCustom.getUserId2());
            boreturn.setLqTime(boreturnCustom.getLqTime());
            boreturn.setGhTime(boreturnCustom.getGhTime());
            boreturn.setType(0);

            int ok = 1;
            for(CorpSummaryDetail corpSummaryDetail : list){
                BoreturnDetail boreturnDetail = new BoreturnDetail();
                boreturnDetail.setBorrowId(dh);
                boreturnDetail.setCorpId(corpSummaryDetail.getAssetsno());
                boreturnDetail.setType(0);
                ok = boreturnDetailMapper.insert(boreturnDetail);
                if(ok == 0){
                    break;
                } else {
                    corpSummaryDetailMapper.updateUsesTate1(corpSummaryDetail.getAssetsno());
                }
            }
            if(ok == 1){
                int count = boreturnMapper.insert(boreturn);
                if(count != 0){
                    map.put("isSuccess", "1");
                    map.put("msg", "保存成功！");
                } else {
                    map.put("isSuccess", "0");
                    map.put("msg", "保存失败！");
                }
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "保存失败！");
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "保存失败！");
        }
        return map;
    }

    /**
     * 删除借还单子
     * @param boreturn
     * @return
     */
    public Map<String, Object> deleteBoreturn(Boreturn boreturn){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = boreturnMapper.deleteByPrimaryKey(boreturn.getId());
            if (count != 0) {
                map.put("isSuccess", "1");
                map.put("msg", "删除成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "删除失败！");
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "删除失败！");
        }
        return map;
    }

    /**
     * 回显借还单子
     * @param boreturn
     * @return
     */
    public Map<String, Object> editBoreturn(Boreturn boreturn){
        Map<String, Object> map = new HashMap<>();
        try{
            Boreturn boreturn1 = boreturnMapper.selectByPrimaryKey(boreturn.getId());
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(boreturn1, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    public Map<String, Object> updateBoreturn(Boreturn boreturn){
        Map<String, Object> map = new HashMap<>();
        try{
            int count = boreturnMapper.updateByPrimaryKey(boreturn);
            map.put("isSuccess", "1");
            map.put("msg", "更新成功！");
        } catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "更新失败！");
        }
        return map;
    }
}
