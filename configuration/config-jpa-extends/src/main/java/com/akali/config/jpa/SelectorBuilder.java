package com.akali.config.jpa;


import com.google.common.collect.Lists;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SelectorBuilder
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/11/8 0004
 * @Version V1.0
 **/
@Data
public class SelectorBuilder {
    List<String> selectorList = Lists.newArrayList();
    public SelectorBuilder append(String ...field){
        selectorList.addAll(Arrays.asList(field));
        return this;
    }

    public List<Selection<?>> bulid(CriteriaBuilder builder, Root<?> root){
        List<Selection<?>> selections = new ArrayList<>();
        for (String item:selectorList) {
            Path<Object> field = root.get(item);
            selections.add(field);
        }
        return selections;
    }

    public static SelectorBuilder create(){
        return new SelectorBuilder();
    }
}
