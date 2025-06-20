package src.main.java.bkp.designpattern.behavioral.chainofresponsibility.problem.filters;

import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletResponse;
import src.main.java.bkp.designpattern.behavioral.chainofresponsibility.dto.HttpServletRequest;

public interface IFilter {

  void doFilter(HttpServletRequest request, HttpServletResponse response);

}
