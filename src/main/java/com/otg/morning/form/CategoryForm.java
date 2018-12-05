package com.otg.morning.form;

import lombok.Data;

/**
 * Created by OTG on 2018/11/31.
 */
@Data
public class CategoryForm {

    private Integer categoryId;
    /**类目名字**/
    private String categoryName;
    /** 类目编号**/
    private Integer categoryType;

}
