package com.develhope.SpringAdvanced0102.interceptors;

import com.develhope.SpringAdvanced0102.entities.MonthEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.header;

@Component
public class APIMonthInterceptor implements HandlerInterceptor {


    private ArrayList<MonthEntity> generateMonthList() {
        ArrayList<MonthEntity> monthList = new ArrayList<>();
        monthList.add(new MonthEntity(Long.valueOf(1), 1, "Gennaio", "January", "Januar"));
        monthList.add(new MonthEntity(Long.valueOf(2), 2, "Febbraio", "February", "Februar"));
        monthList.add(new MonthEntity(Long.valueOf(3), 3, "Marzo", "March", "März"));
        monthList.add(new MonthEntity(Long.valueOf(4), 4, "Aprile", "April", "April"));
        monthList.add(new MonthEntity(Long.valueOf(5), 5, "Maggio", "May", "Mai"));
        monthList.add(new MonthEntity(Long.valueOf(6), 6, "Giugno", "June", "Juni"));

        return monthList;
    }

    private MonthEntity generateNopeMonth(int monthNumber) {
        MonthEntity nopeMonth = new MonthEntity();
        nopeMonth.setMonthNumber(monthNumber);
        nopeMonth.setEnglishName("Nope");
        nopeMonth.setItalianName("Nope");
        nopeMonth.setGermanName("Nope");
        return nopeMonth;

    }

    private MonthEntity monthCheck(int monthNumber) {
        for (int i = 0; i < generateMonthList().size(); i++) {
            if (generateMonthList().get(i).getMonthNumber() == monthNumber) {
                return generateMonthList().get(i);
            }
        }
        return generateNopeMonth(monthNumber);
    }


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberHeader = request.getHeader("monthNumber");

        if(monthNumberHeader == null || monthNumberHeader.isEmpty()) {
            response.sendError(400, "You should have selected a month number.");
            return false;
        }

        int monthNumber = Integer.parseInt(monthNumberHeader);

        request.setAttribute("monthNumber", monthCheck(monthNumber));
        response.setStatus(200);

        return true;
    }
/*
  returns an HTTP OK status
    test the endpoint call using Postman and considering at least 4 cases:
    the header monthNumber is absent
    the header monthNumber is empty
    the header monthNumber has a value that is in the list
    the header monthNumber has a value that is not in the list*/


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
