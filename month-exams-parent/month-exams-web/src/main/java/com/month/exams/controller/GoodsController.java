package com.month.exams.controller;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import com.alibaba.dubbo.config.annotation.Reference;
import com.month.exams.pojo.TGoods;
import com.month.exams.service.GoodsService;

import entity.Result;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@RequestMapping("/goods")
@RestController
public class GoodsController {

	@Reference
	private GoodsService goodsService;
	
	@Value("${pagedir}")
	private String pagedir;
	
	@Autowired
	private FreeMarkerConfig freemarkerConfig;
	
	@RequestMapping("/getList")
	public List<TGoods> getList(){
		return goodsService.getList();
	}
	
	@RequestMapping("/save")
	public Result save(@RequestBody TGoods tGoods){
		try {
			goodsService.save(tGoods);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	@RequestMapping("/up")
	public Map up(int id){
		goodsService.uo(id);
		
		//创建ftl连接
		Configuration configuration = freemarkerConfig.getConfiguration();
		//创建模板
		try {
			Template template = configuration.getTemplate("item.ftl");
			Map map = new HashMap<>();
			TGoods tGoods = goodsService.findId(id);
			map.put("tGoods", tGoods);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pagedir+id+".html"), "utf-8"));
			template.process(map, writer);
			writer.close();
			return map;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/dwon")
	public void dwon(int id){
		goodsService.dwon(id);
	}
}
