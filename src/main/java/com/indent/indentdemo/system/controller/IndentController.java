package com.indent.indentdemo.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.indent.indentdemo.system.entity.Indent;
import com.indent.indentdemo.system.service.IIndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dlx
 * @since 2023-10-23
 */
@RestController
@RequestMapping("/system/indent")
public class IndentController {
    @Autowired
    private IIndentService indentService;

    @GetMapping("/all")
    public List<Indent> getAllIndent(){

        List<Indent> list = indentService.list();
        return list;
    }
    @GetMapping("/list")
    public Map<String,Object> getIndentList(@RequestParam(value = "open_id",required = false)String open_id,
                                            @RequestParam(value = "nick_name",required = false)String nick_name,
                                            @RequestParam(value = "indent_title",required = false)String indent_title,
                                            @RequestParam(value = "indent_no",required = false)String indent_no,
                                            @RequestParam(value = "product_type",required = false)String product_type,
                                            @RequestParam(value = "pageNo")long pageNo,
                                            @RequestParam(value = "pageSize")long pageSize) {
        LambdaQueryWrapper<Indent> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(open_id), Indent::getOpenId, open_id);
        wrapper.eq(StringUtils.hasLength(nick_name), Indent::getNickName, nick_name);
        wrapper.eq(StringUtils.hasLength(indent_title), Indent::getIndentTitle, indent_title);
        wrapper.eq(StringUtils.hasLength(indent_no), Indent::getIndentNo, indent_no);
        wrapper.eq(StringUtils.hasLength(product_type), Indent::getProductType, product_type);
        wrapper.orderByDesc(Indent::getIndentId);
        Page<Indent> Page = new Page<>(pageNo,pageSize);
        indentService.page(Page,wrapper);
        Map<String,Object> data =new HashMap<>();
        data.put("total",Page.getTotal());
        data.put("rows",Page.getRecords());
        System.out.println(data);
        return data;
    }
    @PostMapping
    public String addIndent(@RequestBody Indent indent){
        indentService.save(indent);
        String result = "新增订单成功";
        return result;
    }
    //修改订单
    @PutMapping
    public String updateIndent(@RequestBody Indent indent){
        indentService.updateById(indent);
        String result = "修改订单成功";
        return result;
    }
    //按ID查找订单
    //用于在修改订单的界面展示原订单信息
    @GetMapping("/{id}")
    public Indent getIndentById(@PathVariable("id")Integer id){
        Indent indent  = indentService.getById(id);
        return indent;
    }
    //删除订单
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id")Integer id){
        indentService.removeById(id);
        return "订单删除成功";

    }

}
