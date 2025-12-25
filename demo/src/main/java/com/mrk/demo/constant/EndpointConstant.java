package com.mrk.demo.constant;

public class EndpointConstant {

    public static final String BASE_URL = "/api";

    //fertilizer crud
    public static final String FERTILIZER = "/fertilizer";
    public static final String UPDATE_FERTILIZER = "fertilizer/{id}";
    public static final String GET_FERTILIZER_BY_ID = "/fertilizer/{id}";
    public static final String GET_ALL_FERTILIZERS = "/fertilizers";
    public static final String DELETE_FERTILIZER = "fertilizer/{id}";

    //pesticide crud
    public static final String PESTICIDE = "/pesticide";
    public static final String UPDATE_PESTICIDE = "pesticide/{id}";
    public static final String GET_PESTICIDE_BY_ID = "/pesticide/{id}";
    public static final String GET_ALL_PESTICIDES = "/pesticides";
    public static final String DELETE_PESTICIDE = "pesticide/{id}";

    //seed crud
    public static final String SEED = "/seed";
    public static final String UPDATE_SEED = "seed/{id}";
    public static final String GET_SEED_BY_ID = "/seed/{id}";
    public static final String GET_ALL_SEEDS = "/seeds";
    public static final String DELETE_SEED = "seed/{id}";

    //billing
    public static final String BILLING = "/billing";
    public static final String GENERATE_BILL = "/billing/generate";
}
