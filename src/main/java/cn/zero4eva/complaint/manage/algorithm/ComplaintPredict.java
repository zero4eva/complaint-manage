package cn.zero4eva.complaint.manage.algorithm;

import cn.zero4eva.complaint.manage.model.pojo.CasePredictDTO;
import cn.zero4eva.complaint.manage.util.UrlUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class ComplaintPredict {

    private static ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将预测所需要的信息转化为json存在文件中
     *
     * @param casePredictDTO
     * @throws IOException
     */
    public static void generateJsonFile(CasePredictDTO casePredictDTO) throws IOException {
        String dataJson = MAPPER.writeValueAsString(casePredictDTO);
        File file = new File(UrlUtil.jsonFilePath);
        Writer out = new FileWriter(file);
        out.write(dataJson);
        out.close();
    }

    /**
     * 调用jian的算法，返回结果
     *
     * @param casePredictDTO
     * @return
     * @throws IOException
     */
    public static String predictVisitLetterLevel(CasePredictDTO casePredictDTO) throws IOException {
        ComplaintPredict.generateJsonFile(casePredictDTO);
        String[] arguments = new String[]{UrlUtil.pythonInterpreterPath, UrlUtil.predictPythonFilePath, UrlUtil.jsonFilePath};
        Process process = Runtime.getRuntime().exec(arguments);
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String result = "";
//        python里的运行结果，传给java，用readline
        while ((line = in.readLine()) != null) {
            result += line;
        }
        in.close();
        return result;
    }

    /**
     * 调用qian的算法，返回结果
     *
     * @return
     */
    public static String predictExperts() {
        return "钱洋";
    }
}
