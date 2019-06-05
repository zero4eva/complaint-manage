package cn.zero4eva.complaint.manage.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "predict")
public class UrlUtil {

    // python解释器地址
    public static String pythonInterpreterPath;
    // 预测算法文件
    public static String predictPythonFilePath;
    // 传输的json文件
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
