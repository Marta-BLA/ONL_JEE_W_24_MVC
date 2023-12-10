package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @RequestMapping("/setcookie/{value1}/{value2}")
    @ResponseBody
    public String setCookie(@PathVariable("value1") String value1, @PathVariable("value2") String value2, HttpServletResponse httpServletResponse) {
        Cookie cookie1 = new Cookie("cookie1", value1);
        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie1.setPath("/");
        cookie2.setPath("/");
        httpServletResponse.addCookie(cookie1);
        httpServletResponse.addCookie(cookie2);
        return "cookies created";
    }

    @RequestMapping("/getcookies1")
    @ResponseBody
    public String getCookiesFirstMethod(HttpServletRequest httpServletRequest) {
        Cookie cookie1 = WebUtils.getCookie(httpServletRequest, "cookie1");
        return cookie1.getName() + " " + cookie1.getValue();
    }

    @RequestMapping("/getcookies2")
    @ResponseBody
    public String getCookiesSecondMethod(@CookieValue("cookie2") String cookie2) {
        return "cookie2 " + cookie2;
    }


}
