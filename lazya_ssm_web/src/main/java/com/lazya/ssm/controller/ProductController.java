package com.lazya.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.lazya.ssm.domain.Product;
import com.lazya.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Title: ProductController
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 27 14 27
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }

    //查询所有的产品
    //@RolesAllowed表示访问对应方法时所应该具有的角色
    @RolesAllowed({"ADMIN","USER"})//只有ADMIN才能访问前面的ROLE_可以省略
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required=true,defaultValue="1") Integer page,
                                @RequestParam(name="size",required=true,defaultValue="4")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll(page,size);
        PageInfo pageProduct = new PageInfo(ps);
        mv.addObject("pageProduct",pageProduct);
        mv.setViewName("product-list");
        return mv;
    }


}
