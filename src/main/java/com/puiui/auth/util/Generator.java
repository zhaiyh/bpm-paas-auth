package com.puiui.auth.util;

import java.io.*;

/**
 * Created by zhaiyinghao on 2016/1/2.
 */
public class Generator {
    public static void main(String[] args) throws IOException {
        daoGenerator("D:\\demo\\webdemo001\\src\\main\\java\\com\\puiui\\auth\\domain",
                "D:\\demo\\webdemo001\\src\\main\\java\\com\\puiui\\auth\\dao");
        serviceGenerator("D:\\demo\\webdemo001\\src\\main\\java\\com\\puiui\\auth\\domain",
                "D:\\demo\\webdemo001\\src\\main\\java\\com\\puiui\\auth\\service");
    }

    public static void daoGenerator(String src, String dest) throws IOException {
        File parent = new File(src);
        File[] children = parent.listFiles();
        if (children == null) {
            return;
        }
        for (File file : children) {
            if (file.isDirectory()) {
                continue;
            }

            String fileName = file.getName();
            String className = fileName.split("\\.")[0];
            System.out.println(className);

            Writer writer = new FileWriter(dest + "\\" + className + "Dao.java");
            writer.write("package com.puiui.auth.dao;\n");
            writer.write("\n");
            writer.write("public interface " + className + "Dao {\n");
            writer.write("\t\n");
            writer.write("}\n");
            writer.flush();
            writer.close();

            Writer implWriter = new FileWriter(dest + "\\impl\\" + className + "DaoImpl.java");
            implWriter.write("package com.puiui.auth.dao.impl;\n");
            implWriter.write("\n");
            implWriter.write("import com.puiui.auth.dao." + className + "Dao;\n");
            implWriter.write("import org.springframework.stereotype.Component;\n");
            implWriter.write("import com.avaje.ebean.EbeanServer;\n");
            implWriter.write("import javax.annotation.Resource;\n");
            implWriter.write("\n");
            implWriter.write("@Component\n");
            implWriter.write("public class " + className + "DaoImpl implements " + className + "Dao {\n");
            implWriter.write("\t@Resource\n");
            implWriter.write("\tprivate EbeanServer ebeanServer;\n");
            implWriter.write("\tpublic EbeanServer getEbeanServer() {\n");
            implWriter.write("\t\treturn ebeanServer;\n");
            implWriter.write("\t}\n");
            implWriter.write("\tpublic void setEbeanServer(EbeanServer ebeanServer) {\n");
            implWriter.write("\t\tthis.ebeanServer = ebeanServer;\n");
            implWriter.write("\t}\n");
            implWriter.write("}\n");
            implWriter.flush();
            implWriter.close();
        }
    }

    public static void serviceGenerator(String src, String dest) throws IOException {
        File parent = new File(src);
        File[] children = parent.listFiles();
        for (File file : children) {
            if (file.isDirectory()) {
                continue;
            }

            String fileName = file.getName();
            String className = fileName.split("\\.")[0];
            System.out.println(className);

            Writer writer = new FileWriter(dest + "\\" + className + "Service.java");
            writer.write("package com.puiui.auth.service;\n");
            writer.write("\n");
            writer.write("public interface " + className + "Service {\n");
            writer.write("\t\n");
            writer.write("}\n");
            writer.flush();
            writer.close();

            Writer implWriter = new FileWriter(dest + "\\impl\\" + className + "ServiceImpl.java");
            implWriter.write("package com.puiui.auth.service.impl;\n");
            implWriter.write("\n");
            implWriter.write("import com.puiui.auth.service." + className + "Service;\n");
            implWriter.write("import org.springframework.stereotype.Component;\n");
            implWriter.write("import com.avaje.ebean.EbeanServer;\n");
            implWriter.write("import javax.annotation.Resource;\n");
            implWriter.write("\n");
            implWriter.write("@Component\n");
            implWriter.write("public class " + className + "ServiceImpl implements " + className + "Service {\n");
            implWriter.write("\t@Resource\n");
            implWriter.write("\tprivate EbeanServer ebeanServer;\n");
            implWriter.write("\tpublic EbeanServer getEbeanServer() {\n");
            implWriter.write("\t\treturn ebeanServer;\n");
            implWriter.write("\t}\n");
            implWriter.write("\tpublic void setEbeanServer(EbeanServer ebeanServer) {\n");
            implWriter.write("\t\tthis.ebeanServer = ebeanServer;\n");
            implWriter.write("\t}\n");
            implWriter.write("}\n");
            implWriter.flush();
            implWriter.close();
        }
    }
}
