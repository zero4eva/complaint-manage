package cn.zero4eva.complaint.manage.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "predict")
public class UrlUtil {

    public static String pythonInterpreterPath;
    public static String predictPythonFilePath;
    public static String jsonFilePath;

    @Value("${predict.python-interpreter-path}")
    public void setPythonInterpreterPath(String pythonInterpreterPath) {
        UrlUtil.pythonInterpreterPath = pythonInterpreterPath;
    }

    @Value("${predict.predict-python-file-path}")
    public void setPredictPythonFilePath(String predictPythonFilePath) {
        UrlUtil.predictPythonFilePath = predictPythonFilePath;
    }

    @Value("${predict.json-file-path}")
    public void setJsonFilePath(String jsonFilePath) {
        UrlUtil.jsonFilePath = jsonFilePath;
    }
}
