package com.msa.manager.common.interceptor;

import ch.qos.logback.classic.Logger;
import com.msa.manager.dto.UserDTO;
import com.msa.manager.service.MenuService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class CustomInterceptor implements HandlerInterceptor {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CustomInterceptor.class);

    @Autowired
    MenuService menuService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUri = request.getRequestURI();
        logger.debug("preHandle:::::"+requestUri);


        // 특정 URL 패턴을 확인 (예: /pc/)
//        if (requestUri.startsWith("/monitor/")) {
//            String[] excludedUrls = {"/login.do", "/register.do"}; // 세션 체크를 생략할 URL 패턴
//            for (String url : excludedUrls) {
//                if (requestUri.contains(url)) {
//                    // 예외 URL에 대한 처리를 생략
//                    return true;
//                }
//            }
//
//            // 세션을 체크하는 로직 추가
//            HttpSession session = request.getSession();
//            logger.debug("session:::::"+request.getSession().getAttribute("user"));
//            if (session == null || session.getAttribute("user") == null) {
//                // 세션이 없거나 로그인되지 않은 경우 처리 (예: 로그인 페이지로 리다이렉트)
//                response.sendRedirect("/monitor/login.do");
//                return false;
//            }
//        }




        return true;
        //return HandlerInterceptor.super.preHandle(request, response, handler);\
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

//        logger.debug("postHandle START");
//        HttpSession session =  request.getSession();
//        UserDTO user = (UserDTO) session.getAttribute("user");
//        logger.debug("user :::" + user);
//        if(null != user)
//        {
//            if(null != session.getAttribute("userAgent") && !"WEBVIEW".equals(session.getAttribute("userAgent")))
//            {
//                //request.setAttribute("menus", menuService.getMenus(user.getUserType()));
//            }
//        }
//        logger.debug("postHandle end");
//        request.setAttribute("menus", menuService.getMenus(user.getUserType()));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        logger.debug("afterCompletion:::::"+response.getStatus());


    }
}
