package com.epam.kurguz.action.productTable;

import com.epam.kurguz.action.Action;
import com.epam.kurguz.action.ActionResult;
import com.epam.kurguz.dao.DaoManager;
import com.epam.kurguz.dao.ProductDao;
import com.epam.kurguz.dao.h2.H2DaoFactory;
import com.epam.kurguz.entity.Product;
import com.epam.kurguz.exception.ActionException;
import com.epam.kurguz.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreatProductAction implements Action {
    private static final String NAME = "name";
    private static final String MAKER = "maker";
    private static final String MODEL = "model";


    ActionResult productTable = new ActionResult("productTable", true);

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        String name = request.getParameter(NAME);
        String maker = request.getParameter(MAKER);
        String model = request.getParameter(MODEL);

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

        Product product = new Product();
        product.setName(name);
        product.setMaker(maker);
        product.setModel(model);
        productDao.insert(product);


        HttpSession session = request.getSession();
        session.setAttribute("user", product);
        return productTable;
    }
}
