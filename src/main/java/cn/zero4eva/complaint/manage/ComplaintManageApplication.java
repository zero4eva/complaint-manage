package cn.zero4eva.complaint.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.zero4eva.complaint.manage.mapper")
public class ComplaintManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComplaintManageApplication.class, args);
    }

}
