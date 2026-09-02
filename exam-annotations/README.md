# Examen IoT — Variante 1: DI por Anotaciones

## Wiring
`AppConfig` usa `@ComponentScan("com.exam.iot")`. Spring detecta solo las clases
marcadas con `@Repository` (los repos) y `@Service` (el service), y las conecta
usando `@Autowired` en el constructor de `IoTServiceImpl`.

`web.xml` le indica a `ContextLoaderListener` que arranque el contexto con
`AnnotationConfigWebApplicationContext`, apuntando a la clase `AppConfig`.

## Compilar y desplegar
```bash
mvn clean package
# copia target/examen-iot-annotations.war a $CATALINA_HOME/webapps/
```
O en IntelliJ: configura un "Tomcat Server" run config con este módulo como
artifact (war exploded), Deployment Application context: `/examen-iot-annotations`.

## Probar
- `GET /add-form` → formulario HTML para registrar una medición.
- `POST /add-measurement` (params: `assetId`, `timestamp`, `valor`).
- `GET /list-measurements` → tabla HTML con todas las mediciones.

Dispositivo semilla: id=1, rango [-100, 300], samplingPeriod=2000ms, tolerancia=200ms.
Mediciones semilla: timestamp=2000 y 4000.

Ejemplos para probar las reglas de negocio:
- Válida: assetId=1, timestamp=6000, valor=27 (diff=2000, dentro de tolerancia)
- Fuera de rango: assetId=1, timestamp=6000, valor=999
- Timestamp duplicado: assetId=1, timestamp=2000, valor=25
- Intervalo inválido: assetId=1, timestamp=6500, valor=27 (diff=2500, fuera de 1800-2200)
