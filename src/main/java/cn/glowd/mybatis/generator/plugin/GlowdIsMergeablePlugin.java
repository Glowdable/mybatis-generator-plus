package cn.glowd.mybatis.generator.plugin;

import java.lang.reflect.Field;
import java.util.List;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * mybatis generator IsMergeable plugin ,<tt>set isMergeable = false by reflect<tt>
 * 
 * sqlmapper xml文件覆盖插件，因为<property name="isMergeable" value="false"
 * 不起作用，代码中IntrospectedTableMyBatis3Impl.getGeneratedXmlFiles写死了
 * 
 * @author glowd
 * @date 2018/10/09
 */
public class GlowdIsMergeablePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
