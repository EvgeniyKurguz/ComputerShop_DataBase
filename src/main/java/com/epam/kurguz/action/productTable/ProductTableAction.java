package com.epam.kurguz.action.productTable;

import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.dao.DaoFactory;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.ProductDao;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Product;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ProductTableAction implements Action {
    public static final int DEFAULT_PAGE_NUMBER = 0;
    public static final int DEFAULT_ROWS_COUNT = 10;
    private ActionResult productTable = new ActionResult("productTable");

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        int pageNumber = DEFAULT_PAGE_NUMBER;
        int rowsCount = DEFAULT_ROWS_COUNT;
        String pageName = request.getParameter("product-table");
        String pageString = request.getParameter("page");
        String rowsString = request.getParameter("rows");

        if (pageString != null) pageNumber = Integer.valueOf(pageString);
        if (rowsString != null) rowsCount = Integer.valueOf(rowsString);

        DaoManager daoManager = null;
        try {
            DaoFactory factory = H2DaoFactory.getInstance();
            daoManager = factory.getDaoManager();
            ProductDao productDao = daoManager.getProductDao();
            List<Product> productList = productDao.findRange(pageNumber, rowsCount);
            List<Product> productLengthList = productDao.getProductList();

            int tableLength = productLengthList.size();
            List<Integer> paginationList = new ArrayList<>();

            for (int i = 0; i < tableLength / rowsCount + 1; i++) {
                paginationList.add(i + 1);
            }

            if (pageNumber == tableLength / rowsCount + 1) {
                request.setAttribute("nextDisabled", "disabled");
            }

            if (pageNumber == 1) {
                request.setAttribute("backDisabled", "disabled");
            }

            request.setAttribute("paginationList", paginationList);
            request.setAttribute("productList", productList);
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("rowsCount", rowsCount);
            request.setAttribute("pageName", pageName);
            daoManager.commit();
        } catch (DaoException e) {
            try {
                daoManager.rollBack();
                request.setAttribute("Product Action Error", "Show Product error");
            } catch (DaoException exception) {
                throw new ActionException(exception);
            }
        } finally {
            try {
                daoManager.close();
            } catch (DaoException e) {
                throw new ActionException(e);
            }
        }
        return productTable;
    }
}





