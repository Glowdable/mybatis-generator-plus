package cn.glowd.mybatis.generator.table;

import java.util.List;

import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

/**
 * 
 * @author glowd
 * @date 2018/10/09
 */
public class GlowdIntrospectedTable extends IntrospectedTableMyBatis3Impl {

    protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator, List<String> warnings,
        ProgressCallback progressCallback) {

        xmlMapperGenerator = new XMLMapperGeneratorExtend();
        initializeAbstractGenerator(xmlMapperGenerator, warnings, progressCallback);
    }

    protected AbstractJavaClientGenerator createJavaClientGenerator() {
        if (context.getJavaClientGeneratorConfiguration() == null) {
            return null;
        }

        AbstractJavaClientGenerator javaGenerator;
        javaGenerator = new JavaMapperGeneratorExtend();

        return javaGenerator;
    }

}