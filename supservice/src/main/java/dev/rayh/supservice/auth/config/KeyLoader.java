package dev.rayh.supservice.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Component
public class KeyLoader {

    @Value("${jwt.private-key}")
    private String PRIVATE_KEY;


    public PrivateKey loadPrivateKey() {
        System.out.println("SENHA: "+ PRIVATE_KEY);

        try {
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream(PRIVATE_KEY);

            String key = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            key = key
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s", "");

            byte[] decoded = Base64.getDecoder().decode(key);

            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);

            return KeyFactory.getInstance("RSA").generatePrivate(spec);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar private key", e);
        }
    }
}
