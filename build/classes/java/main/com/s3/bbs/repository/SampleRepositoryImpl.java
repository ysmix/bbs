package com.s3.bbs.repository;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.16.1" }, date = "2018-03-07T19:40:32.494+0900")
public class SampleRepositoryImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.s3.bbs.repository.SampleRepository {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.16.1");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.s3.bbs.repository.SampleRepository.class, "getSampleAll");

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public SampleRepositoryImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<com.s3.bbs.model.Sample> getSampleAll() {
        entering("com.s3.bbs.repository.SampleRepositoryImpl", "getSampleAll");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/s3/bbs/repository/SampleRepository/getSampleAll.sql");
            __query.setEntityType(com.s3.bbs.model._Sample.getSingletonInternal());
            __query.setCallerClassName("com.s3.bbs.repository.SampleRepositoryImpl");
            __query.setCallerMethodName("getSampleAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<com.s3.bbs.model.Sample>> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<com.s3.bbs.model.Sample>(com.s3.bbs.model._Sample.getSingletonInternal()));
            java.util.List<com.s3.bbs.model.Sample> __result = __command.execute();
            __query.complete();
            exiting("com.s3.bbs.repository.SampleRepositoryImpl", "getSampleAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.s3.bbs.repository.SampleRepositoryImpl", "getSampleAll", __e);
            throw __e;
        }
    }

}
