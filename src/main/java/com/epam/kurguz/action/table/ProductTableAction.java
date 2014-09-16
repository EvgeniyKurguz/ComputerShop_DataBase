package com.epam.kurguz.action.table;

import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.ProductDao;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Product;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ProductTableAction implements Action {
    private ActionResult productTable = new ActionResult("productTable");

       public ActionResult execute(HttpServletRequest request) throws ActionException {

        H2DaoFactory factory = null;
        try {
            factory = new H2DaoFactory();
        } catch (DaoException e) {
            throw new ActionException(e);
        }
        DaoManager daoManager = null;
        try {
            daoManager = factory.getDaoManager();
        } catch (DaoException e) {
            throw new ActionException(e);
        }
        ProductDao productDao = null;
        try {
            productDao = daoManager.getProductDao();
        } catch (DaoException e) {
            throw new ActionException(e);
        }

        List<Product> productList = null;
        try {
            productList = productDao.getProductList();
        } catch (DaoException e) {
            throw new ActionException(e);
        }

        request.setAttribute("productTable", productList);
        return productTable;
    }

}


