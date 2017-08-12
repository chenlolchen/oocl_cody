package org.seckill.web;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.List;

/**
 * Created by chen on 2016/5/31.
 */

@Controller
@RequestMapping("/seckill") //uri:/模块/资源/｛id｝/细分   seckill/list
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Autowired
    ServletContext context;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        return "list"; //  /WEB-INF/jsp/"list".jsp
    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "redirect:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
                                                   @PathVariable("md5") String md5,
                                                   @CookieValue(value = "killPhone", required = false) Long phone) {
        //可以采用springmvc的 valid
        if (phone == null) {
            return new SeckillResult<SeckillExecution>(false, "未注册");
        }
        SeckillResult<SeckillExecution> result;
        try {
            SeckillExecution execution = seckillService.executeSeckill(seckillId, phone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (RepeatKillException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (SeckillCloseException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(true, execution);
        }
    }

    @RequestMapping(value = "/time/now",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Long> time(){
        Date now = new Date();
        return new SeckillResult(true,now.getTime());
    }

    /*@RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public String addUser1(String userName,String password) {
        System.out.println("userName is:"+userName);
        System.out.println("password is:"+password);
        return "redirect:/";
    }*/

    /*@RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public String addUser2(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println("userName is S:"+userName);
        System.out.println("password is S:"+password);
        return "/";
    }*/

    @RequestMapping(value = "/{page}/pagelist", method = RequestMethod.GET)
    public String pageList(@PathVariable("page") int page, Model model) {
        int pageSize = 100;
        System.out.println("没有使用静态化");
        int count = seckillService.getListCount();
        int totalPages = count / pageSize + ((count % pageSize) > 0 ? 1 : 0);
        model.addAttribute("totalPages",totalPages);
        if(page <= 0){
            page = 1;
        }else if(page > totalPages) {
            page = totalPages;
        }
        model.addAttribute("pageNumber",page);
        List<Seckill> pagelist = seckillService.getSeckillListByPage(page, pageSize);
        model.addAttribute("pagelist", pagelist);
        return "/list";
    }

//    @RequestMapping(value = "/{page}/pagelist", method = RequestMethod.GET)
//    public void pageList(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String fileName = "good_" + page + ".html";
//        String filePath = context.getRealPath("/") + fileName;
//        File chapterFile = new File(filePath);
//        if (chapterFile.exists()) {
//            System.out.println("html页面存在，直接跳转");
//            response.sendRedirect("/" +fileName);
//            return ;
//        }
//
//        int pageSize = 100;
//
//        int count = seckillService.getListCount();
//        int totalPages = count / pageSize + ((count % pageSize) > 0 ? 1 : 0);
//        request.setAttribute("totalPages",totalPages);
//        if(page <= 0){
//            page = 1;
//        }else if(page > totalPages) {
//            page = totalPages;
//        }
//        request.setAttribute("pageNumber",page);
//        List<Seckill> pagelist = seckillService.getSeckillListByPage(page, pageSize);
//
//        request.setAttribute("pagelist", pagelist);
//        new CreateStaticHTMLPage().create(request, response, context, fileName, filePath,
//                "/WEB-INF/jsp/list.jsp");
//
//    }

}
