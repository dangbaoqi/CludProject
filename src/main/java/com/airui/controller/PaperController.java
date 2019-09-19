package com.airui.controller;

import com.airui.pojo.Paper;
import com.airui.service.PaperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author dangbaoqi
 * @date 2019/9/19-10:11
 */
@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;
    private static final Logger log = LoggerFactory.getLogger(PaperController.class);

    @RequestMapping("/allPaper")
    public String list(Model model) {
        log.info("请求所有论文信息...");
        try{
            List<Paper> list = paperService.queryAllPaper();
            model.addAttribute("list", list);
        }catch(Exception e){
            log.error("列出所有的论文信息异常" ,e);
        }
        log.info("请求所有论文信息完成！");
        return "allPaper";
    }

    @RequestMapping("toAddPaper")
    public String toAddPaper() {
        log.info("请求添加论文页面...");
        return "addPaper";
    }

    @RequestMapping("/addPaper")
    public String addPaper(Paper paper) {
        log.info("开始新增论文...");
        try {
            paperService.addPaper(paper);
        }catch(Exception e){
            log.error("新增论文异常！" ,e);
        }
        log.info("新增论文成功！重定向到allPaper！！！");
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/del/{paperId}")
    public String deletePaper(@PathVariable("paperId") Long id) {
        log.info("删除"+id+"号论文信息");
        try {
            paperService.deletePaperById(id);
        }catch (Exception e){
            log.error("删除"+id+"号论文发生异常",e);
        }
        log.info("删除成功！重定向到allPaper！！！");
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("toUpdatePaper")
    public String toUpdatePaper(Model model, Long id) {
        log.info("请求更新页面...");
        try {
            log.info("请求更新页面时消息回填...");
            model.addAttribute("paper", paperService.queryById(id));
        }catch (Exception e){
            log.error("更新页面消息回填发生异常！",e);
        }
        return "updatePaper";
    }

    @RequestMapping("/updatePaper")
    public String updatePaper(Model model, Paper paper) {
        log.info("开始更新"+paper.getPaperId()+"号论文数据...");
        try{
            paperService.updatePaper(paper);
            paper = paperService.queryById(paper.getPaperId());
        }catch (Exception e){
            log.error("更新"+paper.getPaperId()+"号论文数据发生异常！！！",e);
        }
        model.addAttribute("paper", paper);
        log.info("更新论文成功，重定向到allPaper");
        return "redirect:/paper/allPaper";
    }
}
