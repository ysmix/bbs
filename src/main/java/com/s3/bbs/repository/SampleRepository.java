package com.s3.bbs.repository;

import com.s3.bbs.model.Sample;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface SampleRepository {

    @Select
    List<Sample> getSampleAll();


}
