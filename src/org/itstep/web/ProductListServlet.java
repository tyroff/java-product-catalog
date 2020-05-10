package org.itstep.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.Factory;
import org.itstep.domain.Product;
import org.itstep.logic.LogicException;
import org.itstep.logic.ProductService;

public class ProductListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(Factory factory = new Factory()) {
			ProductService service = factory.getProductService();
			List<Product> products = service.findAll();
			req.setAttribute("products", products);
			req.getRequestDispatcher("/WEB-INF/jsp/product/list.jsp").forward(req, resp);
		} catch(LogicException e) {
			throw new ServletException(e);
		}
	}
}
