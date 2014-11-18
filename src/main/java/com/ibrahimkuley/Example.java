package com.ibrahimkuley;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class Example {

    @RequestMapping(method = RequestMethod.GET)
    public String metot1(ModelMap model) {
        model.addAttribute("message", "Get metodu");
        return "page";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String metot2(ModelMap model) {
        model.addAttribute("message", "Post metodu");
        return "page";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String metot3(ModelMap model) {
        model.addAttribute("message", "DELETE metodu");
        return "page";
    }

    @RequestMapping("/metotURI")
    public String metot4(ModelMap modelMap) {
        modelMap.addAttribute("message", "URL = http://localhost:8080/metotURI");
        return "page";
    }

    @RequestMapping(value = "/methodURI2")
    @ResponseBody
    public String metot5() {
        return "responseBody";
    }

//    @RequestMapping(value = "/methodURI2") // 2. Yöntem olarak bu şekildede yazılabilir
//    public @ResponseBody String responseBdoy() {
//        return "responseBody";
//    }
//

    //@RequestMapping with Multiple URI: Çoklu URI

    @RequestMapping(value = {"/multiMetot1", "/multiMetot2", "/multiMetot3"})
    //http://localhost:8080/multiMetot1
    //http://localhost:8080/multiMetot2
    //http://localhost:8080/multiMetot3
    @ResponseBody
    public String metot6() {
        return "Çoklu URI";
    }

    @RequestMapping(value = "/multiGETandPOST", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String metot7() {
        return "Çoklu mehod GET POST";
    }

    //@RequestMapping with Headers:


    @RequestMapping(value = "/theheadMetot", headers = "name=Kuley", method = RequestMethod.GET)
    @ResponseBody
    public String metot8() {
        return "header methodu";
    }

    @RequestMapping(value = "/theheadMetotMulti", headers = {"userName=hikuley", "password=hikhs@25"}, method = RequestMethod.GET)
    @ResponseBody
    public String metot9() {
        return "header methodu";
    }


    //@RequestMapping with Produces and Consumes:

    @RequestMapping(value = "/producesType", produces = {"application/json", "text/html"}, consumes = "text/html")
    @ResponseBody
    public String metot10() {
        return "deneme";
    }

    //@RequestMapping with @PathVariable:


    @RequestMapping(value = "/URIparamerter/{id}")
    @ResponseBody
    public String metot11(@PathVariable("id") int id) {
        return "Kullanici Id : " + id;
    }

    @RequestMapping(value = "/multiURIparamerter/{id}/{kullaniciadi}")
    @ResponseBody
    public String metot12(@PathVariable("id") int id, @PathVariable String kullaniciadi) {
        return "Kullanici Id : " + id + "\r" +
                "Kullanici Adi : " + kullaniciadi;

    }

    //@RequestMapping with @RequestParam for URL parameters

    @RequestMapping(value = "/urlParamerters")
    @ResponseBody
    public String metot13(@RequestParam("id") int id) {
        return "Kullanici Id :" + id;
    }

    @RequestMapping(value = "/paramerters")
    @ResponseBody
    public String metot14(
            @RequestParam("id") int id,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        return "Id :" + id + " \r" +
                "User Name" + username + " \r" +
                "Password" + password + " \r";
    }

    // URI parametre http://localhost:8080/paramerters2?id=32&username=fwefew&password=2323ffsdfs şeklindedir
    @RequestMapping(value = "/paramerters2", method = RequestMethod.POST)
    @ResponseBody
    public String metot15(
            @RequestParam("id") int id,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        return "Id :" + id + " \r" +
                "User Name" + username + " \r" +
                "Password" + password + " \r";
    }

    // Controller default metot
    @RequestMapping()
    @ResponseBody
    public String index() {
        return "// Controller default metot";
    }

    @RequestMapping("*")
    public String error404(ModelMap modelMap) {
        modelMap.addAttribute("message", "Oppss 404");
        return "page";
    }


}