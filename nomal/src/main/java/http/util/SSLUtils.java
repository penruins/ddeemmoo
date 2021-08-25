package http.util;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class SSLUtils {
  public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
    SSLContext sslContext = SSLContext.getInstance("TLS");
    //SSLContext sslContext = SSLContext.getInstance("SSLv3");
    X509TrustManager trustManager = new X509TrustManager() {
      @Override
      public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

      }

      @Override
      public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

      }

      @Override
      public X509Certificate[] getAcceptedIssuers() {
        //return new X509Certificate[0];
        return null;
      }
    };
    sslContext.init(null, new TrustManager[] {trustManager}, null);
    return sslContext;
  }
}
