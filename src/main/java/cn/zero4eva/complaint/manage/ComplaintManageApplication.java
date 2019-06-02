package cn.zero4eva.complaint.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@MapperScan("cn.zero4eva.complaint.manage.repository")
public class ComplaintManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComplaintManageApplication.class, args);
    }

}
