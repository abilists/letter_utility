package io.utility.letter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class TemplateUtility {

//	public static <T> String mergeTemplateContext(ServletContext context, String tempFile, T tempModel) throws Exception {
//
//        /* Create and adjust the configuration singleton */
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
//        cfg.setServletContextForTemplateLoading(context, "/");
//
//        cfg.setDefaultEncoding("UTF-8");
//        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//        cfg.setLogTemplateExceptions(false);
//
//        /* Create a data-model */
//        Map<String, T> root = new HashMap<>();
//        root.put("model", tempModel);
//
//        /* Get the template (uses cache internally) */
//        Template temp = cfg.getTemplate(tempFile);
//
//        String strMerged = null;
//        try (StringWriter sw = new StringWriter()) {
//            temp.process(root, sw);
//            sw.flush();
//            strMerged = sw.toString();
//        }
//
//        return strMerged;
//	}

	public static <T> boolean mergeTemplate(String tempPath, String tempFile, 
			String outPathAndFile, T tempModel) throws Exception {

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File(tempPath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        /* Create a data-model */
        Map<String, T> root = new HashMap<>();
        root.put("model", tempModel);

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(tempFile);

        try (
        		OutputStream os = new FileOutputStream(outPathAndFile);
                Writer out = new OutputStreamWriter(os);
        ) {
            temp.process(root, out);
        }

		return true;
	}

	public static <T> String mergeTemplate(String tempPath, String tempFile, 
			T tempModel) throws Exception {

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(tempPath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        /* Create a data-model */
        Map<String, T> root = new HashMap<>();
        root.put("model", tempModel);

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(tempFile);

        String strMerged = null;
        try (StringWriter sw = new StringWriter()) {
            temp.process(root, sw);
            sw.flush();
            strMerged = sw.toString();
        }

        return strMerged;

	}

}
