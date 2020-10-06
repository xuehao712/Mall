package com.shawn.mall;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Code used for MBG
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        //MBG warning message
        List<String> warnings = new ArrayList<>();
        //overwrite if duplicate
        boolean overwrite = true;
        //read config
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //create MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //execute code
        myBatisGenerator.generate(null);
        //print warning
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
