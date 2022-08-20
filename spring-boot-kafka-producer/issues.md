## issue

Caused by: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
at sun.security.provider.certpath.SunCertPathBuilder.build(SunCertPathBuilder.java:145) ~[na:1.8.0]
at sun.security.provider.certpath.SunCertPathBuilder.engineBuild(SunCertPathBuilder.java:131) ~[na:1.8.0]
at java.security.cert.CertPathBuilder.build(CertPathBuilder.java:280) ~[na:1.8.0]
at sun.security.validator.PKIXValidator.doBuild(PKIXValidator.java:382) ~[na:1.8.0]
... 26 common frames omitted

2022-08-20 13:36:10.475 ERROR 26384 --- [nio-8080-exec-2] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.kafka.KafkaException: Send failed; nested exception is org.apache.kafka.common.errors.SslAuthenticationException: SSL handshake failed] with root cause

sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
at sun.security.provider.certpath.SunCertPathBuilder.build(SunCertPathBuilder.java:145) ~[na:1.8.0]
at sun.security.provider.certpath.SunCertPathBuilder.engineBuild(SunCertPathBuilder.java:131) ~[na:1.8.0]

## to fix above issue
upgrade to java 11