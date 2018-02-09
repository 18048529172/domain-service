package com.liw.domain.web;

import com.liw.domain.dto.PronInfoQuery;
import com.liw.domain.service.ApiConfigService;
import com.liw.domain.utils.RestTemplates;
import com.liw.domain.web.helper.PageEntity;
import com.micro.web.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PronController {

    @Autowired
    private ApiConfigService apiConfigService;

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/pron/start/{startPage}/{endPage}/{thread}/{deepth}")
    public Response start(@PathVariable("thread") Integer thread,
                          @PathVariable("deepth") int deepth,
                          @PathVariable("startPage") int startPage,
                          @PathVariable("endPage") int endPage ){
        String url = this.getApiUrl("/pron/start/"+startPage+"/"+endPage+"/"+thread+"/"+deepth);
        return RestTemplates.post(restTemplate,url,new LinkedMultiValueMap<String,String>(),Response.class);
    }


    /**
     *  打开地址
     * @param id
     * @return
     */
    @GetMapping("/pron/address/{id}")
    public Response address(@PathVariable("id") String id){
        return RestTemplates.get(restTemplate,this.getApiUrl("/pron/address/"+id),Response.class);
    }

    /**
     *  下载地址
     * @param id
     * @return
     */
    @GetMapping("/pron/down/{id}")
    public Response getDownAddress(@PathVariable("id") String id){
        return RestTemplates.get(restTemplate,this.getApiUrl("/pron/down/"+id),Response.class);
    }

    /**
     *  分页查询
     * @param pronInfoQuery
     * @param page
     * @param pageSize
     * @return
     */
    @PostMapping("/pron/list")
    public PageEntity<?> list(PronInfoQuery pronInfoQuery,
                           @RequestParam("page") int page,
                           @RequestParam("rows") int pageSize){
        PageEntity pageEntity = new PageEntity();
        String url = this.getApiUrl("/pron/list");
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        param.add("keyword",pronInfoQuery.getKeyword());
        param.add("author",pronInfoQuery.getAuthor());
        param.add("page",String.valueOf(page));
        param.add("rows",String.valueOf(pageSize));
        Response response = RestTemplates.post(restTemplate,url,param,Response.class);
        if(response.isSuccess()){
            pageEntity.setTotal(Long.valueOf(response.getBody().get("totalRows").toString()));
            pageEntity.setRows((List) response.getBody().get("rows"));
        }
        return pageEntity;
    }


    private String getApiUrl(String apiPath) {
        return apiConfigService.getApiByPath(apiPath);
    }



}
