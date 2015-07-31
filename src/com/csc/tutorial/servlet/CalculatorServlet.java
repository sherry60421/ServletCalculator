package com.csc.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculatorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.append("123");
		writer.append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");

		double leftValue = Double.valueOf(request.getParameter("leftValue"));
		double rightValue = Double.valueOf(request.getParameter("rightValue"));
		String operator = request.getParameter("operator");
		boolean isOperated = false;
		double result = 0;

		switch (operator) {
		case "+":
			isOperated = true;
			result = leftValue + rightValue;
			break;
		case "-":
			isOperated = true;
			result = leftValue - rightValue;
			break;
		case "*":
			isOperated = true;
			result = leftValue * rightValue;
			break;
		case "/":
			isOperated = true;
			result = leftValue / rightValue;
			break;
		default:
			isOperated = false;
		}
		
		if(isOperated){
			response.getWriter().println(leftValue + operator + rightValue);
			response.getWriter().println("結果: " + result);
		}
		else{
			response.getWriter().println("無此運算子");
		}
		response.getWriter().println("<a href=\"./Calculator.html\">回上一頁</a>");
			

		// doGet(request, response);
	}

}
