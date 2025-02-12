package kr.co.zerock.b01;

import lombok.extern.log4j.Log4j2;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import kr.co.zerock.b01.config.JasyptConfig;
import kr.co.zerock.b01.config.RootConfig;

@Log4j2
@SpringBootTest(
        properties = "jasypt.encryptor.password=1234567"
)
public class JasyptTest {

    @Autowired
    private StringEncryptor jasyptStringEncryptor;

    @Test
    public void encryptAndDecrypt() {
        String id = "6c45f5b542bd66280bd72f1ee2823bbd";
        String pw = "8xHqTOhAuTB2thktN0syjOM7cjaMMpbW";
        String encryptedId = jasyptStringEncryptor.encrypt(id);
        String encryptedPw = jasyptStringEncryptor.encrypt(pw);
        log.info("id: {}", encryptedId);
        log.info("pw: {}",encryptedPw);
        log.info("----------------------------------");
        log.info("id: {}", jasyptStringEncryptor.decrypt(encryptedId));
        log.info("pw: {}",jasyptStringEncryptor.decrypt(encryptedPw));
    }
}
