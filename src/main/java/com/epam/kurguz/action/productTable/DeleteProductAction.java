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

public class DeleteProductAction implements Action {

    private ActionResult deleteProduct = new ActionResult("productTable", true);

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException {
        String delete = request.getParameter("delete");
        DaoManager daoManager = null;
        try {
            DaoFactory factory = H2DaoFactory.getInstance();
            daoManager = factory.getDaoManager();
            ProductDao productDao = daoManager.getProductDao();
            if (delete != null) {
                int id = Integer.parseInt(delete);
                Product findProduct = productDao.findById(id);
                productDao.deleteById(findProduct);
            }
            daoManager.commit();
        } catch (DaoException e){
            try {
                daoManager.rollBack();
                request.setAttribute("DeleteProductError", "Delete Product error");
            } catch (DaoException exception) {
                throw new ActionException(exception);
            }
        }finally {
            try {
                daoManager.close();
            } catch (DaoException e) {
                throw new ActionException(e);
            }
        }
        return deleteProduct;
    }
}

