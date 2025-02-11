package AuthService.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import AuthService.Controllers.AuthenticationController;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class JWTIssuer {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    public static KeyPair generateRSAKeyPair() throws Exception {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    public static final String createToken() throws Exception {

        KeyPair keys = generateRSAKeyPair();
        PublicKey publicKey = keys.getPublic();
        PrivateKey privateKey = keys.getPrivate();

        try {

            Algorithm algorithm = Algorithm.RSA256((java.security.interfaces.RSAPublicKey) publicKey,
                    (java.security.interfaces.RSAPrivateKey) privateKey);
            String token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            logger.error("Error creating token", exception);
            return null;
        }
    }

    public static final void validateToken(String token) throws Exception {

        KeyPair keys = generateRSAKeyPair();
        PublicKey publicKey = keys.getPublic();
        PrivateKey privateKey = keys.getPrivate();

        try {
            Algorithm algorithm = Algorithm.RSA256((java.security.interfaces.RSAPublicKey) publicKey,
                    (java.security.interfaces.RSAPrivateKey) privateKey);

            JWTVerifier verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("auth0")
                    // reusable verifier instance
                    .build();
            verifier.verify(token);

        } catch (JWTVerificationException exception) {
            logger.error("The token is not verified", exception);
        }
    }
}
