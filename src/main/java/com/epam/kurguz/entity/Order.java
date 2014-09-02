package com.epam.kurguz.entity;

import java.sql.Date;

public class Order extends User {
    private int order;
    private String client_name;
    private String client_sername;
    private String contry;
    private String product_name;
    private String product_points;
    private String product_price;
    private Date date;


    public Order() {

    }
}
